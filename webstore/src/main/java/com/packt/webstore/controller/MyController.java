package com.packt.webstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {
	
	@RequestMapping("/webstore")
	public String welcome(Model model){
		model.addAttribute("greeting", "Witaj w sklepie");
		model.addAttribute("tagline", "Jedynym takim sklepie :D");
		
		return "welcome";
	}
	@RequestMapping("/welcome/greeting")
	public String greeting(){
		return "forward:/welcome/greeting";
	}
	
}