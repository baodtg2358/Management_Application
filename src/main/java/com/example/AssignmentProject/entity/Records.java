package com.example.AssignmentProject.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Records")
public class Records {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Records_ID")
	private int ID;
	
	@Column(name="Typess")
	private boolean Typess;
	
	@Column(name="Reason")
	private String Reason;
	
	
	@Column(columnDefinition ="Dates")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate Dates;
	
	@ManyToOne
	@JoinColumn(name="Staffs_ID",referencedColumnName = "ID")
	private Staffs staffs;

	
	
	public Records() {
		
	}

	public Records( boolean typess, String reason, LocalDate dates, Staffs staffs) {
		super();
		
		Typess = typess;
		Reason = reason;
		Dates = dates;
		this.staffs = staffs;
	}

	public Records(int iD, boolean typess, String reason, LocalDate dates, Staffs staffs) {
		super();
		ID = iD;
		Typess = typess;
		Reason = reason;
		Dates = dates;
		this.staffs = staffs;
	}



	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public boolean getTypess() {
		return Typess;
	}

	public void setTypess(boolean typess) {
		Typess = typess;
	}

	public String getReason() {
		return Reason;
	}

	public void setReason(String reason) {
		Reason = reason;
	}

	public LocalDate getDates() {
		return Dates;
	}

	public void setDates(LocalDate dates) {
		Dates = dates;
	}

	public Staffs getStaffs() {
		return staffs;
	}

	public void setStaffs(Staffs staffs) {
		this.staffs = staffs;
	}
	
	
	

}
