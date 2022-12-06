package week1.day2;

public class ChangeOddIndexToUpperCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String test = "changeme";
		char[] charTest = test.toCharArray();
		System.out.println(charTest.length);
		
		for(int i=0;i<charTest.length;i++) {
			if(i%2 != 0) {
				System.out.print(Character.toUpperCase(charTest[i]));
			}else {
				System.out.print(charTest[i]);
			}
		}

	}

}
