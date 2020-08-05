package dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import po.ItemPo;
import po.JitaGroupPo;
import util.StringUtil;

import javax.annotation.Resource;
import java.util.ArrayList;
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
     * 列表不为null
     * @param itemId
     * @return
     */
    @Override
    public List<ItemPo> queryJitaItemListByIds(List<Long> itemId) {
        List<ItemPo> result = new ArrayList<>();
        List<Long>[] lists = StringUtil.splitList(itemId, 900);

        Session session = sessionFactory.getCurrentSession();
        String hql = "from ItemPo where item_id = ?";
        Query query = session.createQuery(hql);
        for (List<Long> list : lists) {
            query.setParameter(0,lists);
            result.addAll(query.list());
        }
        return result;
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
