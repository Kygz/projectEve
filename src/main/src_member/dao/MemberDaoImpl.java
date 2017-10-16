package dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import po.MemberPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDaoImpl implements MemberDao {
	@Autowired
	private SessionFactory sessionFactory;

	public MemberPo queryByName(String name) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from MemberPo where member_name = :name");
		query.setString("name", name);
		return (MemberPo)query.uniqueResult();
	}
	public MemberPo queryById(String id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from MemberPo where member_id = :id");
		query.setString("id", id);
		return (MemberPo)query.uniqueResult();
	}

	public void saveSkinByMember(MemberPo po) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from MemberPo where member_id = :id");
		query.setString("id", po.getMember_id().toString());
		MemberPo member = (MemberPo) query.uniqueResult();
		member.setMember_skin(po.getMember_skin());
		session.update(member);
	}

	public void saveMember(MemberPo po) {
		Session session = sessionFactory.getCurrentSession();
		session.save(po);
	}

}
