import java.util.Scanner;

public class LastLetterCount {

	public static void main(String[] args) {

	    Scanner Sentence = new Scanner(System.in);
	    System.out.println("Input: ");
	    String str = Sentence.nextLine(); 
        
        String strArray[] = str.split(" ");
    	String a = "";
    	String b = "";
        String searched = "s";
    	
        
        for(int i=0; i < strArray.length; i++){
        	String sample = strArray[i];
        	String last = sample.substring(sample.length() - 1); 
         	if(last.equals("y")) {
        		a = strArray[i];
        		break;
        	}
        }
            for(int i=0; i < strArray.length; i++){
            	String sample = strArray[i];
            	String last = sample.substring(sample.length() - 1); 
             	if(last.equals("s")) {
            		b = strArray[i];
            		break;
            	}
        }
            for(int i=0; i < strArray.length; i++){
            	String sample = strArray[i];
            	String last = sample.substring(sample.length() - 1); 
             	if(last.equals("y")) {
            		strArray[i] = b;
             	}
           		else if(last.equals("s")) {
                		strArray[i] = a;
            	}
        }
            System.out.println("Output:");
            for (int i = 0; i < strArray.length; ++i)
                	System.out.print(strArray[i] + " ");
	}

}
