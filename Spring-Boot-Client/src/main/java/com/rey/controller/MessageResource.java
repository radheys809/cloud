package com.rey.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class MessageResource {
	
	@Value("${message: hello default}")
	private String message;
	
	@GetMapping(value = "/message")
	public String helloResource() {
		 return message;
	}

}
