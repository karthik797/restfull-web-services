package com.restfullwebservices.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.restfullwebservices.model.HelloBean;


@RestController
public class DefaultController {

	@GetMapping(path="echo")
	public String helloWOrld()
	{
		return "Hello Appplication";
	}
	
	@GetMapping(path="echo-bean")
	public HelloBean helloBean()
	{
		return new HelloBean("Hello Bean");
	}
	
	@GetMapping(path="echo-path-variable/{name}")
	public HelloBean helloPathVariable(@PathVariable String name)
	{
		return new HelloBean(String.format("Hello %s", name));
		
	}
}
