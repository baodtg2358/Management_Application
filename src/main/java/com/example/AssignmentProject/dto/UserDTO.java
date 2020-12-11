package com.example.AssignmentProject.dto;

import javax.validation.constraints.NotEmpty;

public class UserDTO {
	
	@NotEmpty
	private String Username;
	
	@NotEmpty
	private String Password;
	
	@NotEmpty
	private String ConfirmPassword;
	
	@NotEmpty
	private String Fullname;
	
	

	public UserDTO() {
		
	}
	
	public UserDTO(String username, String password, String confirmPassword, String fullname) {
		super();
		Username = username;
		Password = password;
		ConfirmPassword = confirmPassword;
		Fullname = fullname;
	}

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
	public String getConfirmPassword() {
		return ConfirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		ConfirmPassword = confirmPassword;
	}
	public String getFullname() {
		return Fullname;
	}
	public void setFullname(String fullname) {
		Fullname = fullname;
	}
}
