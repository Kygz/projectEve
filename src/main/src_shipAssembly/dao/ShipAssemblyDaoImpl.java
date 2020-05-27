package dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import po.ShipAssemblyPo;

import java.util.List;
import java.util.Map;

@Repository
public class ShipAssemblyDaoImpl implements ShipAssemblyDao {
    @Autowired
    private SessionFactory sessionFactory;

    public void insertShipAssemblyPo(ShipAssemblyPo po) {
        Session session = sessionFactory.getCurrentSession();
        session.save(po);
    }

    public List<ShipAssemblyPo> queryShipAssemblyPo(Map<String, Object> queryParams) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "FROM ShipAssemblyPo as ship where 1=1 ";
        if(queryParams!= null&&queryParams.size()>0){

            if(queryParams.get("id") != null){
                hql += " and ship.shipAssembly_creator_id = :id ";
            }
            if(queryParams.get("title") != null){
                hql += " and ship.shipAssembly_title like %:title% ";
            }
            if(queryParams.get("name") != null){
                hql += " ship.shipAssembly_creator_name like %:name% ";
            }
            if(queryParams.get("scope") != null){
                hql += " and ship.shipAssembly_scope = :scope ";
            }
            if(queryParams.get("useType") != null){
                hql += " and ship.shipAssembly_use_type = :useType ";
            }

            if(queryParams.get("orderBy") != null){
                hql += " order by "+ queryParams.get("orderBy") + " ";
            }else{
                hql += "order by ship.shipAssembly_create_time";
            }
            if(queryParams.get("desc") != null){
                hql += " desc ";
            }else{
                hql += " asc ";
            }
        }
        Query query = session.createQuery(hql);
        if(queryParams!= null&&queryParams.size()>0){
            if(queryParams.get("id") != null){
                query.setParameter("id",queryParams.get("id"));
            }
            if(queryParams.get("title") != null){
                query.setParameter("title",queryParams.get("title"));
            }
            if(queryParams.get("name") != null){
                query.setParameter("name",queryParams.get("name"));
            }
            if(queryParams.get("scope") != null){
                query.setParameter("scope",queryParams.get("scope"));
            }
            if(queryParams.get("useType") != null){
                query.setParameter("useType",queryParams.get("useType"));
            }

            query.setFirstResult(((Integer)queryParams.get("pageNo")-1)*20);
        }
        query.setMaxResults(20);
        if(queryParams.get("pageNo") != null){
            query.setFirstResult(((Integer)queryParams.get("pageNo")-1)*20);
        }else{
            query.setFirstResult(0);
        }
        List<ShipAssemblyPo> list = query.list();
        return list;
    }

    public ShipAssemblyPo queryShipAssemblyPoById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "FROM ShipAssemblyPo as ship where 1=1 and ship.shipAssembly_id = :id";
        Query query = session.createQuery(hql);
        query.setParameter("id",id);
        ShipAssemblyPo o = (ShipAssemblyPo)query.uniqueResult();
        return o;
    }

    /**
     * 取舰船装备
     * select * from jita_items ji where category_1 = '舰船装备';
     * @return
     */
    public List<Object[]> queryAllShipEquipment() {
        Session session = sessionFactory.getCurrentSession();
        String hql = "select jita.item_id, jita.item_name FROM ItemPo as jita where 1=1 and (jita.item_category1 = '舰船装备') ";
        Query query = session.createQuery(hql);
        List<Object[]> result = (List<Object[]>)query.list();
        return result;
    }

    /**
     * 取改装件
     * select * from jita_items ji where category_1 = '舰船和装备改装件' AND category_2 like '改装件';
     * @return
     */
    @Override
    public List<Object[]> queryAllShipMod() {
        Session session = sessionFactory.getCurrentSession();
        String hql = "select jita.item_id, jita.item_name FROM ItemPo as jita where 1=1 and (jita.item_category1 = '舰船和装备改装件' and jita.item_category2 = '改装件') ";
        Query query = session.createQuery(hql);
        List<Object[]> result = (List<Object[]>)query.list();
        return result;
    }

    /**
     * 取子系统
     * select * from jita_items ji where category_1 = '舰船和装备改装件' AND category_2 like '子系统';
     * @return
     */
    @Override
    public List<Object[]> queryAllShipSubsystem() {
        Session session = sessionFactory.getCurrentSession();
        String hql = "select jita.item_id, jita.item_name FROM ItemPo as jita where 1=1 and (jita.item_category1 = '舰船和装备改装件' and jita.item_category2 = '子系统') ";
        Query query = session.createQuery(hql);
        List<Object[]> result = (List<Object[]>)query.list();
        return result;
    }

    /**
     * 取弹药脚本
     * select * from jita_items ji where category_1 = '军火和弹药';
     * @return
     */
    @Override
    public List<Object[]> queryAllShipAmmunitionAndScript() {
        Session session = sessionFactory.getCurrentSession();
        String hql = "select jita.item_id, jita.item_name FROM ItemPo as jita where 1=1 and (jita.item_category1 = '军火和弹药') ";
        Query query = session.createQuery(hql);
        List<Object[]> result = (List<Object[]>)query.list();
        return result;
    }

    /**
     * 取舰船
     * @return
     */
    @Override
    public List<Object[]> queryShipList() {
        Session session = sessionFactory.getCurrentSession();
        String hql = "select jita.item_id, jita.item_name FROM ItemPo as jita where 1=1 and (jita.item_category1 = '舰船') ";
        Query query = session.createQuery(hql);
        List<Object[]> result = (List<Object[]>)query.list();
        return result;
    }
}
