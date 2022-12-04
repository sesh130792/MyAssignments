package week2.day2;

public class ReverseWords {
	public static void main(String[] args) {
		
		String name = " Amazon Development Centre, Chennai";
		String nameLower = name.toLowerCase();
		String[] namearray = nameLower.split(" ");
		
		for (int i = namearray.length -1;i >=0;i--) {
			System.out.print(namearray[i] + " ");
		}
	}
}

