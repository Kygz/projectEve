package dao;

import po.CalendarEventPo;

import java.util.Date;
import java.util.List;

public interface CalendarDao {
    List<CalendarEventPo> queryCalendarEventPoByMonth(Date startTime ,Date endTime);

    void insertCalendarEventPo(CalendarEventPo po);
}
