package week3.day1.assignment4;

public class Students {
	
	public void getStudentInfo(int id) {
		System.out.println("Student ID is " + id);
	}
	
	public void getStudentInfo(int id, String name) {
		System.out.println("Student ID is " + id);
		System.out.println("Student name is " + name);
	}
	
	public void getStudentInfo(String email,  String phone) {
		System.out.println("Student email is " + email);
		System.out.println("Student phone is " + phone);
	}

	public static void main(String[] args) {
		Students student = new Students();
		student.getStudentInfo(001);
		student.getStudentInfo(001, "Sesh");
		student.getStudentInfo("test@gmail.com", "9876543210");
	}
}
