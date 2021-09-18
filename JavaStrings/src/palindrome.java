import java.util.Scanner;

public class palindrome {

	public static void main(String[] args) {
		
	    Scanner word = new Scanner(System.in);
	    System.out.println("Enter word:");
	    String str = word.nextLine(); 
   	 
        if (isPalindrome(str))
            System.out.print("Word is Palindrome");
        else
            System.out.print("Word is not Palindrome");
		
	}
	    static boolean isPalindrome(String str)
	    {
	        int i = 0, j = str.length() - 1;
	        while (i < j) {
	            if (str.charAt(i) != str.charAt(j))
	                return false;
	            i++;
	            j--;
	        }
	        return true;
	    }

}
