package manager;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import dao.PlanetDao;
import po.PlanetRecordResult;

@Service
public class PlanetManagerImpl implements PlanetManager {
	@Resource
	private PlanetDao planetDao;

	public PlanetRecordResult queryPlanetRecordByMemeberPerMonth(String userId,String userName) {
		PlanetRecordResult preResult = planetDao.queryPlanetRecordByIdAndMonth(userId);
		if(preResult==null){
			preResult = new PlanetRecordResult(userId,userName);
		}
		return preResult;
	}

}
