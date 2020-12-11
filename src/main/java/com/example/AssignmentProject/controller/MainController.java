package com.example.AssignmentProject.controller;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.AssignmentProject.entity.Staffs;
import com.example.AssignmentProject.service.staffsService;



@Controller
public class MainController {
																									
	@Autowired
	private staffsService StaffsService;
	
	@GetMapping("/")
	public String index(ModelMap model) {
		
		model.addAttribute("all_staffs",StaffsService.findAll());
		
		return "HomePage";
	}
	
	@GetMapping("/login")
	public String Login(Model model) {
		
		return "login";
	}
	
	@GetMapping("/HomePage")
	public String HomePage() {
		return "HomePage";
	}
	
	
	
	
	
	
}
