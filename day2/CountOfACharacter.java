package week2.day2;

public class CountOfACharacter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name = "Hexaware";
		char toFind = 'e';
		int repetition = 0;
		char[] charNameArray = name.toCharArray();
		
		for (int i = 0; i < charNameArray.length; i++) {
			if(toFind == charNameArray[i]) {
				repetition++;
			}
			
		}
		System.out.println(toFind + " is repeated " + repetition + " times!!");

	}

}
