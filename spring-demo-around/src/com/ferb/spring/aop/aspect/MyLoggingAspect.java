package com.ferb.spring.aop.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyLoggingAspect {
	
	private Logger LOGGER = Logger.getLogger(MyLoggingAspect.class.getName());
	
	@Around("com.ferb.spring.aop.aspect.MyExpressions.around()")
	public Object aroundGetFortune(ProceedingJoinPoint joinPoint) throws Throwable {
		String method = joinPoint.getSignature().toShortString();
		LOGGER.info("\\n====> Execution @Around on method: " + method);
		
		long begin = System.currentTimeMillis();
		Object result = null;
		
		try {
			result = joinPoint.proceed();
		}catch (Exception e) {
			LOGGER.warning(e.getMessage());
			result = "Major accident but not worry!";
			
			// uncomment following line to rethrow exception
			// throw e;
		}
		
		long end = System.currentTimeMillis();
		
		long duration = end - begin;
		
		LOGGER.info("Duration of the method: " + duration);
		
		return result;
	}

}