package dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import po.CalendarJoinPo;

import java.util.List;

@Repository
public class JoinDaoImpl implements JoinDao{
    @Autowired
    private SessionFactory sessionFactory;

    public void insertJoinInfo(CalendarJoinPo po) {
        Session session = sessionFactory.getCurrentSession();
        session.save(po);
    }

    public void delJoinInfo(CalendarJoinPo po) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(po);
    }

    public List<CalendarJoinPo> queryJoinInfoByEventId(Long eventId) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "FROM CalendarJoinPo as c WHERE c.calendar_event_id = ?";
        Query query = session.createQuery(hql);
        query.setParameter(0,eventId);
        List<CalendarJoinPo> list = query.list();
        return list;
    }

    public List<CalendarJoinPo> queryJoinInfoByEventIds(List<Long> eventIdList) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "FROM CalendarJoinPo as c WHERE c.calendar_event_id in (:ids)";
        Query query = session.createQuery(hql);
        query.setParameterList("ids",eventIdList);
        List<CalendarJoinPo> list = query.list();
        return list;
    }

    public CalendarJoinPo queryJoinInfoByEventIdAndMemberId(Long eventId, Long memberId) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "FROM CalendarJoinPo as c WHERE c.calendar_event_id = ? and c.calendar_member_id = ?";
        Query query = session.createQuery(hql);
        query.setParameter(0,eventId);
        query.setParameter(1,memberId);
        CalendarJoinPo po = (CalendarJoinPo) query.uniqueResult();
        return po;
    }
}
