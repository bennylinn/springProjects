package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
	
	@RequestMapping("/")
	public String slash() {
		return "<h1>Hello world.</h1>";
	}
	
	@RequestMapping("/index")
	public String index() {
		return "<h1>Hello world. This is index.</h1>";
	}
}
