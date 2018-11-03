package com.blue.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class UserOPPAOP {

    private final Logger logger = Logger.getLogger(getClass());

    @Pointcut(value = "execution (* com.blue.service.UserOPP.*(..))")
    public void point(){
        logger.info(this.getClass().getSimpleName()+"point()");
    }

    @Before(value = "point()")
    public void aspBefore(){
        logger.info(this.getClass().getSimpleName()+"aspBefore()");
    }

    /**
     * 环绕通知
     * @param joinPoint
     */
    @Around(value = "point()")
    public void asp(ProceedingJoinPoint joinPoint){
        try {
            System.out.println("before() "+System.currentTimeMillis());
            //获取参数
            Object obj = joinPoint.proceed();//这里也可以直接传入参数...
            System.out.println("params:"+obj);
            System.out.println("after() "+System.currentTimeMillis());
        }catch (Throwable e){
            System.out.println("exception");
        }
    }
}
