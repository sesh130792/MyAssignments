package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class RedBusMarathon {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.redbus.in/");
		driver.findElement(By.xpath("//input[@id='src']")).sendKeys("Chennai");
		driver.findElement(By.xpath("//input[@id='src']/../ul/li[1]")).click();
		driver.findElement(By.xpath("//input[@id='dest']")).sendKeys("Bangalore");
		driver.findElement(By.xpath("//input[@id='dest']/../ul/li[1]")).click();
		driver.findElement(By.xpath("//input[@id='onward_cal']")).click();
		driver.findElement(By.xpath("//div[@id='rb-calendar_onward_cal']/table/tbody/tr[5]/td[5]")).click();
		driver.findElement(By.xpath("//button[@id='search_btn']")).click();
		System.out.println("Found " + driver.findElement(By.xpath("//span[@class='f-bold busFound']")).getText());
		driver.findElement(By.xpath("//label[text()='SLEEPER']")).click();
		Thread.sleep(5);
		System.out.println("Second bus name is " + driver.findElement(By.xpath("(//ul[@class='bus-items'])/div[2]/li/div/div/div/div/div")).getText());
		driver.findElement(By.xpath("//div[@class='tripleFive-block']/div[2]/i")).click();
		driver.findElement(By.xpath("((//ul[@class='bus-items']/div[2]/li/div/div[2]/div)[1])")).click();	

	}

}
