package util;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

/**
 * 技能提醒邮件发送
 */
public class MailUtil {
    public static boolean sendMail(MimeMessage mail){
        return false;
    }

    public static MimeMessage createMail(){
        try {
            // 1. 创建一封邮件
            Properties props = new Properties();                // 用于连接邮件服务器的参数配置（发送邮件时才需要用到）
            Session session= Session.getDefaultInstance(props); // 根据参数配置，创建会话对象（为了发送邮件准备的）
            MimeMessage message = new MimeMessage(session);     // 创建邮件对象
            // 2. From: 发件人
            message.setFrom(new InternetAddress("gavin100991@163.com", "米氏在线服务姬器人", "UTF-8"));
            // 3. To: 收件人
            message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress("cc@receive.com", "USER_CC", "UTF-8"));
            //    To: 增加收件人（可选）
            message.addRecipient(MimeMessage.RecipientType.TO, new InternetAddress("dd@receive.com", "USER_DD", "UTF-8"));
            //    Cc: 抄送（可选）
            message.setRecipient(MimeMessage.RecipientType.CC, new InternetAddress("ee@receive.com", "USER_EE", "UTF-8"));
            //    Bcc: 密送（可选）
            message.setRecipient(MimeMessage.RecipientType.BCC, new InternetAddress("ff@receive.com", "USER_FF", "UTF-8"));

            // 4. Subject: 邮件主题
            message.setSubject("技能即将到期", "UTF-8");

            // 5. Content: 邮件正文（可以使用html标签）
            message.setContent("TEST这是邮件正文。。。", "text/html;charset=UTF-8");

            // 6. 设置显示的发件时间
            message.setSentDate(new Date());

            // 7. 保存前面的设置
            message.saveChanges();

            return message;
        } catch (MessagingException e) {
            e.printStackTrace();
            return null;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
