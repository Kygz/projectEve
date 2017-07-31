package manager;

import po.CalendarJoinPo;

import java.util.List;

public interface JoinManager {
    void insertJoinInfo(CalendarJoinPo po);
    void delJoinInfo(CalendarJoinPo po);
    List<CalendarJoinPo> queryJoinInfoByEventId(Long eventId);
    List<CalendarJoinPo> queryJoinInfoByEventIds(List<Long> eventIdList);

}
