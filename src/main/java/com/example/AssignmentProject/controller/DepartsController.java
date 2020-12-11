package com.example.AssignmentProject.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.AssignmentProject.entity.Departs;
import com.example.AssignmentProject.service.DepartsService;

@Controller
@RequestMapping("/departs")
public class DepartsController {

	@Autowired
	private DepartsService service;
	
	@GetMapping("")
	public String allDeparts(ModelMap model) {
		model.addAttribute("listDeparts",service.findAll());
		return "showDeparts";
	}
	
	@RequestMapping("/save")
	public String saveOrUpdate(@RequestParam("departsID") String ID, @RequestParam("departsName") String name,ModelMap model, RedirectAttributes redirect ) {
		Departs depart = null;
		
		if(ID != null) {
			Integer IDz = Integer.parseInt(ID);
			depart = new Departs(IDz,name);
			
		}
		depart = new Departs(name);
		service.save(depart);
		redirect.addFlashAttribute("messageSuccess","abc");
		return "redirect:/departs";
	}
	
	
	
	
	@RequestMapping("/delete/{ID}")
	public String delete(@PathVariable("ID") Integer ID, RedirectAttributes redirect) {
		service.delete(ID);
		redirect.addFlashAttribute("successMessage","Deleted successfuly!");
		return "redirect:/departs";
	}

}
