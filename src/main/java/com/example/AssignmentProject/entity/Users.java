package com.example.AssignmentProject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Users")
public class Users {
	
	@Id
	@Column(name = "Username")
	private String Username;
	
	@Column(name="Passsword")
	private String Password;
	
	@Column(name="Fullname")
	private String Fullname;
	
	
	public Users(String username, String password, String fullname) {
		
		Username = username;
		Password = password;
		Fullname = fullname;
	}

	public Users() {}
	
	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getFullname() {
		return Fullname;
	}

	public void setFullname(String fullname) {
		Fullname = fullname;
	}




}
