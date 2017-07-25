package dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import po.MailPo;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class SkillDaoImpl implements SkillDao{
    @Resource
    private SessionFactory sessionFactory;

    public List<MailPo> queryAllSkillMailsByDone(Integer state) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "from  MailPo where mail_done = ? order by mail_createTime desc ";
        @SuppressWarnings("unchecked")
        Query query = session.createQuery(hql).setParameter(0,state);
        List<MailPo> result = query.list();
        return result;
    }

    public List<MailPo> querySkillMailsByMemberId(Long memberId) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "from  MailPo where mail_user_id = ? order by mail_createTime desc ";
        @SuppressWarnings("unchecked")
        Query query = session.createQuery(hql).setParameter(0,memberId);
        List<MailPo> result = query.list();
        return result;
    }

    public MailPo querySkillMailByMailId(Long memberId){
        Session session = sessionFactory.getCurrentSession();
        String hql = "from MailPo where mail_id = ?";
        Query query = session.createQuery(hql).setParameter(0,memberId);
        MailPo mailPo = (MailPo)query.uniqueResult();
        return mailPo;
    }

    public void deleteSkillMailBy(Long mailId) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "from MailPo where mail_id = ?";
        Query query = session.createQuery(hql).setParameter(0,mailId);
        MailPo result = (MailPo) query.uniqueResult();
        if(result != null){
            session.delete(result);
        }
    }

    public void updateSkillMailState(MailPo mailPo) {
        Session session = sessionFactory.getCurrentSession();
        session.update(mailPo);
    }

    public void insertSkillMail(MailPo mailPo) {
        Session session = sessionFactory.getCurrentSession();
        session.save(mailPo);
    }
}
