package week4.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FrameAndAlertA3 {

	public static void main(String[] args) {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://buythevalue.in/");
		driver.findElement(By.xpath("//a[@class='product-title']")).click();

		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='chat widget']")));
		driver.findElement(By.xpath("//p[contains(text(), 'Got any questions?')]/../button/div")).click();
		driver.switchTo().defaultContent();

		driver.findElement(By.xpath("//input[@name='wk_zipcode']")).sendKeys("600049");
		WebElement checkXpath = driver.findElement(By.xpath("//input[@type='button' and @value='Check']/.."));
		WebElement addToCartXpath = driver.findElement(By.xpath("//span[text()='Add to Cart']"));
//		checkXpath.click();
		driver.executeScript("arguments[0].click();", checkXpath);
		driver.executeScript("arguments[0].click();", addToCartXpath);
		driver.findElement(By.xpath("(//a[text()='View Cart'])[2]")).click();
		driver.findElement(By.xpath("//input[@id='checkout']")).click();
		
		driver.switchTo().alert().accept();
		driver.findElement(By.xpath("//input[@id='agree']")).click();
		driver.findElement(By.xpath("//input[@id='checkout']")).click();
		
	}
}
