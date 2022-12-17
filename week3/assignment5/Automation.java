package week3.day1.assignment5;

public class Automation extends MultipleLanguage implements Language, TestTool{
	@Override
	public void ruby() {
		// from MultipleLanguage abstract class
		System.out.println("Ruby is also used for Selenium automation");	
	}

	public void selenium() {
		// implemented from Testtool interface
		System.out.println("Selenium webdriver is the tool we use for automation");
	}

	public void java() {
		// TODO Auto-generated method stub
		System.out.println("Java is the popular programming language for selenium automation");
	}

	public static void main(String[] args) {
		Automation auto = new Automation();
		auto.ruby();
		auto.selenium();
		auto.java();
		auto.python();
	}
}
