package week1.day2;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MissingElementInAnArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Here is the input
				int[] arr = {1,2,3,4,7,6,8};
				int missingItem = 0;
				// Sort the array	
				// loop through the array (start i from arr[0] till the length of the array)
					// check if the iterator variable is not equal to the array values respectively
						// print the number	
						// once printed break the iteration
				Arrays.sort(arr);
				System.out.println(Arrays.toString(arr));
				for(int i=0;i<arr.length;i++) {
//					System.out.print (i+1);
//					System.out.println(arr[i]);
					if(i+1 != arr[i]) {
						missingItem = i+1;
						break;
					}
				}
				System.out.println("Missing Element in the array is " + missingItem);
	}

}
