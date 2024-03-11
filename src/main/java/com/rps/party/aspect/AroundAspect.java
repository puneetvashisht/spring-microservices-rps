package com.rps.party.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AroundAspect {
	 @Around("execution(* com.rps.party.PartyService.*(..))") 
	public void audit(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		
		long startTime = System.currentTimeMillis();
		
		// in bw call target
		proceedingJoinPoint.proceed();
		
		
		long endTime = System.currentTimeMillis();
		
		System.out.println("Total Time in ms: " + (endTime-startTime));
	}

}
