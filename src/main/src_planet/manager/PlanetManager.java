package manager;

import po.PlanetPo;
import po.PlanetRecordResult;

/**
 * 行星开发信息处理
 * @author KYGZ XXOO
 *
 */
public interface PlanetManager {
	/**
	 * 按人头查找当月行星产量
	 * @param userId
	 * @param userName
     * @return
     */
	PlanetRecordResult queryPlanetRecordByMemeberPerMonth(String userId,String userName);
	/**
	 * 上传记录
	 * @param planetPo
	 */
	void insertPlanetRecordById(PlanetPo planetPo);
}
