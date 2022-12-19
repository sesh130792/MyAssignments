package week3.day2.assignments;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class FirstNRCharacter {

	public static void main(String[] args) {

		/*
		 * 1. Got the string 2. Created a Map and Set 3. Updated Map with char->repeated
		 * times using the set 4. if the map contains a value 1 then get the
		 * corresponding key get the index of key which is nothing but a char in the
		 * string and return 5. else return -1
		 */

		String name = "abab";
//		String name = "leetcode";
//		String name = "loveleetcode";

		Map<Character, Integer> uniqueMap = new LinkedHashMap<Character, Integer>();
		Set<Character> unique = new LinkedHashSet<Character>();

		for (int i = 0; i < name.toCharArray().length; i++) {
			if (unique.add(name.toCharArray()[i])) {
				uniqueMap.put(name.toCharArray()[i], 1);
			} else {
				uniqueMap.put(name.toCharArray()[i], uniqueMap.get(name.toCharArray()[i]) + 1);
			}
		}

		System.out.println(uniqueMap);
		if (uniqueMap.containsValue(1)) {
			for (Entry<Character, Integer> each : uniqueMap.entrySet()) {
				if (each.getValue() == 1) {
					System.out.println(name.indexOf(each.getKey()));
					break;
				}
			}
		} else {
			System.out.println(-1);
		}

	}

}
