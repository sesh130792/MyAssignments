package week4.day1;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AlertsPractice {
	
	public static void main(String[] args) {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://leafground.com/alert.xhtml");	
		String alertTextActual = "Did you call me?";
		driver.findElement(By.xpath("//h5[text()=' Alert (Confirm Dialog)']/following::button")).click();
		Alert confirmAlert = driver.switchTo().alert();
		String alertTextExpected = confirmAlert.getText();
		confirmAlert.accept();
		// verify alert text
		assert alertTextActual == alertTextExpected;
		// verify if user accepted the alert
		assert driver.findElement(By.xpath("//span[@id='result']")).getText() == "User Clicked : OK";
	}
}
