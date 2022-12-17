package week3.day1.assignment2;

public class Student extends Department {

	public String studentName(String name) {
		return name;
	}
	public String studentDept(String department) {
		return department;
	}
	public int studentID(int studentID) {
		return studentID;
	}

	public static void main(String[] args) {
		Student student1 = new Student();
		System.out.println("College name is " + student1.collegeName("Anna University"));
		System.out.println("College code is " + student1.codeName("AU001"));
		System.out.println("College rank is " + student1.rank(001));
		System.out.println("Department is " + student1.deptName("Engineering"));
		System.out.println("Student name is " + student1.studentName("Sesh"));
		System.out.println("Student id is " + student1.studentID(057));
		System.out.println("Student department is " + student1.studentDept("Electrical and Electronics Engineering"));
	}
}
