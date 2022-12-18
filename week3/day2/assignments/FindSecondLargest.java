package week3.day2.assignments;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class FindSecondLargest {

	public static void main(String[] args) {

		int[] data = { 3, 2, 11, 4, 6, 7, 2, 3, 3, 6, 7 };

		Set<Integer> numbersSet = new TreeSet<Integer>();
		for (int num : data) {
			numbersSet.add(num);
		}
		System.out.println(numbersSet);
		
		List<Integer> numbersList = new ArrayList<Integer>();
		numbersList.addAll(numbersSet);
		System.out.println(numbersList);
		
		System.out.println("Second Last element number from list is " + numbersList.get(numbersList.size()-2));
	}
}
