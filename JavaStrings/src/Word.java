import java.util.Scanner;

public class Word {

	public static void main(String[] args) {
		
	    Scanner Sentence = new Scanner(System.in);
	    System.out.println("Enter Sentence:");
	    String str = Sentence.nextLine(); 

        String[] words = str.split("\\s+");
        System.out.println("Number of words: " + words.length);
	}

}
