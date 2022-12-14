package week2.day2;

public class MajorityElement {

	public static void main(String[] args) {

		 // Java Problem (6/20)
		
		int[] input = {1,2,1,2,2,1,3,3,3,3};
		int majorityElement = input[0];
		int countGlobal = 1;
		
		for(int i=0;i<input.length-1;i++) {
			int countLocal = 1;
			for(int j=i+1;j<input.length;j++) {
				if(input[i] == input[j]) {
					countLocal++;
				}
			}
			if (countLocal > countGlobal){
				countGlobal = countLocal;
				majorityElement = input[i];
			}
		}
		System.out.println(majorityElement + " is the majority element repeating " + countGlobal + " times" );
	}
	
}
