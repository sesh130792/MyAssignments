package week2.day2;

public class RemoveDuplicates {

	public static void main(String[] args) {
		/*
		 * Pseudo code 
		 * a) Use the declared String text as input
			String text = "We learn java basics as part of java sessions in java week1";		
		 * b) Initialize an integer variable as count	  
		 * c) Split the String into array and iterate over it 
		 * d) Initialize another loop to check whether the word is there in the array
		 * e) if it is available then increase and count by 1. 
		 * f) if the count > 1 then replace the word as "" 
		 * g) Displaying the String without duplicate words	
		 */
		String text = "We learn java basics as part of java sessions in java week1";
		String[] textArray = text.split(" ");
		int count = 0;
		System.out.println(textArray);
		
		for(int i=0; i < textArray.length-1;i++) {
			for(int j=i+1; j < textArray.length;j++) {
				System.out.println(textArray[i]);
				System.out.println(textArray[j]);
				if(textArray[i].equals(textArray[j])) {
					count++;
				}
			}
			System.out.println(count);
			if(count>1) {
				text = text.replace(textArray[i], "");
				count = 0;
			}
				
		}
		System.out.println("Input text without duplicates : " + text);
} 
	}
