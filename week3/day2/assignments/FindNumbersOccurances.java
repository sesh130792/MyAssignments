package week3.day2.assignments;

import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class FindNumbersOccurances {

	public static void main(String[] args) {

		int[] input = { 2, 3, 5, 6, 3, 2, 1, 4, 2, 1, 6, -1 };

		Map<Integer, Integer> occurences = new TreeMap<Integer, Integer>();
		for (int i : input) {
			if (!occurences.containsKey(i)) {
				occurences.put(i, 1);
			} else {
				occurences.put(i, occurences.get(i) + 1);
			}
		}

		for (Entry<Integer, Integer> entry : occurences.entrySet()) {
			System.out.print(entry.getKey() + "->" + entry.getValue() + ", ");
		}
	}
}
