package week3.day2;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class DuplicatesSetExample {

	public static void main(String[] args) {
		String input = "google";
		char[] inputcharArray = input.toCharArray();
		String output = "";

		Set<Character> unique = new LinkedHashSet<Character>();
//		Set<Character> unique = new HashSet<Character>();
//		Set<Character> unique = new TreeSet<Character>();
		for (int i = 0; i < inputcharArray.length; i++) {
			if(unique.add(inputcharArray[i])) {
				output += inputcharArray[i];
			}
		}
		System.out.println(output);
	}
}
