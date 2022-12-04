package week2.day2;

public class SumOfDigitsFromString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Method 2
		 * Pseudo Code
		 * Declare a String text with the following value
			String text = "Tes12Le79af65";
		   Declare a int variable sum
			int sum = 0;
		 * a) Iterate an  array over the String
		 * b) Get each character and check if it is a number using Character.isDigit()
		 * c) Now covert char to int using Character.getNumericValue() and add it to sum
		 * d) Now Print the value
		 */
		String text = "Tes12Le79af65";
		int sum = 0;
		char[] textArray = text.toCharArray();
		for(int i=0;i<textArray.length;i++) {
			if(Character.isDigit(textArray[i])) {
				sum += Character.getNumericValue(textArray[i]);
		}
	}
		System.out.println("Sum of the digits in the given string is \'" + sum + "\'");
}}
