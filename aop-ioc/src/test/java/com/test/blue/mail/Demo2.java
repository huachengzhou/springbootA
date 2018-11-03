package com.test.blue.mail;

import com.blue.domin.Mail;
import com.blue.email.MailUtil;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo2 {
    private ApplicationContext context = null;
    private MailUtil mailUtil = null;

    @Test
    public void isEamil(){
        String[] emails = {"1342662112@qq.com"};
        mailUtil.send("你好吗?","我很好!",emails);
    }

    @Before
    public void ioc(){
        context = new ClassPathXmlApplicationContext("beans.xml");
        Mail mail = (Mail)context.getBean("mailA");
        mailUtil = (MailUtil)context.getBean("mailUtil");
        mailUtil.setMailA(mail);
    }

    String s1 = "<!DOCTYPE html>\n" +
            "<html>\n" +
            "\n" +
            "<head>\n" +
            "<style>\n" +
            "header {\n" +
            "    background-color:black;\n" +
            "    color:white;\n" +
            "    text-align:center;\n" +
            "    padding:5px;\t \n" +
            "}\n" +
            "nav {\n" +
            "    line-height:30px;\n" +
            "    background-color:#eeeeee;\n" +
            "    height:300px;\n" +
            "    width:100px;\n" +
            "    float:left;\n" +
            "    padding:5px;\t      \n" +
            "}\n" +
            "section {\n" +
            "    width:350px;\n" +
            "    float:left;\n" +
            "    padding:10px;\t \t \n" +
            "}\n" +
            "footer {\n" +
            "    background-color:black;\n" +
            "    color:white;\n" +
            "    clear:both;\n" +
            "    text-align:center;\n" +
            "    padding:5px;\t \t \n" +
            "}\n" +
            "</style>\n" +
            "</head>\n" +
            "\n" +
            "<body>\n" +
            "\n" +
            "<header>\n" +
            "<h1>City Gallery</h1>\n" +
            "</header>\n" +
            "\n" +
            "<nav>\n" +
            "London<br>\n" +
            "Paris<br>\n" +
            "Tokyo<br>\n" +
            "</nav>\n" +
            "\n" +
            "<section>\n" +
            "<h1>London</h1>\n" +
            "<p>\n" +
            "London is the capital city of England. It is the most populous city in the United Kingdom,\n" +
            "with a metropolitan area of over 13 million inhabitants.\n" +
            "</p>\n" +
            "<p>\n" +
            "Standing on the River Thames, London has been a major settlement for two millennia,\n" +
            "its history going back to its founding by the Romans, who named it Londinium.\n" +
            "</p>\n" +
            "</section>\n" +
            "\n" +
            "<footer>\n" +
            "Copyright W3Schools.com\n" +
            "</footer>\n" +
            "\n" +
            "</body>\n" +
            "</html>\n";
}
