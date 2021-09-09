package userregistration;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FrontEnd {

	public static void main(String[] args) {
		
		List<UserArray> c = new ArrayList<UserArray>();
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
				String firstName = "";
				do {
					Scanner FName = new Scanner(System.in);
					firstName = FName.nextLine();
					if (validateFirstName(firstName))
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
				String lastName = "";
				do {
					Scanner LName = new Scanner(System.in);
					lastName = LName.nextLine();
					if (validateFirstName(lastName))
					{
						ln = 1;
					}
					else
					{
						System.out.print("Invalid last name re-enter: ");
					}
				}while (ln ==0);
				
			    System.out.print("Enter Phone Number: ");
			    String phNum = "";
			    long pcheck = 0;
				int ph = 0;
				do {
					Scanner pNum = new Scanner(System.in);
					phNum = pNum.nextLine();
					if (validatephone(phNum))
					{
						ph = 1;
						pcheck = Long.parseLong(phNum);
					}
					else
					{
						System.out.print("Invalid phone number re-enter: ");
					}
				}while (ph ==0);
				
			    System.out.print("Enter Username: ");
			    String usName = "";
				int us = 0;
				do {
					Scanner uName = new Scanner(System.in);
					usName = uName.nextLine();
					if (validateuname(usName))
					{
						us = 1;
					}
					else
					{
						System.out.print("Invalid user name re-enter: ");
					}
				}while (us ==0);
				
			    System.out.print("Enter Email Address: ");
			    String email = "";
				int a = 0;
			    do {
			    	Scanner inemail = new Scanner(System.in);
			    	email = inemail.nextLine();   
			    	if (isValid(email))
			    	{
			    		a=1;
			    	}
			    	else
			    	{
			    		System.out.print("Invalid email re-enter email: ");
			    	}
			    } while (a ==0);
				c.add(new UserArray(firstName,lastName,pcheck,usName,email));
				break;
			case 2:
				System.out.println("------------------------------------------");
				Iterator<UserArray> i = c.iterator();
				while(i.hasNext()) {
					UserArray e = i.next();
					System.out.println(e);
				}
				System.out.println("------------------------------------------");
				break;
			case 3:
				boolean found = false;
				System.out.print("Enter phone number to Search: ");
				int pnumber = s.nextInt();
				System.out.println("------------------------------------------");
				i = c.iterator();
				while(i.hasNext()) {
					UserArray e = i.next();
					if(e.getPnumber() == pnumber) {
						System.out.println(e);
						found = true;
					}		
				}
				if(!found) {
					System.out.println("Record Not Found");
				}
				System.out.println("------------------------------------------");
				break;
			case 4:		
				found = false;
				System.out.print("Enter phone number to delete: ");
				pnumber = s.nextInt();
				System.out.println("------------------------------------------");
				i = c.iterator();
				while(i.hasNext()) {
					UserArray e = i.next();
					if(e.getPnumber() == pnumber) {
						i.remove();
						found = true;
					}		
				}
				if(!found) {
					System.out.println("Record Not Found");
				}
				else {
					System.out.println("Record is Deleted");
				}
				System.out.println("------------------------------------------");
				break;
			case 5:		
				found = false;
				System.out.print("Enter phone number to Update: ");
				pcheck = s.nextInt();
				System.out.println("------------------------------------------");
				ListIterator<UserArray>li = c.listIterator();
				while(li.hasNext()) {
					UserArray e = li.next();
					if(e.getPnumber() == pcheck) {
						System.out.print("");
						firstName = s.nextLine();
						System.out.print("Enter new first name: ");
						firstName = s.nextLine();
						System.out.print("Enter new last name: ");
						lastName = s.nextLine();
						System.out.print("Enter new username: ");
						usName = s.nextLine();
						System.out.print("Enter new email address: ");
						email = s.nextLine();
						li.set(new UserArray(firstName,lastName,pcheck,usName,email));
						found = true;
					}		
				}
				if(!found) {
					System.out.println("Record Not Found");
				}
				else {
					System.out.println("Record Updated");
				}
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
