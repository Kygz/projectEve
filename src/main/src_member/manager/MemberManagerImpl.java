package manager;

import dao.MemberDao;
import po.MemberPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberManagerImpl implements MemberManager {
    @Autowired
	private MemberDao memberDao;

    public int checkLogin(String name, String password) {
        MemberPo tempMember = memberDao.queryByName(name);
        if(tempMember==null){
            return 0;//帐号不存在
        }
        if(!password.equals(tempMember.getMember_password())){
            return 1;//密码错误
        }
        return 2;//未知错误
    }

    public MemberPo queryMemberByIdAndPassword(String name, String password) {
        MemberPo tempMember = memberDao.queryByName(name);
        if((tempMember != null) && password.equals(tempMember.getMember_password())){
            tempMember.setMember_password("hehe");
            return tempMember;
        }
        return null;
    }

    public void saveSkinByMember(MemberPo po) {
        memberDao.saveSkinByMember(po);
    }
}
