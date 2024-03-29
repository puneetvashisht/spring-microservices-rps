package com.rps;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.rps.party.PartyPeople;
import com.rps.party.PartyService;
import com.rps.party.exceptions.GotTooDrunkException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:beans.xml")
public class TestPartyService {
	
	@Autowired
	PartyService partyService;

	@Test
	public void test() {
		PartyPeople p1 = new PartyPeople("ravi", false);
		try {
			partyService.letsParty(p1);
		} catch (GotTooDrunkException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
