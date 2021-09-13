

package com.user;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.regex.Pattern;

public class UsersManager {

	public static void main(String[] args) {
		
		String jdbcURL = "jdbc:mysql://databasetest.ckynhyystcw6.us-west-1.rds.amazonaws.com:3306/sampledb";
		String dbusername = "admin";
		String dbpassword = "asdf1234";
		
		
		Scanner s = new Scanner(System.in);

		int ch;
		do {
			System.out.println("1.Insert");
			System.out.println("2.DISPLAY");
			System.out.println("3.SEARCH");
			System.out.println("4.DELETE");
			System.out.println("5.UPDATE");
			System.out.print("Enter Your Choice: ");
			ch = s.nextInt();
			
			switch(ch) {
			case 1:

				
				System.out.print("Enter First Name: ");
				int fn = 0;
				String firstname1 = "";
				do {
					Scanner FName = new Scanner(System.in);
					firstname1 = FName.nextLine();
					if (validateFirstName(firstname1))
					{
						fn = 1;
					}
					else
					{
						System.out.print("Invalid first name re-enter: ");
					}
				}while (fn ==0);

				
			    System.out.print("Enter Last Name: ");
				int ln = 0;
				String lastname1 = "";
				do {
					Scanner LName = new Scanner(System.in);
					lastname1 = LName.nextLine();
					if (validateFirstName(lastname1))
					{
						ln = 1;
					}
					else
					{
						System.out.print("Invalid last name re-enter: ");
					}
				}while (ln ==0);
				
			    System.out.print("Enter Phone Number: ");
				int ph = 0;
			    String phonenumber1 = "";
				do {
					Scanner pNum = new Scanner(System.in);
					phonenumber1 = pNum.nextLine();
					if (validatephone(phonenumber1))
					{
						ph = 1;
					}
					else
					{
						System.out.print("Invalid phone number re-enter: ");
					}
				}while (ph ==0);
				
			    System.out.print("Enter Username: ");
			    String username1 = "";
				int us = 0;
				do {
					Scanner uName = new Scanner(System.in);
					username1 = uName.nextLine();
					if (validateuname(username1))
					{
						us = 1;
					}
					else
					{
						System.out.print("Invalid user name re-enter: ");
					}
				}while (us ==0);
				
			    System.out.print("Enter Email Address: ");
			    String email1 = "";
				int a = 0;
			    do {
			    	Scanner inemail = new Scanner(System.in);
			    	email1 = inemail.nextLine();   
			    	if (isValid(email1))
			    	{
			    		a=1;
			    	}
			    	else
			    	{
			    		System.out.print("Invalid email re-enter email: ");
			    	}
			    } while (a ==0);
			    
				try {
				Connection connection = DriverManager.getConnection(jdbcURL, dbusername, dbpassword);
				
				
					String sql = "INSERT INTO users (firstname, lastname, phonenumber, username, email)" + " VALUES (?, ?, ?, ?, ?)";

					PreparedStatement statement = connection.prepareStatement(sql);
					
					statement.setString(1, firstname1);
					statement.setString(2, lastname1);
					statement.setString(3, phonenumber1);
					statement.setString(4, username1);
					statement.setString(5, email1);
					
					
					int rows = statement.executeUpdate();
					
					if(rows > 0) {
						System.out.println("A new user has been inserted successfully.");
					}
					
					connection.close();

				}catch (SQLException ex) {
					ex.printStackTrace();
				}
			    
				break;
			case 2:
				System.out.println("------------------------------------------");
				try {
					Connection connection = DriverManager.getConnection(jdbcURL, dbusername, dbpassword);
	
				String sql = "SELECT * FROM users";
				Statement statement = connection.createStatement();
				ResultSet result = statement.executeQuery(sql);
				
				while (result.next()) {
					int userId = result.getInt("user_id");
					String firstname = result.getString("firstname");
					String lastname = result.getString("lastname");
					String phonenumber = result.getString("phonenumber");
					String username = result.getString("username");
					String email = result.getString("email");
					
					System.out.println(userId + ":" + firstname + ", " + lastname + ", " + phonenumber + ", " + username + ", " + email);
				}
				
				
				
				connection.close();
				}catch (SQLException ex) {
					ex.printStackTrace();
				}
				System.out.println("------------------------------------------");
				break;
			case 3:
				String firstname2 = "";
				System.out.print("Enter firstname to Search: ");
				Scanner fdelete2 = new Scanner(System.in);
				firstname2 = fdelete2.nextLine();
				System.out.println("------------------------------------------");
				try {
					Connection connection = DriverManager.getConnection(jdbcURL, dbusername, dbpassword);
	
				String sql = "SELECT * FROM users WHERE firstname = ?";
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setString(1, firstname2);
				ResultSet result = statement.executeQuery();

				while (result.next()) {
					int userId = result.getInt("user_id");
					String firstname = result.getString("firstname");
					String lastname = result.getString("lastname");
					String phonenumber = result.getString("phonenumber");
					String username = result.getString("username");
					String email = result.getString("email");
					
					System.out.println(userId + ":" + firstname + ", " + lastname + ", " + phonenumber + ", " + username + ", " + email);
				}

				connection.close();
				}catch (SQLException ex) {
					ex.printStackTrace();
				}
				System.out.println("------------------------------------------");
				break;
			case 4:		
				String firstname3 = "";
				System.out.print("Enter firstname to delete: ");
				Scanner fdelete = new Scanner(System.in);
				firstname3 = fdelete.nextLine();
				System.out.println("------------------------------------------");
				try {
					Connection connection = DriverManager.getConnection(jdbcURL, dbusername, dbpassword);
	
				String sql = "DELETE FROM users WHERE firstname=?";
				PreparedStatement statement = connection.prepareStatement(sql);
				
				statement.setString(1, firstname3);
				
				int rows = statement.executeUpdate();
				
				if (rows > 0) {
					System.out.println("The user's infromation has been deleted.");
				}
				connection.close();
				}catch (SQLException ex) {
					ex.printStackTrace();
				}

				System.out.println("------------------------------------------");
				break;
			case 5:
				/*
				String firstname = "";
				String lastname = "";
				String phonenumber = "";
				String username = "";
				String email = "";
				
				System.out.print("Enter firstname to update: ");
				Scanner fupdate = new Scanner(System.in);
				firstname = fupdate.nextLine();
				System.out.print("Enter new last name: ");
				lastname = fupdate.nextLine();
				System.out.print("Enter new phonenumber: ");
				phonenumber = fupdate.nextLine();
				System.out.print("Enter new username: ");
				username = fupdate.nextLine();
				System.out.print("Enter new email address: ");
				email = fupdate.nextLine();
				System.out.println("------------------------------------------");
				
				try {
					Connection connection = DriverManager.getConnection(jdbcURL, dbusername, dbpassword);
	
				String sql = "UPDATE users SET lastname=" + lastname + ", phonenumber=" + phonenumber + ", username=" + username + ", email=" + email + "where firstname="	+ firstname;
				PreparedStatement statement = connection.prepareStatement(sql);
				
				statement.setString(1, firstname);
				statement.setString(2, lastname);
				statement.setString(3, phonenumber);
				statement.setString(4, username);
				statement.setString(5, email);

				
				int rows = statement.executeUpdate();
				
				if (rows > 0) {
					System.out.println("The user's infromation has been deleted.");
				}
				connection.close();
				}catch (SQLException ex) {
					ex.printStackTrace();
				}

*/
				System.out.println("Working on it..");
				System.out.println("------------------------------------------");
				break;
				

			}
		}while(ch!=0);
	}

	
	public static boolean validateFirstName( String firstName )
	{
	   return firstName.matches("(?i)(^[a-z])((?![ .,'-]$)[a-z .,'-]){0,23}$");
	} 

	public static boolean validateLastName( String lastName )
	{
	   return lastName.matches("(?i)(^[a-z])((?![ .,'-]$)[a-z .,'-]){0,23}$");
	}

	public static boolean validatephone( String phNum )
	{
		return phNum.matches("^\\d{10}$");
	}

	public static boolean validateuname( String uname )
	{
	   return uname.matches("^[^-\\s]{8,24}$");
	}

	public static boolean isValid(String email)
	{
	    String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
	                        "[a-zA-Z0-9_+&*-]+)*@" +
	                        "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
	                        "A-Z]{2,7}$";
	                          
	    Pattern pat = Pattern.compile(emailRegex);
	    if (email == null)
	        return false;
	    return pat.matcher(email).matches();
	}
}

