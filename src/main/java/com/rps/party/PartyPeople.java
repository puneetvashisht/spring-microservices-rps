package com.rps.party;

public class PartyPeople {
	
	String name;
	boolean drunk;
	
	
	
	public PartyPeople(String name, boolean drunk) {
		super();
		this.name = name;
		this.drunk = drunk;
	}
	public PartyPeople(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isDrunk() {
		return drunk;
	}
	public void setDrunk(boolean drunk) {
		this.drunk = drunk;
	}
	
	

}
