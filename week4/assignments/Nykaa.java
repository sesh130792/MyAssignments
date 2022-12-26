package week4.assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Nykaa {
	public static void main(String[] args) throws InterruptedException {
	
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		
		ChromeDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.nykaa.com/");
		
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//li/a[text()='brands']"))).perform();
		driver.findElement(By.linkText("L'Oreal Paris")).click();
		assert driver.getTitle().contains("L'Oreal Paris");
		
		driver.findElement(By.xpath("//span[@class='sort-name']/..")).click();
		driver.findElement(By.xpath("//span[text()='customer top rated']/..")).click();
		
		driver.findElement(By.xpath("//span[text()='Category']/..")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Hair']/..")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[text()='Hair Care'])[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Shampoo']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Concern']/..")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Color Protection']/..")).click();
		Thread.sleep(2000);
		
		List<WebElement> filterElements = driver.findElements(By.xpath("//span[text()='Filters Applied']/following::span[@class='filter-value']"));
		System.out.println("Filters applied: ");
		for (WebElement webElement : filterElements) {
			System.out.println(webElement.getText());
		}
		driver.findElement(By.xpath("//div[@class='product-listing']//a")).click();
		Set<String> windowHandlesSet = driver.getWindowHandles();
		List<String> windowHandlesList = new ArrayList<String>(windowHandlesSet);
		driver.switchTo().window(windowHandlesList.get(1));
		
		String price = driver.findElement(By.xpath("(//span[contains(text(),'Off')]/preceding-sibling::span)[2]")).getText().replaceAll("[^0-9]", "");
		System.out.println(price);
		
		driver.findElement(By.xpath("//span[text()='Add to Bag']/..")).click();
		driver.findElement(By.xpath("//button[text()='Sign in']/following::button")).click();
		driver.switchTo().frame(0);
		Thread.sleep(2000);
		String grantTotal = driver.findElement(By.xpath("//p[text()='You Pay']/../following::div/p")).getText().replaceAll("[^0-9]", "");
		System.out.println(grantTotal);
		
		driver.findElement(By.xpath("//span[text()='Proceed']/..")).click();
		driver.findElement(By.xpath("//button[text()='Continue as guest']")).click();
		driver.findElement(By.xpath("//p[text()='New Address']/../preceding-sibling::div")).click();
		String addressTotal = driver.findElement(By.xpath("//p[text()='Price Details']/following::p[2]")).getText().replaceAll("[^0-9]", "");
		System.out.println(addressTotal);
		assert grantTotal == addressTotal;
		driver.quit();
	}
	
}
