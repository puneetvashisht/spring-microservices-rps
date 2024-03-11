package com.rps.party.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.rps.party.PartyPeople;

@Component
@Aspect
public class AfterPartyAspect {
	
	@After(value = "execution(* com.rps.party.PartyService.*(..))")
	public void sendThanksMail(JoinPoint joinPoint) {
		
	      // get method arguments   
	      Object[] args = joinPoint.getArgs();  
	      
	      // getting the method argument using Joinpoint API  
	      PartyPeople partyPeople = (PartyPeople)args[0]; 
		System.out.println("Email: Thank you for coming!" + partyPeople.getName());
	}

}
