package com.rps;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDI {

	public static void main(String[] args) {
//		A a = new A();
		
		// Initialization
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		A a = context.getBean( A.class);
		
		// Use 
		a.execute();
		
		// Destroy - shutdown of AC
//		context.

	}

}
