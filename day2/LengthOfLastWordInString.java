package week1.day2;

public class LengthOfLastWordInString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String input = new String("Hi this is Sesh!");
		String input = new String("   fly me   to   the moon  ");
//		String input = new String("luffy is still joyboy");
		System.out.println(input);
		String inputArray[] = input.strip().split(" ");
		String lastword = "";
		
		for(int i=0;i<inputArray.length;i++) {
			lastword = inputArray[i];
		}
		System.out.println("Last word for the given input is \'" + lastword + "\'");
		System.out.println("Length of the last word for the given input is " + lastword.length());

	}

}
