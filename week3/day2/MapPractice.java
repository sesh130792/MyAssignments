package week3.day2;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.collections4.iterators.EntrySetMapIterator;

public class MapPractice {

	public static void main(String[] args) {

		String input = "Amazon Development Center, Chennai";
		char[] charInputArray = input.toCharArray();

		Map<Character, Integer> inputMap = new HashMap<Character, Integer>();
		for (int i = 0; i < charInputArray.length; i++) {
			if (!inputMap.containsKey(charInputArray[i])) {
				inputMap.put(charInputArray[i], 1);
			} else {
				inputMap.put(charInputArray[i], inputMap.get(charInputArray[i]) + 1);
			}
		}
		for (Entry<Character, Integer> entry : inputMap.entrySet()) {
			System.out.println("Character '" + entry.getKey() + "' : has occured " + entry.getValue() + " time(s)");
		} 
	}
}
