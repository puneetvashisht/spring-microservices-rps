package com.rps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class A {
//	B b = new B();
	
	@Autowired
	B b;
	
	
	public A(B b) {
		super();
		this.b = b;
	}


	public void execute() {
		
		
		b.execute();
		
		System.out.println("Execute in A..");
	}

}
