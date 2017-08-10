package dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import po.RolePo;

@Repository
public class RoleDaoImpl implements RoleDao {
    @Autowired
    private SessionFactory sessionFactory;


    public RolePo queryRoleById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from RolePo where role_id = :id");
        query.setString("id", id.toString());
        return (RolePo)query.uniqueResult();
    }

    public RolePo queryRoleByKey(String key) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from RolePo where role_key = :key");
        query.setString("key", key);
        return (RolePo)query.uniqueResult();
    }

    public void insertRole(RolePo po) {
        Session session = sessionFactory.getCurrentSession();
        session.save(po);
    }

    public void updateRole(RolePo po) {
        Session session = sessionFactory.getCurrentSession();
        session.update(po);
    }
}
