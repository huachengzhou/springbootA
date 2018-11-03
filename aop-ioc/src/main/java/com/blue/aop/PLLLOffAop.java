package com.blue.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PLLLOffAop {
    private final Logger logger = Logger.getLogger(getClass());

    @Pointcut(value = "execution(* com.blue.service.PLLLOff.*(..))")
    public void point(){
        logger.info(this.getClass().getSimpleName()+"point()");
    }

    @Before(value = "point()")
    public void aspBefore(){
        logger.info(this.getClass().getSimpleName()+"aspBefore()");
    }

    @After(value = "point()")
    public void aspAfter(){
        logger.info(this.getClass().getSimpleName()+"aspAfter()");
    }

    @AfterReturning(value = "point()",returning = "o")
    public void aspAfterReturning(Object o){
        logger.info(this.getClass().getSimpleName()+"aspAfterReturning params:"+o);
    }

    @AfterThrowing(value = "point()",throwing = "e")
    public void aspAfterThrowing(Exception e){
        logger.info(this.getClass().getSimpleName()+"aspAfterThrowing()");
        logger.error(this.getClass().getSimpleName()+"exception:"+e.getMessage());
    }
}
