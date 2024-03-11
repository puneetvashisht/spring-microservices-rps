package com.rps.party.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.rps.party.PartyPeople;

@Component
@Aspect
public class AfterThrowingPartyAspect {
	@AfterThrowing(value= "execution(* com.rps.party.PartyService.*(..))", throwing = "exception") 
	public void callCabForDrunkGuests(JoinPoint joinPoint, Exception exception) {
		
		
		Object[] args = joinPoint.getArgs();  
	      
	      // getting the method argument using Joinpoint API  
	      PartyPeople partyPeople = (PartyPeople)args[0];  
	      System.out.println( partyPeople.getName() + " Got too drunk. Calling cab!");
		System.out.println(exception.getMessage());
	}

}
