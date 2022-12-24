package week4.day1;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AllModalAlerts {
	public static void main(String[] args) {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://leafground.com/alert.xhtml");
		
		//simple alert
		driver.findElement(By.xpath("//h5[text()=' Alert (Simple Dialog)']/following::button")).click();
		Alert alert = driver.switchTo().alert();
		System.out.println("Simple alert text is '" + alert.getText() );
		alert.accept();
		
		//confirmation alert
		driver.findElement(By.xpath("//h5[text()=' Alert (Confirm Dialog)']/following::button")).click();
		Alert alert2 = driver.switchTo().alert();
		System.out.println("Confirmation alert text is '" + alert2.getText() );
		alert2.accept();
		
		//prompt alert
		driver.findElement(By.xpath("//h5[text()=' Alert (Prompt Dialog)']/following::button")).click();
		Alert alert3 = driver.switchTo().alert();
		System.out.println("Prompt alert text is '" + alert3.getText() );
		alert3.sendKeys("Sesh");
		alert3.accept();
	}

}
