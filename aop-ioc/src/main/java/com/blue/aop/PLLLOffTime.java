package com.blue.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PLLLOffTime {
    private final Logger logger = Logger.getLogger(getClass());

    private long start = 0l;
    private long last = 0l;

    @Pointcut(value = "execution(* com.blue.service.PLLLOff.*(..))")
    public void point(){
        logger.info(this.getClass().getSimpleName()+" point()");
    }

    @Before(value = "point()")
    public void aspBefore(){
        logger.info(this.getClass().getSimpleName()+" aspBefore()");
        start = System.currentTimeMillis();
    }

    @After(value = "point()")
    public void aspAfter(){
        logger.info(this.getClass().getSimpleName()+" aspAfter()");
        last = System.currentTimeMillis();
        logger.info("run time:"+(last-start));
    }
}
