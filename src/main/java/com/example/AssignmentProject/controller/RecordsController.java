package com.example.AssignmentProject.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.AssignmentProject.entity.Records;
import com.example.AssignmentProject.entity.Staffs;
import com.example.AssignmentProject.service.RecordsService;
import com.example.AssignmentProject.top10DAO.ProcTop10DAO;

@Controller
@RequestMapping("/records")
public class RecordsController {

	@Autowired
	private RecordsService service;
	
	
	
	private String ID = null;
	
	@GetMapping("/{ID}")
	public String AllRecords(@PathVariable("ID") String StaffsID, ModelMap model) {
			this.ID =StaffsID;
		model.addAttribute("listRecords", service.findAll(StaffsID));
		return "Records";
		
	}
	
	@GetMapping("/add")
	public String add( ModelMap model) {
		Records record = new Records(true, "", LocalDate.now(),new Staffs(ID));
		model.addAttribute("records",record);
		return "newRecords";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute("records") Records record,RedirectAttributes redirect) {
		service.save(record);
		redirect.addFlashAttribute("successMessage","Save Successfully!");
		return "redirect:/records/"+record.getStaffs().getID();
		
	}
	
	
}
