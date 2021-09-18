import java.util.Scanner;

public class Consonants {

	public static void main(String[] args) {
	    Scanner Sentence = new Scanner(System.in);
	    System.out.println("Enter Sentence: ");
	    String str = Sentence.nextLine(); 
        System.out.println("Number of Consonants in the string: " + count_Consonants(str));	
        String newstr = str.replaceAll("[bcdfghjklmnpqrstvwxyz]", "*");
        
        System.out.println(newstr);

	}
		 public static int count_Consonants(String str)
		    {
		        int consonants = 0;
		        for (int i = 0; i < str.length(); i++)
		        {
		            if (str.charAt(i) != 'a' && str.charAt(i) != 'e' && str.charAt(i) != 'i'
		            		&& str.charAt(i) != 'o' && str.charAt(i) != 'u' && str.charAt(i) != ' ')
		            	consonants++;
		        }
		        return consonants;

	}

}
