package week2.day2;

public class ReverseAString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String name = "Testleaf";
		String reversedName = "";
		char[] nameArray = name.toCharArray();
		System.out.println(nameArray.length);
		
		for (int i = nameArray.length-1; i >= 0 ; i--) {
			System.out.println(nameArray[i]);
			reversedName += nameArray[i];
			
		}
		System.out.println("Reversed name is "+ reversedName);
	}

}
