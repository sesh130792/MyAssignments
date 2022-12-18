package week3.day2.assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AjioList {
	/*
	 * 1. Launch the URL https://www.ajio.com/ 2. In the search box, type as "bags"
	 * and press enter 3. To the left of the screen under " Gender" click the "Men"
	 * 4. Under "Category" click "Fashion Bags" 5. Print the count of the items
	 * Found. 6. Get the list of brand of the products displayed in the page and
	 * print the list. 7. Get the list of names of the bags and print it
	 */

	public static void main(String[] args) throws InterruptedException {
		// Launch browser
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.ajio.com/");

		driver.findElement(By.xpath("//input[@name='searchVal']")).sendKeys("bags", Keys.ENTER);
		driver.findElement(By.xpath("//input[@id='Men - Fashion Bags']/following::label[1]")).click();
		Thread.sleep(3000);
		String itemsFound = driver.findElement(By.xpath("//div[@class='length']")).getText();
		System.out.println(itemsFound);

		List<WebElement> allBags = driver.findElements(By.xpath("//div[@class='contentHolder']"));
		System.out.println(allBags.size());
		for (WebElement bag : allBags) {
			String brandName = bag.findElement(By.className("brand")).getText();
			String bagName = bag.findElement(By.className("nameCls")).getText();
			System.out.println(brandName + "------>" + bagName);
		}
		driver.close();
	}
}
