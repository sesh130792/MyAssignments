package week4.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FramesServiceNowA4 {

	public static void main(String[] args) {
		
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://dev110326.service-now.com/");
		
//		driver.switchTo().frame(0); //Switching to main frame using index 
//		driver.switchTo().frame("gsft_main"); // switch using id
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='Main Content']"))); // using webelement
		
		//logging in
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("India@123");
		driver.findElement(By.id("sysverb_login")).click();
		System.out.println(driver.getTitle());
		
		driver.quit();
	}

}
