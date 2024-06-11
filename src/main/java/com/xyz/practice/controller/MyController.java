package com.xyz.practice.controller;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MyController {
	
	@RequestMapping(value="/about",method=RequestMethod.GET)
	public String about(Model model) {
		System.out.println("Inside about handler...");
		model.addAttribute("name","Varsha Rani");
		model.addAttribute("currentDate",new Date().toLocaleString());
		return "about";
	}
	
//	handling iteration
	@GetMapping("/loop")
	public String iterateHandler(Model m) {
		List<String> names = List.of("Varsha","Prachi","Rajesh","sanjula");
		m.addAttribute("names", names);
		return "iterate";
	}
	
//	handling conditional statement
	@GetMapping("/condition")
	public String conditionHandler(Model m) {
		System.out.println("conditional statement handler executed..");
		m.addAttribute("isActive",true);
		m.addAttribute("gender","F");
		List<Integer> nums = List.of(10,20,30,40,50);
		m.addAttribute("myList",nums);
		return "condition";
	}
	
//	handling for including fragments
	@GetMapping("/service")
	public String serviceHandler(Model m) {
		System.out.println("including fragment handler executed..");
		m.addAttribute("title","This is my title");
		m.addAttribute("subtitle",LocalDateTime.now().toString());
		return "service";
	}
	
//	handling for inheriting template
	@GetMapping("/newAbout")
	public String newAboutHandler() {
		return "newAbout";
	}
	@GetMapping("/contact")
	public String contactHandler() {
		return "contact";
	}
}
