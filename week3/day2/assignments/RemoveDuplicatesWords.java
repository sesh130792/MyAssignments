package week3.day2.assignments;

import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicatesWords {

	public static void main(String[] args) {

		String text = "We learn java basics as part of java sessions in java week1";
		String[] textArray = text.split(" ");

		Set<String> textSet = new LinkedHashSet<String>();

		for (String eachText : textArray) {
			if (textSet.add(eachText)) {
				System.out.print(eachText + " ");
			}
		}
	}
}
