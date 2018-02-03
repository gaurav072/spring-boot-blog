package com.startwithjava.simpleblog.aop;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
@Aspect
@Configuration
public class Test {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    //What kind of method calls I would intercept
    //execution(* PACKAGE.*.*(..))
    //Weaving & Weaver
    @Before("ex()")
    public void before(JoinPoint joinPoint){
        //Advice
        logger.info(" Execution for {}", joinPoint);
    }
    @Pointcut("execution(* com.startwithjava.simpleblog..*.*(..))")
    public void ex(){
        System.out.println("111111111111111111111111111");
    }
}
