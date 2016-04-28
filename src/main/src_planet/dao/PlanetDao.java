package dao;

import po.PlanetPo;
import po.PlanetRecordResult;

/**
 * 行星开发数据处理类
 * @author kygz
 *
 */
public interface PlanetDao {
	/**
	 * 按名称查询当月的总产量
	 * @param name
	 * @return
	 */
	PlanetRecordResult queryPlanetRecordByIdAndMonth(String name);
	
	/**
	 * 上传记录
	 * @param planetPo
	 */
	void uploadPlanetRecordById(PlanetPo planetPo);
}
