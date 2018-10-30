package com.test;


import com.alibaba.druid.pool.DruidDataSource;
import com.blue.service.UserBootService;
import com.blue.spring.ApplicationDemo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;

/**
 * @Author zch
 * @Description
 * @createDate 2018/10/27
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ApplicationDemo.class})
public class ApplicationTest {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    @Qualifier(value = "firstDataSource")
    private DataSource dataSource1;

    @Autowired
    @Qualifier(value = "secondDataSource")
    private DataSource dataSource2;

    @Qualifier(value = "druidDataSource")
    @Autowired
    private DruidDataSource druidDataSource;

    @Autowired
    private UserBootService userBootService;


    @Test
    public void testA() throws Exception {
        System.out.println(dataSource1);
        logger.info("----------------------------------------------------------------------------");
        if (dataSource2 == null) {
            logger.info("null point");
        } else {
            System.out.println(dataSource2);
        }
        logger.info("...............................................................................");
        System.out.println(druidDataSource);
    }
}
