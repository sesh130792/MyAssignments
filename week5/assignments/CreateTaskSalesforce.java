package week5.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CreateTaskSalesforce {

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
		driver.findElement(By.xpath("(//input[@type='search'])[3]")).sendKeys("tasks");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button/span[text()='All Items']/following::li")).click();
		Thread.sleep(3000);
//		driver.executeScript("arguments[0].click();", driver.findElement(By.xpath("//a/span[text()='Tasks']")));
		driver.findElement(By.xpath("//a/span[text()='Tasks']/following::a")).click();
		Thread.sleep(3000);
		driver.executeScript("arguments[0].click();", driver.findElement(By.xpath("//span[text()='New Task']/..")));
//		driver.findElement(By.xpath("//span[text()='New Task']/..")).click();
		driver.findElement(By.xpath("(//input[@role='combobox'])[2]")).sendKeys("BootcampSeshTest");
		driver.findElement(By.xpath("(//span[text()='Status'])[2]/following::div")).click();
		driver.findElement(By.xpath("//a[text()='Waiting on someone else']/..")).click();
		driver.findElement(By.xpath("//span[text()='Save']/..")).click();
		assert driver.findElement(By.xpath("//div[@role='alertdialog']")).isDisplayed();
		
		driver.close();
	}
}
