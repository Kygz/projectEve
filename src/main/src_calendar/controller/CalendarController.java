package controller;

import manager.CalendarManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import po.CalendarEventPo;
import po.CalendarEventVo;
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
    /**
     * 增加日程
     * @param session
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=addCalendarEvent", method=RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public String addCalendarEvent(HttpSession session, HttpServletRequest request, HttpServletResponse response){
        MemberPo memberPo = (MemberPo)session.getAttribute("member");
        Map<String,String> resultMap = new HashMap<String, String>();
        if(memberPo==null) {
            resultMap.put("result","false");
            resultMap.put("msg","妖兽啊~~掉线啦~~~");
        }else{
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String title = (String)request.getAttribute("title");
            String content = (String)request.getAttribute("content");
            String start = (String)request.getAttribute("start");
            String end = (String)request.getAttribute("end");
            String allDay = (String)request.getAttribute("allDay");

            try {
                Date startTime = sdf.parse(start);
                Date endTime = sdf.parse(end);
                Calendar startC = Calendar.getInstance();
                startC.setTime(startTime);
                Calendar now = Calendar.getInstance();

                if("1".equals(allDay)){
                    startC.set(startC.get(Calendar.YEAR),startC.get(Calendar.MONTH),startC.get(Calendar.DATE),0,0,0);
                    now.set(startC.get(Calendar.YEAR),now.get(Calendar.MONTH),now.get(Calendar.DATE),0,0,0);
                }else{
                    startC.set(startC.get(Calendar.YEAR),startC.get(Calendar.MONTH),startC.get(Calendar.DATE),startC.get(Calendar.HOUR_OF_DAY),0,0);
                    now.set(startC.get(Calendar.YEAR),now.get(Calendar.MONTH),now.get(Calendar.DATE),now.get(Calendar.HOUR_OF_DAY),0,0);
                }
                if(now.getTime().getTime()>startC.getTime().getTime()){
                    resultMap.put("result","false");
                    resultMap.put("msg","发起时间不能晚于今天！");
                }else{
                    CalendarEventPo po = new CalendarEventPo(memberPo.getMember_id(), title, content, startTime, endTime, Integer.parseInt(allDay), 0);

                }
            } catch (ParseException e) {
                log.error("新建事件《"+title+"》失败！",e);
                resultMap.put("result","false");
                resultMap.put("msg","增加失败！");
            }
            resultMap.put("result","true");
            resultMap.put("msg","增加成功！");

        }
        return SysUtil.createGson().toJson(resultMap);
    }
    /**
     * 增加日程
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
            if(poList!=null){
                for(CalendarEventPo po : poList){
                    voList.add(new CalendarEventVo(po,null,memberPo));
                }
            }
            resultMap.put("result","true");
            resultMap.put("msg","查询成功");
            resultMap.put("list",voList);

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
