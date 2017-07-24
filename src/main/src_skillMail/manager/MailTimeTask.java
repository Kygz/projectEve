package manager;

import util.MailUtil;

import javax.annotation.Resource;
import java.util.TimerTask;

public class MailTimeTask extends TimerTask{
    @Resource
    private SkillMailManager skillMailManager;
    private Long taskId;
    private Long mailId;
    private String toMailAddress;
    private String toMailName;
    private String content;

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

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

    public MailTimeTask(Long taskId, Long mailId, String toMailAddress, String toMailName, String content) {
        this.taskId = taskId;
        this.mailId = mailId;
        this.toMailAddress = toMailAddress;
        this.toMailName = toMailName;
        this.content = content;
    }

    public void run() {
        if(MailUtil.sendMail(getToMailAddress(),getToMailName(),getContent())){
            //发送成功
            skillMailManager.updateSkillMailState(getMailId(),1);
        }else{
            //发送失败
            skillMailManager.updateSkillMailState(getMailId(),-1);
        }
    }
}
