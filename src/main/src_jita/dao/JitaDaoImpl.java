package dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import po.ItemPo;
import po.JitaGroupPo;

import javax.annotation.Resource;
import java.util.List;

/**
 * JitaDao
 */
@Repository
public class JitaDaoImpl implements JitaDao{
    @Resource
    private SessionFactory sessionFactory;

    public ItemPo queryJitaItemById(Long itemId){
        Session session = sessionFactory.getCurrentSession();
        String hql = "from ItemPo where item_id = ?";
        Query query = session.createQuery(hql).setParameter(0,itemId);
        return (ItemPo)query.uniqueResult();
    }

    /**
     * 取名字相近的前5个物品结果 按相似度排序
     * @param itemName
     * @return
     */
    public List<ItemPo> queryJitaItemByName(String itemName) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "from ItemPo where item_name like ? order by length(replace(item_name,?,'')) asc";
        Query query = session.createQuery(hql).setParameter(0,"%"+itemName+"%").setParameter(1,itemName).setMaxResults(5);
        List<ItemPo> result = query.list();
        return result;
    }

    public List<JitaGroupPo> queryJitaGroupsByUserId(Long userId){
        Session session = sessionFactory.getCurrentSession();
        String hql = "from JitaGroupPo where userId = ? order by createDate desc ";
        Query query = session.createQuery(hql).setParameter(0,userId);
        List<JitaGroupPo> result = query.list();
        return result;
    }

    @Override
    public JitaGroupPo queryJitaGroupsBySectionIdAndUserId(Long sectionId, Long userId) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "from JitaGroupPo where userId = ? and id = ?";
        Query query = session.createQuery(hql).setParameter(0,userId).setParameter(1,sectionId);
        return (JitaGroupPo)query.uniqueResult();
    }

    @Override
    public void deleteJitaGroupsBySectionIdAndUserId(Long sectionId, Long userId) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "delete JitaGroupPo where userId = ? and id = ?";
        Query query = session.createQuery(hql).setParameter(0,userId).setParameter(1,sectionId);
        query.executeUpdate();
    }

    public void saveJitaGroup(JitaGroupPo jitaGroupPo){
        Session session = sessionFactory.getCurrentSession();
        session.save(jitaGroupPo);
    }
}
