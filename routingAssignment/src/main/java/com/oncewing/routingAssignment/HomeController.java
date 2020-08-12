package com.oncewing.routingAssignment;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/coding")
public class HomeController {
	@RequestMapping("")
	public String home() {
		return "Hello coding dojo";
	}
	
	@RequestMapping("/python")
	public String python() {
		return "Python awesome";
	}
	
	@RequestMapping("/java")
	public String java() {
		return "Sping beter";
	}
}
