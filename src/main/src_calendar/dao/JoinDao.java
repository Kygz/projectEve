package dao;

import po.CalendarJoinPo;

import java.util.List;

public interface JoinDao {
    void insertJoinInfo(CalendarJoinPo po);
    void delJoinInfo(CalendarJoinPo po);
    List<CalendarJoinPo> queryJoinInfoByEventId(Long eventId);
    List<CalendarJoinPo> queryJoinInfoByEventIds(List<Long> eventIdList);
}
