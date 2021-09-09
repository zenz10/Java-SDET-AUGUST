package com.amazon.registration;

public class Customers {
	
	String firstName;
	private String lastName;
	private int phoneNumber;
	private String emailAddress;
	private String state;
	
	Customers(){
		System.out.println("Register Customer!!");
	}
	
	Customers(String name){
		System.out.println("Hello");
	}
	
	Customers(String name, String Lastname){
		System.out.println("Welcome to Amazon -" + name + " " + Lastname);
	}
	
	public String getFirstName() {
		return firstName.toUpperCase();
		
	}

	public void setFirstName(String firstName) {
		if(firstName.length() <= 20)
		{
		this.firstName = firstName;
		}
		else {
			System.out.println("First name should be less than 20 Char");
		}
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		state = state;
	}




	public void displayUser() {
		System.out.println("Name - " + firstName);
		System.out.println("Last Name - " + lastName);
		System.out.println("Phone Number - " + phoneNumber);
		System.out.println("Email Address - " + emailAddress);
		System.out.println("State - " + state);
	}
	
}
