package week2.day2;

public class Digits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name = "Amazon has 11400 employees";
		String replaceAll = name.replaceAll("[^0-9]", "");
//		String replaceAll = name.replaceAll("[a-zA-z]", "");
		System.out.println(replaceAll);
		
	}

}
