package dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import po.ShipAssemblyPo;
import util.DateUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Repository
public class ShipAssemblyStatisticsDaoImpl implements ShipAssemblyStatisticsDao{
    @Autowired
    private SessionFactory sessionFactory;

    public int queryShipAssemblyByDate(Date start, Date end) {
        return 0;
    }

    public List<ShipAssemblyPo> queryShipAssemblyBy7Days(){
        Session session = sessionFactory.getCurrentSession();
        Date timeLine = DateUtil.get7DaysBefore();
        String hql = "from ShipAssemblyPo as ship where ship.shipAssembly_create_time > :timeLine order by ship.shipAssembly_create_time desc ";
        Query query = session.createQuery(hql);
        query.setParameter("timeLine",timeLine);
        query.setMaxResults(7);
        List<ShipAssemblyPo> result = query.list();
        return result;
    }

}
