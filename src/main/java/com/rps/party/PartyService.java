package com.rps.party;

import org.springframework.stereotype.Service;

import com.rps.party.exceptions.GotTooDrunkException;

@Service
public class PartyService {
	
	public void letsParty(PartyPeople people) throws GotTooDrunkException {
		
		// check guest list... scattering/tangling
		
		System.out.println("Partying... ");
		if(people.isDrunk()) {
			throw new GotTooDrunkException("got drunk");
		}
		
	}

}
