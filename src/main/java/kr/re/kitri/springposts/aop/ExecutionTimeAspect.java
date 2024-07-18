package kr.re.kitri.springposts.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class ExecutionTimeAspect {

    @Around("execution(* kr.re.kitri.springposts.controller.PostController.*(..))")
    public Object measureExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        // 메소드 시작전에 수행하는 코드
        long startTime = System.currentTimeMillis();
        Object obj = joinPoint.proceed();
        // 메소드 수행후에 수행되는 코드
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        log.info(joinPoint.getSignature().getName() + "() Execution time: {} ms", executionTime);
        return obj;
    }
}
