package dao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import po.PlanetPo;
import po.PlanetRecordResult;
import util.DateUtil;


@Repository
public class PlanetDaoImpl implements PlanetDao {
	@Resource
	private SessionFactory sessionFactory;
	
	public PlanetRecordResult queryPlanetRecordByIdAndMonth(String id) {
		Session session = sessionFactory.getCurrentSession();
		String firstDay = DateUtil.getFirstDayOfMonth(new Date());
		String lastDay = DateUtil.getLastDayOfMonth(new Date());
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT any_value(planet.planet_user_name),");
		sql.append("Sum(planet.planet_star_1),");
		sql.append("Sum(planet.planet_star_2),");
		sql.append("Sum(planet.planet_star_3),");
		sql.append("Sum(planet.planet_star_4),");
		sql.append("Sum(planet.planet_star_5),");
		sql.append("Sum(planet.planet_star_6),");
		sql.append("Sum(planet.planet_star_7) ");
		sql.append("FROM ");
		sql.append("planet ");
		sql.append("WHERE ");
		sql.append("planet.planet_user_id = '" + id + "'");
		sql.append(" AND ");
		sql.append("planet.planet_upload_date BETWEEN '"+firstDay+"' AND '"+lastDay+"' ");
		sql.append("GROUP BY ");
		sql.append("planet.planet_user_id");
		@SuppressWarnings("unchecked")
		List<Object[]> result = session.createSQLQuery(sql.toString()).list();
		if(result.size()==1){
			Object[] obj= result.get(0);
			PlanetRecordResult pr = new PlanetRecordResult(id,String.valueOf(obj[0]));
			pr.setPlanet_star1(((BigDecimal) obj[1]).longValue());
			pr.setPlanet_star2(((BigDecimal) obj[2]).longValue());
			pr.setPlanet_star3(((BigDecimal) obj[3]).longValue());
			pr.setPlanet_star4(((BigDecimal) obj[4]).longValue());
			pr.setPlanet_star5(((BigDecimal) obj[5]).longValue());
			pr.setPlanet_star6(((BigDecimal) obj[6]).longValue());
			pr.setPlanet_star7(((BigDecimal) obj[7]).longValue());
			return pr;
		}else{
			return null;
		}
	}

	public void uploadPlanetRecordById(PlanetPo planetPo) {
		Session session = sessionFactory.getCurrentSession();
		session.save(planetPo);
	}

	public List<PlanetPo> queryPlanetPoFiveByUserId(String userId) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from PlanetPo where planet_user_id = ? order by planet_update_date desc ";
		@SuppressWarnings("unchecked")
		Query query = session.createQuery(hql).setParameter(0,userId).setMaxResults(5);
		List<PlanetPo> result = query.list();
		return result;
	}

}
