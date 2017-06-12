package dao;

import po.MemberPo;

public interface MemberDao {
	/**
	 * 查询人员
	 * @param name
	 * @return
	 */
	MemberPo queryByName(String name);

	/**
	 * 查询人员
	 * @param id
	 * @return
	 */
	MemberPo queryById(String id);

	/**
	 * 保存皮肤
	 * @param po
	 */
	void saveSkinByMember(MemberPo po);
}
