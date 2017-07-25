package manager;

import po.MailPo;
import util.BeanUtils;
import util.MailUtil;

import java.util.TimerTask;
public class MailTimeTask extends TimerTask{

    private Long mailId;
    private String toMailAddress;
    private String toMailName;
    private String content;


    public Long getMailId() {
        return mailId;
    }

    public void setMailId(Long mailId) {
        this.mailId = mailId;
    }

    public String getToMailAddress() {
        return toMailAddress;
    }

    public void setToMailAddress(String toMailAddress) {
        this.toMailAddress = toMailAddress;
    }

    public String getToMailName() {
        return toMailName;
    }

    public void setToMailName(String toMailName) {
        this.toMailName = toMailName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public MailTimeTask(MailPo po) {
        this.mailId = po.getMail_id();
        this.toMailAddress = po.getMail_address();
        this.toMailName = po.getMail_user_name();
        this.content = po.getMail_content();
    }

    public void run() {
        if(MailUtil.sendMail(getToMailAddress(),getToMailName(),getContent())){
            //发送成功
            SkillMailManager skillMailManager = (SkillMailManager)BeanUtils.getBean("skillMailManager");
            skillMailManager.updateSkillMailState(getMailId(),1);
        }else{
            //发送失败
            SkillMailManager skillMailManager = (SkillMailManager)BeanUtils.getBean("skillMailManager");
            skillMailManager.updateSkillMailState(getMailId(),-1);
        }
    }
}
