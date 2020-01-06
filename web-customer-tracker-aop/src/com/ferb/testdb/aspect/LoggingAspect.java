package com.ferb.testdb.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	private Logger LOGGER = Logger.getLogger(LoggingAspect.class.getName());

	@Pointcut("execution(* com.ferb.testdb.controller.*.*(..))")
	public void forControllerPointcut() { }

	@Pointcut("execution(* com.ferb.testdb.service.*.*(..))")
	public void forServicePointcut() { }

	@Pointcut("execution(* com.ferb.testdb.dao.*.*(..))")
	public void forDaoPointcut() { }
	
	@Pointcut("forControllerPointcut() || forDaoPointcut() || forServicePointcut()")
	public void forAppFlow() { }
	
	@Before("forAppFlow()")
	public void forAppFlowAdvice(JoinPoint joinPoint) {
		String theMethod = joinPoint.getSignature().toShortString();
		LOGGER.info("\n----->>> In @Before Advice, method name: " + theMethod);
		
		Object[] args = joinPoint.getArgs();
		for(Object theArg: args) {
			LOGGER.info("----->>> argument: " + theArg.toString());
		}
	}
	
	@AfterReturning(pointcut="forAppFlow()",
					returning="result")
	public void afterReturningAspect(JoinPoint joinPoint, Object result) {
		String theMethod = joinPoint.getSignature().toShortString();
		LOGGER.info("\n----->>> In @AfterReturning Advice, method name: " + theMethod);
		
		LOGGER.info("----->>> result: " + result);
		
	}
}
