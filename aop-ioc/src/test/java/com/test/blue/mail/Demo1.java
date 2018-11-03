package com.test.blue.mail;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

public class Demo1 {
    public static void main(String[] args) {
        com.blue.domin.Mail mail = new com.blue.domin.Mail();
        mail.setHost("smtp.163.com");                  // 设置邮件服务器
        mail.setSender("noatnu@163.com");  	// 发送邮箱
        mail.setReceiver("1342662112@qq.com");  	// 接收邮箱
        mail.setUsername("noatnu@163.com");      // 登录账号
        mail.setPassword("347191noatnu"); 	// 发件人邮箱的登录密码
        mail.setSubject("发送邮件");
        mail.setMessage("这是一封邮件");
        new Demo1().send(mail);
        System.out.println("success");
    }
    public boolean send(com.blue.domin.Mail mail) {
        // 发送email
        HtmlEmail email = new HtmlEmail();
        try {
            // 这里是SMTP发送服务器的名字"
            email.setHostName(mail.getHost());
            // 字符编码集的设置
            email.setCharset(com.blue.domin.Mail.ENCODEING);
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
            // 发送
            email.send();
            return true;
        } catch (EmailException e) {
            e.printStackTrace();
            return false;
        }
    }
}
