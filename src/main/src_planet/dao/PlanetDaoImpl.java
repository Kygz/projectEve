package dao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

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
		String sql = "SELECT planet.planet_user_name,"
				+ "Sum(planet.planet_star_1),"
				+ "Sum(planet.planet_star_2),"
				+ "Sum(planet.planet_star_3),"
				+ "Sum(planet.planet_star_4),"
				+ "Sum(planet.planet_star_5),"
				+ "Sum(planet.planet_star_6),"
				+ "Sum(planet.planet_star_7) "
				+ "FROM "
				+ "planet "
				+ "WHERE "
				+ "planet.planet_user_id = '" + id + "'"
				+ " AND "
				+ "planet.planet_upload_date BETWEEN '"+firstDay+"' AND '"+lastDay+"' "
				+ "GROUP BY "
				+ "planet.planet_user_id";
		@SuppressWarnings("unchecked")
		List<Object[]> result = session.createSQLQuery(sql).list();
		if(result.size()==1){
			//TODO 测试语句待删
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
		// TODO Auto-generated method stub
	}

}
