package controller;

import manager.CalendarManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import po.CalendarEventPo;
import po.MemberPo;
import util.SysUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

@Controller
@RequestMapping("calendar.do")
public class CalendarController {
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
            String title = (String)request.getAttribute("title");
            String start = (String)request.getAttribute("start");
            String end = (String)request.getAttribute("end");
            String allDay = (String)request.getAttribute("allDay");

            resultMap.put("result","true");
            resultMap.put("msg","增加成功！");

        }
        return SysUtil.createGson().toJson(resultMap);
    }

    @RequestMapping(params = "method=index", method= RequestMethod.GET)
    public ModelAndView mailIndex(HttpSession httpSession){
        MemberPo memberPo = (MemberPo)httpSession.getAttribute("member");
        Calendar calendar = Calendar.getInstance();
        if(memberPo==null){
            return new ModelAndView("login");
        }else{
            List<CalendarEventPo> calendarEventPoList = calendarManager.queryCalendarEventPoByMonth(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH)+1);
            ModelAndView mav =  new ModelAndView("calendar/form-calendar");
            mav.addObject("monthEvent",SysUtil.createGson().toJson(calendarEventPoList));
            return mav;
        }
    }
}
