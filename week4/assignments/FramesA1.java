package week4.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class FramesA1 {
	
	public static void main(String[] args) {
		
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		
		//Switching to frame 1 using id
		driver.switchTo().frame("frame1");
		driver.findElement(By.xpath("//b[@id='topic']/following::input")).sendKeys("Selenium Frames");
		
		//Switching to nested frame using index
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//input[@id='a']")).click();
		
		//switching to default context before switching to frame 2
		driver.switchTo().defaultContent();
		driver.switchTo().frame("frame2");
		Select dropDown = new Select(driver.findElement(By.id("animals")));
		dropDown.selectByVisibleText("Big Baby Cat");  // selecting option Big Baby Cat
		
		
	}

}
