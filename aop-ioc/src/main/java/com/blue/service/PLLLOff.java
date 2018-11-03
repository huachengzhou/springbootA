package com.blue.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import tool.help.Zhou_StdRandom;
import tool.help.Zhou_String;

@Component(value = "pllloff")
public class PLLLOff {
    private  Logger logger = LoggerFactory.getLogger(getClass());

    public void pllOff(){
        int num = Zhou_StdRandom.uniform(5,20);
        String uuid = Zhou_String.toOther(num);
        logger.info("------------------>>");
        for (int i = 0; i < Zhou_StdRandom.uniform(3,8); i++) {
            logger.info("<==   ............");
        }
        logger.info(""+uuid);
    }
}
