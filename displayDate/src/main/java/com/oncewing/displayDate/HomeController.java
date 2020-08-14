package com.oncewing.displayDate;

import java.util.Calendar;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping("/date")
	public String date(Model model, HttpSession session) {
		model.addAttribute("weekday", Calendar.DAY_OF_WEEK);
		model.addAttribute("day", Calendar.DAY_OF_MONTH);
		model.addAttribute("month", Calendar.MONTH);
		model.addAttribute("year", Calendar.YEAR);
		
		Integer count = 0;			
		if (session.isNew()) {
			session.setAttribute("count", 0);
			System.out.println("New Session");
		} else {
			count = (Integer) session.getAttribute("count") + 1;
			session.setAttribute("count", count);
			System.out.println("Old Session");
		}
		
		model.addAttribute("count", count);
		return "date.jsp";
	}
	
	@RequestMapping("/time")
	public String time(Model model) {
		model.addAttribute("hour", Calendar.HOUR);
		model.addAttribute("minute", Calendar.MINUTE);
		return "time.jsp";
	}
	
    @RequestMapping(value="/code", method=RequestMethod.POST)
    public String code(@RequestParam(value="code") String code, RedirectAttributes redirectAttribute) {
    	System.out.println(code);
    	if ("bushido".equals(code)) {
    		System.out.println("we're correct");
    		return "redirect:/time";
    	} else {
    		redirectAttribute.addFlashAttribute("error", "wrong code son");
    		return "redirect:/";
    	}
    }
}
