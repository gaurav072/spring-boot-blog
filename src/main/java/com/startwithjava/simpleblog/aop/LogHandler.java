/*package com.startwithjava.simpleblog.aop;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
@Aspect
@Configuration
public class LogHandler {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Around("businessMethods0()")
    public Object profile0(ProceedingJoinPoint pjp ) throws Throwable {
        Object output = null;
        try {
            long start = System.currentTimeMillis();
            double startMemory =  (double) (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024;
            logger.info(" Method execution Start=> ( "+pjp.getTarget().getClass().getName()+"->"+pjp.getSignature().getName());
            output = pjp.proceed();
            logger.info(" Output{}", output);
            double availableMemory = (double) (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024;

            double memeoryUsed = startMemory-availableMemory;
            logger.info("Memory Used="+memeoryUsed);

            long elapsedTime = System.currentTimeMillis() - start;
            logger.info(" Method execution time: ( "+pjp.getTarget().getClass().getName()+"->"+pjp.getSignature().getName()+" ) ======" + elapsedTime + " milliseconds.");
        } catch (Exception e) {
            logger.error(e.toString());
        }
        return output;
    }
    @Pointcut("execution(* com.startwithjava.simpleblog..*.*(..))")
    public void businessMethods0() {
        logger.info("=>==Spring Boot Blog Log =>::::");
    }
}
*/