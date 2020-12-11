package com.example.AssignmentProject.dto;

import java.time.LocalDate;



import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.web.multipart.MultipartFile;

import com.example.AssignmentProject.entity.Departs;

public class StaffsDTO {
	
	
	
	private String ID;
	private String Fullname;
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate Birthday;
	private boolean Sex;
	private MultipartFile Photos;
	private double Salary;
	public double getSalary() {
		return Salary;
	}
	public void setSalary(double salary) {
		Salary = salary;
	}
	private int Levels;
	private String Phones;
	private String Email;
	private String Address;
	private String Notes;
	private Integer departsID;
	
	
	
	
	public StaffsDTO() {
		
	}

	public StaffsDTO(String iD, String fullname, LocalDate birthday, boolean sex, MultipartFile photos, double salary,
			int levels, String phones, String email, String address, String notes, Integer departsID) {
		super();
		ID = iD;
		Fullname = fullname;
		Birthday = birthday;
		Sex = sex;
		Photos = photos;
		Salary = salary;
		Levels = levels;
		Phones = phones;
		Email = email;
		Address = address;
		Notes = notes;
		this.departsID = departsID;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getFullname() {
		return Fullname;
	}
	public void setFullname(String fullname) {
		Fullname = fullname;
	}
	public LocalDate getBirthday() {
		return Birthday;
	}
	public void setBirthday(LocalDate birthday) {
		Birthday = birthday;
	}
	public boolean getSex() {
		return Sex;
	}
	public void setSex(boolean sex) {
		Sex = sex;
	}
	public MultipartFile getPhotos() {
		return Photos;
	}
	public void setPhotos(MultipartFile photos) {
		Photos = photos;
	}
	public int getLevels() {
		return Levels;
	}
	public void setLevels(int levels) {
		Levels = levels;
	}
	public String getPhones() {
		return Phones;
	}
	public void setPhones(String phones) {
		Phones = phones;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getNotes() {
		return Notes;
	}
	public void setNotes(String notes) {
		Notes = notes;
	}
	public Integer getDepartsID() {
		return departsID;
	}
	public void setDepartsID(Integer departsID) {
		this.departsID = departsID;
	}
	
	
}
