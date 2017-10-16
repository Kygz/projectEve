package manager;


import po.MemberPo;

/**
 * 人员相关
 * @author KYGZ
 *
 */
public interface MemberManager {
	/**
	 * 登陆信息校验
	 * @param name
	 * @param password
	 * @return
	 */
	int checkLogin(String name, String password);

	/**
	 * 根据帐号密码返回人员实体
	 * @param name
	 * @param password
     * @return
     */
	MemberPo queryMemberByIdAndPassword(String name , String password);

	/**
	 * 保存皮肤
	 * @param po
	 */
	void saveSkinByMember(MemberPo po);
	/**
	 * 保存Member 不可重名
	 * @param po
	 * @return
	 */
	String saveMember(MemberPo po);
}
