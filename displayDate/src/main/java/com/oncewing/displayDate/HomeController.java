package com.oncewing.displayDate;

import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping("/date")
	public String date(Model model) {
		model.addAttribute("weekday", Calendar.DAY_OF_WEEK);
		model.addAttribute("day", Calendar.DAY_OF_MONTH);
		model.addAttribute("month", Calendar.MONTH);
		model.addAttribute("year", Calendar.YEAR);
		return "date.jsp";
	}
	
	@RequestMapping("/time")
	public String time(Model model) {
		model.addAttribute("hour", Calendar.HOUR);
		model.addAttribute("minute", Calendar.MINUTE);
		return "time.jsp";
	}
}
