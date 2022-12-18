package week3.day2.assignments;

import java.util.HashSet;
import java.util.Set;

public class PrintUniqueCharacter {

	public static void main(String[] args) {
		
		String input = "Seshadri Srinivasan";
		String inputLowerCase = input.toLowerCase();

		char[] inputcharArray = inputLowerCase.toCharArray();
		Set<Character> inputChars = new HashSet<Character>();

		for (Character eachchar : inputcharArray) {
			inputChars.add(eachchar);
		}
		
		for (Character eachchar : inputChars) {
			System.out.print(eachchar + " ");
		}
	}
}
