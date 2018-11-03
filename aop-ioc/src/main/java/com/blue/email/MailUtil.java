package com.blue.email;

import com.blue.domin.Mail;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.springframework.stereotype.Component;

@Component
public class MailUtil {

    private Mail mailA;

    /**
     * missage 消息 ,subject 主题
     * @param subject
     * @param missage
     * @param eamils
     * @return
     */
    public boolean send(String subject, String missage, String... eamils) {
        boolean flag = false;
        HtmlEmail email = null;
        try {
            // 发送email
            for (int i = 0; i < eamils.length; i++) {
                email = new HtmlEmail();
                mailA.setSubject(subject);
                mailA.setMessage(missage);
                mailA.setReceiver(eamils[i]);
                send(mailA);
            }
        } catch (Exception e) {

        }
        return flag;
    }

    private boolean send(Mail mail) {
        // 发送email
        HtmlEmail email = new HtmlEmail();
        try {
            // 这里是SMTP发送服务器的名字"
            email.setHostName(mail.getHost());
            // 字符编码集的设置
            email.setCharset(Mail.ENCODEING);
            // 收件人的邮箱
            email.addTo(mail.getReceiver());
            // 发送人的邮箱
            email.setFrom(mail.getSender(), mail.getName());
            // 如果需要认证信息的话，设置认证：用户名-密码。分别为发件人在邮件服务器上的注册名称和密码
            email.setAuthentication(mail.getUsername(), mail.getPassword());
            // 要发送的邮件主题
            email.setSubject(mail.getSubject());
            // 要发送的信息，由于使用了HtmlEmail，可以在邮件内容中使用HTML标签
            email.setMsg(mail.getMessage());
//            email.setHtmlMsg(mail.getMessage());//HTML消息
//            email.setDebug(true);//debug模式
            email.setSSLCheckServerIdentity(true);

            // 发送
            email.send();
            return true;
        } catch (EmailException e) {
            e.printStackTrace();
            return false;
        }
    }

    public MailUtil(){}

    public void setMailA(Mail mailA) {
        this.mailA = mailA;
    }
}
