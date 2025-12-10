package com.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TestController {
	
	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("msg", "login page");
		model.addAttribute("age", 8);
		model.addAttribute("names", new String[] {"name1", "name2", "name3"});
		return "login";
	}
	
	
	@GetMapping("/view")
	public String view(Model model) {
		model.addAttribute("msg", "view page");
		return "view";
	}
	
	@GetMapping("/loginuser")
	public String home(
			@RequestParam String name,
			@RequestParam String password, Model m) {
	
		m.addAttribute("name", name);
		m.addAttribute("pass", password);
		return "home";
	}

}
