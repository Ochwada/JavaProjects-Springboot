package com.example.taskmanager.aop;

import com.example.taskmanager.service.TaskService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * *******************************************************
 * Package: com.example.taskmanager.aop
 * File: Logging.java
 * Author: Ochwada
 * Date: Monday, 23.Jun.2025, 3:40 PM
 * Description: This class uses Spring AOP to log method calls in the com.example.taskmanager package and its sub-packages.
 * Objective:
 * *******************************************************
 */
@Aspect // Declares this class as an Aspect (a modular unit of cross-cutting concerns like logging)
@Component // Marks it as a Spring Bean so it's managed by the Spring container
public class Logging {

    /**
     * Logger instance for writing log messages.
     * LoggerFactory.getLogger(this.getClass()) dynamically uses the current class name.
     */
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * Pointcut expression that matches the execution of any method
     * in the com.example.taskmanager package or its sub-packages.
     */
    @Pointcut("execution(* com.example.taskmanager..*(..))")
    public void loggingPointcut() {
        // This method only defines a pointcut; it is not executed.
    }

    /**
     * Logs before a method is executed.
     *
     * @param joinPoint contains method signature and other context info.
     */
    @Before("loggingPointcut()")
    public void logBefore(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().toShortString();
        logger.debug(">>> [BEFORE] Executing: {}", methodName);
    }

    /**
     * Logs after a method has finished (whether successfully or with exception).
     *
     * @param joinPoint contains method signature and other context info.
     */
    @After("loggingPointcut()")
    public void logAfter(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().toShortString();
        logger.debug("<<< [AFTER] Completed: {}", methodName);
    }

    /**
     * Logs when a method returns successfully.
     *
     * @param joinPoint contains method signature and other context info.
     * @param result    the value returned from the method.
     */
    @AfterReturning(pointcut = "loggingPointcut()", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().toShortString();
        logger.info("✔ [RETURN] {} returned: {}", methodName, result);
    }

    /**
     * Logs when a method throws an exception.
     *
     * @param joinPoint contains method signature and other context info.
     * @param ex        the exception thrown.
     */
    @AfterThrowing(pointcut = "loggingPointcut()", throwing = "ex")
    public void logAfterThrowing(JoinPoint joinPoint, Exception ex) {
        String methodName = joinPoint.getSignature().toShortString();
        logger.error("⚠\uFE0F [EXCEPTION] {} threw: {}", methodName, ex.getMessage());
    }

    /**
     * Logs before and after a method execution.
     * Also allows you to control method execution if needed.
     * @param joinPoint provides reflective access to the method.
     * @return the result of the method execution.
     * @throws Throwable if the target method throws any exception.
     */
    @Around("loggingPointcut()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().toShortString();
        logger.info(">>> [AROUND] Before: {}", methodName);
        Object result = joinPoint.proceed(); // Calls the actual method
        logger.info("<<< [AROUND] After: {}", methodName);
        return result;
    }
}

