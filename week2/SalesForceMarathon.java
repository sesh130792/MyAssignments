package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SalesForceMarathon {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://login.salesforce.com");
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Testleaf$321");
		driver.findElement(By.xpath("//input[@id='Login']")).click();
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		Thread.sleep(5000);
		WebElement oppurtunityEle = driver.findElement(By.xpath("//span[text()='Opportunities']"));
        driver.executeScript("arguments[0].click();", oppurtunityEle);
		driver.findElement(By.xpath("//div[text()='New']/..")).click();
		String oppurtunityEntered = "Salesforce Automation by Sesh2";
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys(oppurtunityEntered);
		driver.findElement(By.xpath("(//span[text()='--None--']/..)[1]")).click();
		driver.findElement(By.xpath("//span[@title='Needs Analysis']")).click();
		driver.findElement(By.xpath("//input[@name='CloseDate']")).sendKeys("12/15/2022");
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		String oppurtunitySaved = driver.findElement(By.xpath("//div[text()='Opportunity']/../slot")).getText();
		assert oppurtunityEntered == oppurtunitySaved.strip();

	}

}
