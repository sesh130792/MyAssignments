package week3.day1.assignment1;

public class Desktop extends Computer {
	// Single inheritance

	public String desktopSize(int size) {
		return size + " inch desktop";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Desktop desktop = new Desktop();
		System.out.println(desktop.computerModel("Assembled")); // from base class Computer
		System.out.println(desktop.desktopSize(32)); // from sub class Desktop
	}
}