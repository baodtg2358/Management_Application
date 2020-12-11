package com.example.AssignmentProject.dto;

public class TopStaffs {
	
	private String ID;
	private String Fullname;
	private String Email;
	private String Depart;
	private int count;
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
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getDepart() {
		return Depart;
	}
	public void setDepart(String depart) {
		Depart = depart;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public TopStaffs(String iD, String fullname, String email, String depart, int count) {
		super();
		ID = iD;
		Fullname = fullname;
		Email = email;
		Depart = depart;
		this.count = count;
	}
	public TopStaffs() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
