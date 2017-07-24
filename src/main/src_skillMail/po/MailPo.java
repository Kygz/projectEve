package po;


import util.SysUtil;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 技能提醒邮件实体
 *
 * @author KYGZ
 */
public class MailPo {

    private Long mail_id;
    private Long mail_user_id;
    private String mail_user_name;
    private String mail_address;
    private String mail_content;
    private Date mail_createTime;
    private Date mail_time;
    private String mail_timeStr;
    private Integer mail_done;

    public Long getMail_id() {
        return mail_id;
    }

    public void setMail_id(Long mail_id) {
        this.mail_id = mail_id;
    }

    public Long getMail_user_id() {
        return mail_user_id;
    }

    public void setMail_user_id(Long mail_user_id) {
        this.mail_user_id = mail_user_id;
    }

    public String getMail_user_name() {
        return mail_user_name;
    }

    public void setMail_user_name(String mail_user_name) {
        this.mail_user_name = mail_user_name;
    }

    public String getMail_address() {
        return mail_address;
    }

    public void setMail_address(String mail_address) {
        this.mail_address = mail_address;
    }

    public String getMail_content() {
        return mail_content;
    }

    public void setMail_content(String mail_content) {
        this.mail_content = mail_content;
    }

    public Date getMail_createTime() {
        return mail_createTime;
    }

    public void setMail_createTime(Date mail_createTime) {
        this.mail_createTime = mail_createTime;
    }

    public Date getMail_time() {
        return mail_time;
    }

    public void setMail_time(Date mail_time) {
        this.mail_time = mail_time;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        this.mail_timeStr =  sdf.format(this.mail_time);
    }

    public String getMail_timeStr() {
        return mail_timeStr;
    }

    public Integer getMail_done() {
        return mail_done;
    }

    public void setMail_done(Integer mail_done) {
        this.mail_done = mail_done;
    }

    public void setIdIfNew() {
        this.setMail_id(SysUtil.longUUID());
    }
}
