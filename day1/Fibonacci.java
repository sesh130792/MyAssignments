package week1.day1;

public class Fibonacci {

	public static void main(String[] args) {
		// Logic to print fibonacci series
		int firstNumber = 0,  secondNumber = 1,  sum = 0;
		
		System.out.println(firstNumber);
		System.out.println(secondNumber);
		
		for (int i = 1; i < 12; i++) {
			sum = firstNumber + secondNumber;
			System.out.println(sum);
			firstNumber = secondNumber;
			secondNumber = sum;		
		}

	}

}
