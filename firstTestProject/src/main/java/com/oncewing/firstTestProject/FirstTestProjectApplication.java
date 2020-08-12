package com.oncewing.firstTestProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class FirstTestProjectApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(FirstTestProjectApplication.class, args);
	}

	@RequestMapping("/")
	public String hello() {
		return "Hello World";
	}
}
