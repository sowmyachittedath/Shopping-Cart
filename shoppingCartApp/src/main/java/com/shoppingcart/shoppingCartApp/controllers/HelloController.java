package com.shoppingcart.shoppingCartApp.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@Value("${welcome.message}")
	private String welcomeMessage;

//	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	@GetMapping("/hello")

	public String hello() {

		return welcomeMessage;
	}

}
