package com.rps.party.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AfterReturningPartyAspect {

	@AfterReturning("execution(* com.rps.party.PartyService.*(..))") 
	public void givePartyGift() {
		System.out.println("Your party gift!");
	}
}
