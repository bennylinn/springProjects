package com.oncewing.ninjaGold;

import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String index(Model model, HttpSession session) {
		if(session.isNew()) {
			session.setAttribute("gold", 0);			
		}
		Integer gold = (Integer) session.getAttribute("gold"); 
		model.addAttribute(gold);
		return "ninja.jsp";
	}
	
	
	@RequestMapping(value="/farm", method=RequestMethod.POST)
	public String farm(HttpSession session, RedirectAttributes redirectAttribute) {
		Integer gold = (Integer) session.getAttribute("gold");
		Random rando = new Random();
		int newGold = rando.nextInt(10) + 10;
		session.setAttribute("gold", gold + newGold);
		redirectAttribute.addFlashAttribute("gain", newGold);
		return "redirect:/";
	}
	
	@RequestMapping(value="/cave", method=RequestMethod.POST)
	public String cave(HttpSession session, RedirectAttributes redirectAttribute) {
		Integer gold = (Integer) session.getAttribute("gold");
		Random rando = new Random();
		int newGold = rando.nextInt(5) + 5;
		session.setAttribute("gold", gold + newGold);
		redirectAttribute.addFlashAttribute("gain", newGold);
		return "redirect:/";
	}
	
	@RequestMapping(value="/house", method=RequestMethod.POST)
	public String house(HttpSession session, RedirectAttributes redirectAttribute) {
		Integer gold = (Integer) session.getAttribute("gold");
		Random rando = new Random();
		int newGold = rando.nextInt(3) + 2;
		session.setAttribute("gold", gold + newGold);
		redirectAttribute.addFlashAttribute("gain", newGold);
		return "redirect:/";
	}
	
	@RequestMapping(value="/casino", method=RequestMethod.POST)
	public String casino(HttpSession session, RedirectAttributes redirectAttribute) {
		Integer gold = (Integer) session.getAttribute("gold");
		Random rando = new Random();
		int newGold = rando.nextInt(100) - 50;
		session.setAttribute("gold", gold + newGold);
		redirectAttribute.addFlashAttribute("gain", newGold);
		return "redirect:/";
	}
}
