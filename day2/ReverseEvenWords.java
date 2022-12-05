package week1.day2;

public class ReverseEvenWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Build a logic to reverse the even position words (output: I ma a erawtfos tester)
		
		/*
		 * String test = "I am a software tester";
		 * split the string into a char array using toCharArray() method
		 * loop through the array 
		 * if the index is even reverse the string and print 
		 * else print the string as it is 
		 */
		 String test = "I am a software tester and a working professional!";
		 String[] textArr = test.split(" ");
		 
		 for(int i=0;i<textArr.length;i++) {
			 if(i%2==0 && textArr[i].length() > 1) {
				 char[] eachWord = textArr[i].toCharArray();
				 String reversedWord = "";
				 for(int j=eachWord.length-1;j>0;j--) {
					 reversedWord += eachWord[j];
				 }
				 System.out.print(reversedWord + " ");
			 }else {
				 System.out.print(textArr[i] + " ");
			 }
		 }
	}

}
