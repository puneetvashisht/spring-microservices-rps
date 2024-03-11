package com.rps.springbootdemo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@RequestMapping(path = "/hello",method = RequestMethod.GET)
	public String sayHello() {
		return "Hello RESTful!";
	}
}
