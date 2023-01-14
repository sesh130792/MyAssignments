package week5.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CreateTaskWithoutMandatoryFields {
	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://qeagle-dev-ed.my.salesforce.com/");
		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.id("password")).sendKeys("Testleaf$321");
		driver.findElement(By.id("Login")).click();

		driver.findElement(By.xpath("(//div[contains(@class, \"tooltipTrigger \")])[6]")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//p[text()='Sales']/..")).click();
		Thread.sleep(3000);		
		driver.findElement(By.xpath("//a/span[text()='Tasks']/following::a")).click();
		Thread.sleep(3000);
		driver.executeScript("arguments[0].click();", driver.findElement(By.xpath("//span[text()='New Task']/..")));
		driver.findElement(By.xpath("//label/span[text()='Name']/following::input[@title='Search Contacts']")).click();
		driver.findElement(By.xpath("//div[@class='listContent']/ul/li")).click();
		driver.findElement(By.xpath("//label/span[text()='Comments']/following::textarea")).sendKeys(" SALES FORCE Automation Using Selenium");
		driver.findElement(By.xpath("//button[@title='Save']")).click();
		assert driver.findElement(By.xpath("(//div[@role='alert'])[2]")).isDisplayed();
		assert driver.findElement(By.xpath("//label[text()='Subject']/following::div[text()='Complete this field.']")).isDisplayed();
		System.out.println(driver.findElement(By.xpath("(//div[@role='alert'])[2]/ul/li")).getText());

	}
}
