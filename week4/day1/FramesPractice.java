package week4.day1;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FramesPractice {
	public static void main(String[] args) {
		/*
		 * Classroom: ========= 1. Load
		 * https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt 2. click Try it
		 * button 3. Enter your name in the prompt alert 4. Click Ok in the alert 5. get
		 * the text below Try it button and print
		 */
		
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");
		
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.xpath("//button[text()='Try it']")).click();
		
		Alert promptAlert = driver.switchTo().alert();
		promptAlert.sendKeys("Sesh");
		promptAlert.accept();
		System.out.println(driver.findElement(By.xpath("//p[@id='demo']")).getText());
		
		driver.switchTo().defaultContent();
		System.out.println(driver.getTitle());
		driver.quit();
	}
}
