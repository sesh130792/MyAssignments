package week3.day2.assignments;

import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicates {

	public static void main(String[] args) {
//		Declare a String as "PayPal India"
//		Convert it into a character array
//		Declare a Set as charSet for Character
//		Declare a Set as dupCharSet for duplicate Character
//		Iterate character array and add it into charSet
//		if the character is already in the charSet then, add it to the dupCharSet
//		Check the dupCharSet elements and remove those in the charSet
//		Iterate using charSet
//		Check the iterator variable isn't equals to an empty space
//		print it

		String input = "PayPal India";
		char[] inputArray = input.toCharArray();

		Set<Character> charSet = new LinkedHashSet<Character>();
		Set<Character> dupSet = new LinkedHashSet<Character>();

		for (char eachChar : inputArray) {
			if (!charSet.add(eachChar)) {
				dupSet.add(eachChar);
			}
		}
		System.out.println(charSet);
		System.out.println(dupSet);

		for (Character eachChar : dupSet) {
			if (charSet.contains(eachChar)) {
				charSet.remove(eachChar);
			}
		}

		for (Character eachChar : charSet) {
			if (eachChar != ' ') {
				System.out.print(eachChar + " ");
			}

		}
	}

}
