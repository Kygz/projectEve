package dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import po.ItemPo;

import javax.annotation.Resource;
import java.util.List;

/**
 * JitaDao
 */
@Repository
public class JitaDaoImpl implements JitaDao{
    @Resource
    private SessionFactory sessionFactory;

    public List<ItemPo> queryJitaItemByName(String itemName) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "from ItemPo where item_name like ? order by item_name asc ";
        Query query = session.createQuery(hql).setParameter(0,"%"+itemName+"%").setMaxResults(5);
        List<ItemPo> result = query.list();
        return result;
    }
}
