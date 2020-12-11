package com.example.AssignmentProject.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.example.AssignmentProject.dto.UserDTO;
import com.example.AssignmentProject.entity.Users;
import com.example.AssignmentProject.reporitory.userRepository;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private userRepository repo;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@GetMapping("")
	public String listUser(ModelMap model) {
		model.addAttribute("listUser", repo.findAll());
		return "userInfo";
		
	}
	
//	New account
	@GetMapping("/add")
	public String UserForm(ModelMap model) {
		UserDTO dto = new UserDTO();
		model.addAttribute("userDTO",dto);
		return "user-regis";
	}
	
//	Save or update account
	@PostMapping("/save")
	public String saveorUpdate(@ModelAttribute("userDTO") @Validated UserDTO userDto,BindingResult result ,RedirectAttributes redirect ) {
		
			Users user = null;
		if(result.hasErrors()) {
			return "redirect:/add";
			}
		
		user = new Users(userDto.getUsername(), passwordEncoder.encode(userDto.getPassword()),userDto.getFullname());
		redirect.addFlashAttribute("successMessage","Save successfully!");
		repo.save(user);
		return "redirect:/user";
	}
	
//	Edit account
	@RequestMapping("/edit/{ID}")
	public String eidt(@PathVariable("ID") String ID, ModelMap model) {
		Users user = repo.findById(ID).get();
		UserDTO dto = new UserDTO(user.getUsername(),user.getPassword(),user.getPassword(),user.getFullname());
		model.addAttribute("userDTO",dto);
		return "user-regis";
	}
	
//	Delete account
	@RequestMapping("/delete/{ID}")
	public String delete(@PathVariable("ID") String ID, ModelMap model, RedirectAttributes redirect) {
		repo.deleteById(ID);
		redirect.addFlashAttribute("successMessage", "Deleted successfully!");
		return "redirect:/user";
	}

}
