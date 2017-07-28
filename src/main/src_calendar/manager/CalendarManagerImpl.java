package manager;

import dao.CalendarDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import po.CalendarEventPo;
import util.DateUtil;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
@Service
public class CalendarManagerImpl implements CalendarManager{
    @Autowired
    CalendarDao calendarDao;

    public List<CalendarEventPo> queryCalendarEventPoByMonth(int year,int month){
        Date monthFirst = DateUtil.getFirstTimeOfMonth(year,month);
        Date monthLast = DateUtil.getLastTimeOfMonth(year,month);
        List<CalendarEventPo> eventPoList = calendarDao.queryCalendarEventPoByMonth(monthFirst, monthLast);
        return eventPoList;
    }

    public void insertCalendarEventPo(CalendarEventPo po) {
        calendarDao.insertCalendarEventPo(po);
    }
}
