package week2.day2;

public class DistinctElementArray {

	public static void main(String[] args) {
		//Given an integer array nums, return true if any value appears 
		//at least twice in the array, and return false if every element is distinct.
		//Java Problem (7/20)


		int[] input = { 1, 2, 3, 4, 5, 6, 7, 8 };
		boolean flag = false;

		for (int i = 0; i < input.length - 1; i++) {
			for (int j = i + 1; j < input.length; j++) {
					if(input[i] == input[j]) {
						flag = true;
						break;
					}
			}
		}
		System.out.println(flag);
	}
}
