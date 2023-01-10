package week5.assignments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DeleteTaskSalesforce {

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
		String text = driver.findElement(By.xpath("(//h1)[1]/span[2]")).getText();
		if (!text.equalsIgnoreCase("Recently Viewed")) {
			driver.findElement(By.xpath("//h1/following::div")).click();
			driver.findElement(By.xpath("//li/a/span[text()='Recently Viewed']")).click();
		}
		Thread.sleep(3000);
		List<WebElement> dropDownElements = driver
				.findElements(By.xpath("//ul[@role='listbox']/div/li/a/div[1]/span[1]/span"));
		for (WebElement eachEle : dropDownElements) {
			if (eachEle.getText().equalsIgnoreCase("BootcampSeshTest2")) {
				eachEle.click();
				break;
			}
		}
		driver.findElement(By.xpath("//div[text()='Create Follow-Up Task']/following::div/a[1]")).click();
		Thread.sleep(3000);
		WebElement deleteOption = driver.findElement(By.xpath("//ul/li/a/div[text()='Delete']"));
		driver.executeScript("arguments[0].click();", deleteOption);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Delete']/..")).click();
		assert driver.findElement(By.xpath("//div[@role='alertdialog']")).isDisplayed();
	}

}
