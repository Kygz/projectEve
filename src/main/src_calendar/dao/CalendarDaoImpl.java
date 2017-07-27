package dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import po.CalendarEventPo;

import java.util.Date;
import java.util.List;

@Repository
public class CalendarDaoImpl implements CalendarDao{
    @Autowired
    private SessionFactory sessionFactory;

    public List<CalendarEventPo> queryCalendarEventPoByMonth(Date startTime, Date endTime){
        Session session = sessionFactory.getCurrentSession();
        String hql = "SELECT CalendarEventPo FROM CalendarEventPo as c WHERE (c.calendar_startTime >= ? AND c.calendar_startTime <= ?) or (c.calendar_endTime >= ? AND c.calendar_endTime <= ?) ORDER BY c.calendar_startTime";
        Query query = session.createQuery(hql);
        query.setParameter(0,startTime);
        query.setParameter(1,endTime);
        query.setParameter(2,startTime);
        query.setParameter(3,endTime);
        List<CalendarEventPo> list = query.list();
        return list;
    }

}
