package com.example.rest.demo.simplerest.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@RequestMapping("/")
	@ResponseBody
	public String home () {
		return "Hello World";
	}
}
