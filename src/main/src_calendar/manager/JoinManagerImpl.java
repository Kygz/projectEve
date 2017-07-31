package manager;

import dao.JoinDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import po.CalendarJoinPo;

import java.util.ArrayList;
import java.util.List;

@Service
public class JoinManagerImpl implements JoinManager{
    @Autowired
    private JoinDao joinDao;

    public void insertJoinInfo(CalendarJoinPo po) {
        joinDao.insertJoinInfo(po);
    }

    public void delJoinInfo(CalendarJoinPo po) {
        joinDao.delJoinInfo(po);
    }

    public List<CalendarJoinPo> queryJoinInfoByEventId(Long eventId) {
        List<CalendarJoinPo> list = joinDao.queryJoinInfoByEventId(eventId);
        if(list == null){
            list = new ArrayList<CalendarJoinPo>();
        }
        return list;
    }

    public List<CalendarJoinPo> queryJoinInfoByEventIds(List<Long> eventIdList) {
        List<CalendarJoinPo> list = joinDao.queryJoinInfoByEventIds(eventIdList);
        if(list == null){
            list = new ArrayList<CalendarJoinPo>();
        }
        return list;
    }
}
