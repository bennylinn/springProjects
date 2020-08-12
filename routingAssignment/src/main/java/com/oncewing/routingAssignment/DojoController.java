package com.oncewing.routingAssignment;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DojoController {
	@RequestMapping("/dojo")
	public String dojo() {
		return "Dojo awseome";
	}
	
	@RequestMapping("/burbank-dojo")
	public String brubank() {
		return "Burbank in Southern Cali";
	}
	
	@RequestMapping("/san-jose")
	public String sj() {
		return "SJ HQ awesome";
	}
}
