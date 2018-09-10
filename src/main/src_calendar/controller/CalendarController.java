package controller;

import manager.CalendarManager;
import manager.JoinManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import po.CalendarEventPo;
import po.CalendarEventVo;
import po.CalendarJoinPo;
import po.MemberPo;
import util.SysUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("calendar.do")
public class CalendarController {
    private static Logger log = Logger.getLogger(CalendarController.class);
    @Autowired
    private CalendarManager calendarManager;
    @Autowired
    private JoinManager joinManager;

    /**
     * 增加日程
     * var eventData = {
     *     title: eventName,
     *     content: eventContent,
     *     start: $('#getStart').val(),
     *     end: $('#getEnd').val(),
     *     allDay : true,
     *     color : normalColor,
     *     idList : []
     * };
     * @param session
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=addCalendarEvent", method=RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public String addCalendarEvent(HttpSession session, HttpServletRequest request, HttpServletResponse response){
        MemberPo memberPo = (MemberPo)session.getAttribute("member");
        Map<String,Object> resultMap = new HashMap<String, Object>();
        if(memberPo==null) {
            resultMap.put("result","false");
            resultMap.put("msg","妖兽啊~~掉线啦~~~");
        }else{
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String title = request.getParameter("title");
            String content = request.getParameter("content");
            String start = request.getParameter("start");
            String end = request.getParameter("end");
            String allDay = request.getParameter("allDay");

            try {
                Date startTime = sdf.parse(start);
                Date endTime = sdf.parse(end);
                Calendar startC = Calendar.getInstance();
                startC.setTime(startTime);
                Calendar endC = Calendar.getInstance();
                endC.setTime(endTime);
                Calendar now = Calendar.getInstance();

                if("true".equals(allDay)){
                    //前台整天时，结束时间为当天的0点，改为最后时刻少续一秒
                    endC.add(Calendar.SECOND,3600*24-1);
                    endTime = endC.getTime();
                    startC.set(startC.get(Calendar.YEAR),startC.get(Calendar.MONTH),startC.get(Calendar.DATE),0,0,0);
                    now.set(startC.get(Calendar.YEAR),now.get(Calendar.MONTH),now.get(Calendar.DATE),0,0,0);
                    now.set(Calendar.MILLISECOND, 0);
                }else{
                    startC.set(startC.get(Calendar.YEAR),startC.get(Calendar.MONTH),startC.get(Calendar.DATE),startC.get(Calendar.HOUR_OF_DAY),0,0);
                    now.set(startC.get(Calendar.YEAR),now.get(Calendar.MONTH),now.get(Calendar.DATE),now.get(Calendar.HOUR_OF_DAY),0,0);
                }

                if(now.after(startC)){
                    resultMap.put("result","false");
                    resultMap.put("msg","发起时间不能晚于今天！");
                }else{
                    CalendarEventPo po = new CalendarEventPo(memberPo.getMember_id(),memberPo.getMember_nickname(), title, content, startTime, endTime, "true".equals(allDay)?1:0, 0);
                    calendarManager.insertCalendarEventPo(po);
                    CalendarEventVo vo = new CalendarEventVo(po,null,memberPo);
                    resultMap.put("result","true");
                    resultMap.put("msg","增加成功！");
                    resultMap.put("event",vo);
                }
            } catch (ParseException e) {
                log.error("新建事件《"+title+"》失败！",e);
                resultMap.put("result","false");
                resultMap.put("msg","增加失败！");
            }


        }
        return SysUtil.createGson().toJson(resultMap);
    }

    /**
     * 按月查日程
     * @param session
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=queryMonth", method=RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public String queryMonth(HttpSession session, HttpServletRequest request, HttpServletResponse response){
        MemberPo memberPo = (MemberPo)session.getAttribute("member");
        Map<String,Object> resultMap = new HashMap<String, Object>();
        if(memberPo==null) {
            resultMap.put("result","false");
            resultMap.put("msg","妖兽啊~~掉线啦~~~");
        }else{
            String year = request.getParameter("year");
            String month = request.getParameter("month");

            List<CalendarEventPo> poList = calendarManager.queryCalendarEventPoByMonth(Integer.parseInt(year), Integer.parseInt(month));
            List<CalendarEventVo> voList = new ArrayList<CalendarEventVo>();
            if(poList!=null&&poList.size()>0){
                List<Long> eventIdList = new ArrayList<Long>();
                for(CalendarEventPo po : poList){
                    eventIdList.add(po.getCalendar_id());
                }
                List<CalendarJoinPo> joinPoList = joinManager.queryJoinInfoByEventIds(eventIdList);
                Map<Long,List<CalendarJoinPo>> joinMap = new HashMap<Long, List<CalendarJoinPo>>();
                for(CalendarJoinPo po : joinPoList){
                    if(joinMap.containsKey(po.getCalendar_event_id())){
                        List<CalendarJoinPo> tempList = joinMap.get(po.getCalendar_event_id());
                        if(tempList == null){
                            tempList= new ArrayList<CalendarJoinPo>();
                        }
                        tempList.add(po);
                        joinMap.put(po.getCalendar_event_id(),tempList);
                    }else{
                        List<CalendarJoinPo> tempList= new ArrayList<CalendarJoinPo>();
                        tempList.add(po);
                        joinMap.put(po.getCalendar_event_id(),tempList);
                    }
                }
                for(CalendarEventPo po : poList){
                    voList.add(new CalendarEventVo(po,joinMap.get(po.getCalendar_id()),memberPo));
                }
            }
            resultMap.put("result","true");
            resultMap.put("msg","查询成功");
            resultMap.put("list",voList);

        }
        return SysUtil.createGson().toJson(resultMap);
    }

    /**
     * 参加Event
     * @param session
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=joinEvent", method=RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public String joinEvent(HttpSession session, HttpServletRequest request, HttpServletResponse response){
        MemberPo memberPo = (MemberPo)session.getAttribute("member");
        Map<String,Object> resultMap = new HashMap<String, Object>();
        if(memberPo==null) {
            resultMap.put("result","false");
            resultMap.put("msg","妖兽啊~~掉线啦~~~");
        }else{
            String eventId = request.getParameter("eventId");

            CalendarJoinPo calendarJoinPo = joinManager.queryJoinInfoByEventIdAndMemberId(Long.parseLong(eventId), memberPo.getMember_id());
            if(calendarJoinPo == null){
                CalendarJoinPo po = new CalendarJoinPo();
                po.setIdIfNew();
                po.setCalendar_event_id(Long.parseLong(eventId));
                po.setCalendar_member_id(memberPo.getMember_id());
                po.setCalendar_member_name(memberPo.getMember_nickname());
                joinManager.insertJoinInfo(po);
                resultMap.put("result","true");
                resultMap.put("msg","添加成功!");
            }else{
                resultMap.put("result","false");
                resultMap.put("msg","请勿重复加入!");
            }
        }
        return SysUtil.createGson().toJson(resultMap);
    }
    /**SkillMailManagerImpl
     * 取消参加Event
     * @param session
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=cancelJoinEvent", method=RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public String cancelJoinEvent(HttpSession session, HttpServletRequest request, HttpServletResponse response){
        MemberPo memberPo = (MemberPo)session.getAttribute("member");
        Map<String,Object> resultMap = new HashMap<String, Object>();
        if(memberPo==null) {
            resultMap.put("result","false");
            resultMap.put("msg","妖兽啊~~掉线啦~~~");
        }else{
            String eventId = request.getParameter("eventId");

            CalendarJoinPo calendarJoinPo = joinManager.queryJoinInfoByEventIdAndMemberId(Long.parseLong(eventId), memberPo.getMember_id());
            if(calendarJoinPo != null){
                joinManager.delJoinInfo(calendarJoinPo);
                resultMap.put("result","true");
                resultMap.put("msg","取消成功!");
            }else{
                resultMap.put("result","false");
                resultMap.put("msg","未加何消!");
            }
        }
        return SysUtil.createGson().toJson(resultMap);
    }

    @RequestMapping(params = "method=index", method= RequestMethod.GET)
    public ModelAndView mailIndex(HttpSession httpSession){
        MemberPo memberPo = (MemberPo)httpSession.getAttribute("member");
        if(memberPo==null){
            return new ModelAndView("login");
        }else{
            return new ModelAndView("calendar/form-calendar");
        }
    }
}
