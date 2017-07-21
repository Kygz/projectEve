package manager;

import org.springframework.beans.factory.annotation.Autowired;
import util.MailUtil;

import java.util.TimerTask;

public class MailTimeTask extends TimerTask{
    @Autowired
    private TimelineManager timelineManager;
    private Long taskId;
    private String toMailAddress;
    private String toMailName;
    private String content;

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
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

    public MailTimeTask(Long taskId, String toMailAddress, String toMailName, String content) {
        this.taskId = taskId;
        this.toMailAddress = toMailAddress;
        this.toMailName = toMailName;
        this.content = content;
    }

    public void run() {
        if(MailUtil.sendMail(getToMailAddress(),getToMailName(),getContent())){
            //发送成功
        }else{
            //发送失败
        }
    }
}
