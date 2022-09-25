package com.proje.model;

import java.io.Serializable;
import java.util.Date;

public class UserDetail implements Serializable {
	

	private int userDetailId;
	private String firstName;
	private String lastName;
	private Date  birthDate;
	public UserDetail() {
		
		// TODO Auto-generated constructor stub
	}
	public UserDetail(int userDetailId, String firstName, String lastName, Date birthDate) {
		
		this.userDetailId = userDetailId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
	}
	public int getUserDetailId() {
		return userDetailId;
	}
	public void setUserDetailId(int userDetailId) {
		this.userDetailId = userDetailId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	

}
