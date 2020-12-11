package com.example.AssignmentProject.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;

import javax.persistence.Table;

@Entity
@Table(name = "Departs")
public class Departs {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private int ID;
	
	@Column(name="Departs_name")
	private String Departs_name;
	
	@OneToMany(mappedBy = "departs",fetch = FetchType.LAZY)
	private Set<Staffs> staffs;

	
	
	public Departs() {
		super();
	}
	
	public Departs(String depart_name) {
		Departs_name =depart_name;
	}
	public Departs(Integer iD, String departs_name) {
		
		ID = iD;
		Departs_name = departs_name;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getDeparts_name() {
		return Departs_name;
	}

	public void setDeparts_name(String departs_name) {
		Departs_name = departs_name;
	}

	public Set<Staffs> getStaffs() {
		return staffs;
	}

	public void setStaffs(Set<Staffs> staffs) {
		this.staffs = staffs;
	}
	
	
	
	

	
	

}
