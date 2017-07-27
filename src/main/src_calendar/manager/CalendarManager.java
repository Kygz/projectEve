package manager;

import po.CalendarEventPo;

import java.util.List;

public interface CalendarManager {
    /**
     * 当月及上下两月
     * @param month 当月月份
     * @return
     */
    List<CalendarEventPo> queryCalendarEventPoByMonth(int year,int month);
}
