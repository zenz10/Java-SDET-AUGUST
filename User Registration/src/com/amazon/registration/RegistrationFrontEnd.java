package com.amazon.registration;

import java.util.ArrayList;

public class RegistrationFrontEnd  {

	public static void main(String[] args) {
		
		ArrayList<Customers> AmazonCustomers = new ArrayList<Customers>();
		
		String CustomerName;
		System.out.println("Welcome to amazon.com");

		//User Input ---> scanner class
		
		Customers customer = new Customers();
		
		// ******** Do While Loop ******
		
		// Ask user for an input - First Name
		// Save it in a variable -- name
		// customer.setFirstName(name);
		
		// Ask user for an input - Last Name
		// Save it in a variable -- Lastname
		// customer.setFirstName(Lastname);
		
		
		AmazonCustomers.add(customer);
		
		//System.out.println(CustomerName);
		//david.displayUser();

		Customers adeeko = new Customers("Adeeko");
		adeeko.setFirstName("Adeeko");
		adeeko.setLastName("Adekoya");
		adeeko.setEmailAddress("adeeko@gmail.com");
		AmazonCustomers.add(adeeko);
		
		Customers destiny = new Customers("Adeeko");
		destiny.setFirstName("destiny");
		destiny.setLastName("a");
		destiny.setEmailAddress("asdf@gmail.com");
		AmazonCustomers.add(destiny);
	
		}
	}
