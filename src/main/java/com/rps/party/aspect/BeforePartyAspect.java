package com.rps.party.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.rps.party.PartyPeople;
import com.rps.party.exceptions.NotOnListException;

@Component
@Aspect
public class BeforePartyAspect {
	
	 PartyPeople[] partyPeoples = {new PartyPeople("rahul"),  
             new PartyPeople("ravi"),            
             new PartyPeople("priya"),            
             new PartyPeople("ankit"),            
             new PartyPeople("Vin Diesel")  
};  
	 
	 
	 @Before("execution(* com.rps.party.PartyService.*(..))") 
		 public void checkGuestList(JoinPoint joinPoint) throws NotOnListException {  
		 	
		 	System.out.println("Before aspect... before hitting target..");
		 	
		      // get method arguments   
		      Object[] args = joinPoint.getArgs();  
		      
		      // getting the method argument using Joinpoint API  
		      PartyPeople partyPeople = (PartyPeople)args[0];  
		      
		      boolean onGuestList = false;  
		      // checking guest list  
		      for (int i = 0; i < partyPeoples.length; i++) {  
		           if (partyPeople.getName().equals(partyPeoples[i].getName())) {  
		                onGuestList = true;  
		                break;  
		           }  
		      }  
		      
		      if (!onGuestList) {  
		    	  System.out.println("throw exception here..");
		           throw new NotOnListException(partyPeople.getName()+" trying to gatecrash.");  
		      }  
		 }  

}
