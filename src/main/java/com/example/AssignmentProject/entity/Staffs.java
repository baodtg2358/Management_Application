package com.example.AssignmentProject.entity;

import java.time.LocalDate;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name = "Staffs")
@NamedStoredProcedureQueries(@NamedStoredProcedureQuery(name = "showTop10",procedureName = "SP_TOP10"))
public class Staffs {
	@Id
	
	@Column(name="ID")
	private String ID;
	
	@Column(name="Fullname")
	private String Fullname;
	
	
	@Column(name = "Birthday")
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate Birthday;
	
	@Column(name="Sex")
	private boolean Sex;
	
	@Column(name="Photos")
	private String Photos;
	
	@Column(name="Salary")
	private double Salary;

	@Column(name="Levels")
	private int Levels;
	
	@Column(name="Phones")
	private String Phones;
	
	@Column(name="Email")
	private String Email;
	
	@Column(name="Addresss")  
	private String Address;
	
	@Column(name="Notes")
	private String Notes;
	
	@ManyToOne
	@JoinColumn(name="Departs_ID",referencedColumnName = "ID")
	private Departs departs;
	
	@OneToMany(mappedBy = "staffs")
	private Set<Records> records;
	
	
	

	public Staffs(String iD, String fullname, LocalDate birthday, boolean sex, String photos, double salary, int levels,
			String phones, String email, String address, String notes, Departs departs) {
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
		this.departs = departs;
	}
	
	public Staffs(String IDs) {
		ID =IDs;
		
	}

	public Staffs() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public double getSalary() {
		return Salary;
	}


	public void setSalary(double salary) {
		Salary = salary;
	}


	public String getPhotos() {
		return Photos;
	}

	public void setPhotos(String photos) {
		Photos = photos;
	}
	public Set<Records> getRecords() {
		return records;
	}

	public void setRecords(Set<Records> records) {
		this.records = records;
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

	public Departs getDeparts() {
		return departs;
	}

	public void setDeparts(Departs departs) {
		this.departs = departs;
	}
	
	
	
	
}
