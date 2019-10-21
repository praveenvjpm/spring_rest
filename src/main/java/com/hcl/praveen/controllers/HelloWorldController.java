package com.hcl.praveen.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.praveen.bean.HelloWorldBean;

@RestController
public class HelloWorldController {
	
	//@RequestMapping(method=RequestMethod.GET,path = "/hello-world")
	@GetMapping("/hello-world")
	public String helloworld() {
		return "Hello World";
	}
	
	//@RequestMapping(method=RequestMethod.GET,path = "/hello-world")
		@GetMapping("/hello-world-bean")
		public HelloWorldBean helloworldbean() {
			return new HelloWorldBean("Hello");
		}
		
		@GetMapping(path = "/hello-world-bean/path-variable/{name}")
		public HelloWorldBean helloworldbeanpath(@PathVariable String name) {
			return new HelloWorldBean(String.format("Hello world ,%s", name));
		}

}
