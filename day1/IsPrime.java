package week1.day1;

public class IsPrime {
	
	public static void main(String[] args) {
	// Logic to print if number is prime or not
		int number = 2;
		boolean flag = true;
		
		for (int i = 2; i <= number-1; i++) {
			if(number%i == 0) {
				flag = false;
				break;
			}
		}
		if(flag){
			System.out.println("Number " + number + " is   prime");
		}else {
			System.out.println("Number " + number + " is not  prime");
		}
			

		
	}

}
