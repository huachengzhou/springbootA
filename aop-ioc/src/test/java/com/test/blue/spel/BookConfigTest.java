package com.test.blue.spel;

import com.blue.domin.BookA;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BookConfigTest {
    private final ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void testBook(){
        BookA book = (BookA)context.getBean("bookA");
        System.out.println(book);
    }
}
