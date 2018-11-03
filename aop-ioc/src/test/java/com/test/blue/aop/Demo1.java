package com.test.blue.aop;

import com.blue.service.PLLLOff;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author zch
 * @Description
 * @createDate 2018/11/3
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:beans.xml"})
public class Demo1 {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private PLLLOff plllOff;

    @Test
    public void testA(){
        plllOff.pllOff();
    }
}
