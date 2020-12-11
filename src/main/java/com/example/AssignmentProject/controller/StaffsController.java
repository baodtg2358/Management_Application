package com.example.AssignmentProject.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;

import javax.mail.internet.MimeMessage;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.AssignmentProject.dto.StaffsDTO;
import com.example.AssignmentProject.entity.Departs;
import com.example.AssignmentProject.entity.Staffs;
import com.example.AssignmentProject.service.DepartsService;
import com.example.AssignmentProject.service.staffsService;
import com.example.AssignmentProject.top10DAO.ProcTop10DAO;

@Controller
@RequestMapping("/staff")
public class StaffsController {
	
	@Autowired
	private DepartsService departsService;
	
	@Autowired
	private staffsService StaffsService;
	
	@Autowired
	private ProcTop10DAO dao;
	
	@Autowired
	private JavaMailSender emailSender;
	
	@GetMapping("/add")
	public String staffForm(ModelMap model) {
		StaffsDTO staff = new StaffsDTO();
		model.addAttribute("staffsDTO",staff);
		model.addAttribute("ACTION","/staff/save");
		return "staff-regis";
		
		
	}
	
	
	
	@PostMapping("/save")
	public String saveorupdate(ModelMap model, @ModelAttribute("StaffsDTO") StaffsDTO DTO, RedirectAttributes riderect) {
		Optional<Staffs> optionalStaff = StaffsService.findByID(DTO.getID());
		String img = "logo.png";
		Path path = Paths.get("uploads/");
		Staffs staff = null;
		if(optionalStaff.isPresent()) {
			
			if(DTO.getPhotos().isEmpty()) {
				img = optionalStaff.get().getPhotos();
			}
			
		}else {
			if(!DTO.getPhotos().isEmpty()) {
				try {
					InputStream inputStream = DTO.getPhotos().getInputStream();
					Files.copy(inputStream, path.resolve(DTO.getPhotos().getOriginalFilename()),
										StandardCopyOption.REPLACE_EXISTING);
					img = DTO.getPhotos().getOriginalFilename().toString();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
		staff = new Staffs(DTO.getID(),DTO.getFullname(),DTO.getBirthday(),DTO.getSex(),
											img,DTO.getSalary(),DTO.getLevels(),
											DTO.getPhones(),DTO.getEmail(),DTO.getAddress(),
											DTO.getNotes(),new Departs(DTO.getDepartsID(),"")); 
		StaffsService.save(staff);
		riderect.addFlashAttribute("successMessage","Save successfully!");
		return "redirect:/";
		
	}
	
	@PostMapping("/email")
	public String SendEmail(@RequestParam("Name") String Name, @RequestParam("Email") String Email, @RequestParam("Link") String Link,
									@RequestParam("Subject") String Subject, @RequestParam("Contents") String Contents, RedirectAttributes redirect) {
		try {
			MimeMessage message =  emailSender.createMimeMessage();
			
			boolean multipart = true;
			
			MimeMessageHelper helper = new MimeMessageHelper(message,multipart,"utf-8");
			
			helper.setTo(Email);
			helper.setSubject(Subject);
			String contents = Contents + "<a href='"+Link+"'>"+Link+"</a>";
			message.setContent(contents,"text/html");
			
			this.emailSender.send(message);
			
			
			
		}catch(Exception e) {
			
			e.printStackTrace();
		}
		
		
		redirect.addFlashAttribute("successMessage","Send Email Successlly!");
		return "redirect:/staff/top10";
	}
	
	@RequestMapping("/edit/{ID}")
	public String edit(@PathVariable("ID") String id, ModelMap model) {
		System.out.println(id);
		Optional<Staffs> optionalStaff = StaffsService.findByID(id);
		
		StaffsDTO dto = null;
		if(optionalStaff.isPresent()) {
			Staffs st = optionalStaff.get();
			File file = new File ("uploads/"+ st.getPhotos());
			FileInputStream input;
			try {
				input = new FileInputStream(file);
				MultipartFile multiphoto = new MockMultipartFile("file", file.getName(),"text/plain",
																	IOUtils.toByteArray(input));
				dto = new StaffsDTO(st.getID(),st.getFullname(),st.getBirthday(),st.getSex(),multiphoto,
												st.getSalary(),st.getLevels(),st.getPhones(),
												st.getEmail(),st.getAddress(),st.getNotes(),st.getDeparts().getID());
			}catch(FileNotFoundException e) {
				e.printStackTrace();
			}catch(IOException e) {
				e.printStackTrace();
			}
			model.addAttribute("staffsDTO",dto);
		}else {
			model.addAttribute ("staffsDTO",new StaffsDTO());
		}
		
		model.addAttribute("ACTION","/staff/save");
		return "staff-regis";
	}
	
	@RequestMapping("/delete/{ID}")
	public String delete(@PathVariable("ID") String ID, RedirectAttributes redirect) {
		StaffsService.delete(ID);
		redirect.addFlashAttribute("successMessage","Delete Successfully!");
		return "redirect:/";
	}
	
		@GetMapping("/top10")
	public String top10(ModelMap model) {
			
			
		model.addAttribute("top10Staffs",dao.getTop10Staffs());
		return "showTOP10";
	}
	
	@ModelAttribute(name="DEPARTS")
	public List<Departs> getAlldeparts(){
		return departsService.findAll();
	}
	

	

	

}
