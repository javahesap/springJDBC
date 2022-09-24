package com.proje.model;

import java.io.Serializable;
import java.util.Date;

public class Personel implements Serializable {
	
	
	private int personelId;
	private String firstName;
	private String lastName;
	private Date birtOfDate;
	private String personelNumber;
	public Personel() {
		
	}
	
	
	
	
	
	public Personel(int personelId, String firstName, String lastName, Date birtOfDate, String personelNumber) {
		super();
		this.personelId = personelId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birtOfDate = birtOfDate;
		this.personelNumber = personelNumber;
	}


	public Personel(String firstName, String lastName, Date birtOfDate, String personelNumber) {
		super();
		this.personelId = personelId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birtOfDate = birtOfDate;
		this.personelNumber = personelNumber;
	}




	public int getPersonelId() {
		return personelId;
	}
	public void setPersonelId(int personelId) {
		this.personelId = personelId;
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
	public Date getBirtOfDate() {
		return birtOfDate;
	}
	public void setBirtOfDate(Date birtOfDate) {
		this.birtOfDate = birtOfDate;
	}
	public String getPersonelNumber() {
		return personelNumber;
	}
	public void setPersonelNumber(String personelNumber) {
		this.personelNumber = personelNumber;
	}





	@Override
	public String toString() {
		return "Personel [personelId=" + personelId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", birtOfDate=" + birtOfDate + ", personelNumber=" + personelNumber + "]";
	}
	

}
