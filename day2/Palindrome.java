package week2.day2;

public class Palindrome {

	public static void main(String[] args) {
		/*
		 * Pseudo Code
		 * a) Declare A String value as"madam"
		 * b) Declare another String rev value as ""
		 * c) Iterate over the String in reverse order
		 * d) Add the char into rev
		 * e) Compare the original String with the reversed String, if it is same then print palinDrome 
		 
		 * Hint: Use .equals or .equalsIgnoreCase when you compare a String 
		 */
		
		String input = "redivider";
		String reversedInput = "";
		char[] inputCharArray = input.toCharArray();
		
		for(int i=inputCharArray.length-1; i>=0; i--) {
			reversedInput += inputCharArray[i];
		}

		if(input.equalsIgnoreCase(reversedInput)) {
			System.out.println("String \'" + input + "\' is a Palindrome");
		}else {
			System.out.println("String " + input + " is not a Palindrome");
		}
	}

}
