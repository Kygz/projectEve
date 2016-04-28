package dao;

import po.MemberPo;

public interface MemberDao {
	/**
	 * 查询人员
	 * @param name
	 * @return
	 */
	MemberPo queryByName(String name);
}
