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
}
