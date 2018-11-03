package com.blue.ioc.config;

import com.blue.domin.Mail;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import javax.annotation.Resource;

@PropertySource(value = {"classpath:resources_properties/main.properties"})
@Configuration
public class MailConfig {

    @Resource
    private Environment env;

    @Bean(name = "mailA")
    public Mail mailA(){
        Mail mail = new Mail();
        mail.setHost(env.getProperty("mail.163.host"));
        mail.setSender(env.getProperty("mail.163.from"));
        mail.setUsername(env.getProperty("mail.163.username"));
        mail.setPassword(env.getProperty("mail.163.password"));
        return mail;
    }

    @Bean(name = "mailB")
    public Mail mailB(){
        Mail mail = new Mail();
        mail.setHost(env.getProperty("mail.qq.host"));
        mail.setSender(env.getProperty("mail.qq.from"));
        mail.setUsername(env.getProperty("mail.qq.username"));
        mail.setPassword(env.getProperty("mail.qq.password"));
        return mail;
    }

}
