package manager;

import dao.SkillDao;
import org.springframework.stereotype.Service;
import po.MailPo;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SkillMailManagerImpl implements SkillMailManager{
    @Resource
    private SkillDao skillDao;

    public List<MailPo> querySkillMailsByMemberId(Long memberId) {
        List<MailPo> mailPos = skillDao.querySkillMailsByMemberId(memberId);
        return mailPos;
    }

    public void insertSkillMail(MailPo mailPo) {
        skillDao.insertSkillMail(mailPo);
    }

    public void deleteSkillMailBy(Long mailId) {
        skillDao.deleteSkillMailBy(mailId);
    }

    public void updateSkillMailState(Long mailId, Integer state) {
        MailPo mailPo = skillDao.querySkillMailByMailId(mailId);
        if(mailPo!=null){
            mailPo.setMail_done(state);
            skillDao.updateSkillMailState(mailPo);
        }
    }
}
