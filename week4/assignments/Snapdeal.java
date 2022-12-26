package week4.assignments;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Snapdeal {
	/*
	 * 1. Launch https://www.snapdeal.com/ 2. Go to Mens Fashion 3. Go to Sports
	 * Shoes 4. Get the count of the sports shoes 5. Click Training shoes 6. Sort by
	 * Low to High 7. Check if the items displayed are sorted correctly 8.Select the
	 * price range (900-1200) 9.Filter with color Navy 10 verify the all applied
	 * filters 11. Mouse Hover on first resulting Training shoes 12. click QuickView
	 * button 13. Print the cost and the discount percentage 14. Take the snapshot
	 * of the shoes. 15. Close the current window 16. Close the main window
	 * 
	 */
	public static void main(String[] args) throws InterruptedException, IOException {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");

		ChromeDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.snapdeal.com/");

		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.linkText("Men's Fashion"))).perform();

		driver.findElement(By.linkText("Sports Shoes")).click();
		String noOfItems = driver.findElement(By.xpath("//span[@class='category-name category-count']")).getText();
		System.out.println(noOfItems);

		driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();

		driver.findElement(By.xpath("//div[@class='sort-selected']")).click();
		driver.findElement(By.xpath("//ul[@class='sort-value']/li[2]")).click();

		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@name='fromVal']")).clear();
		driver.findElement(By.xpath("//input[@name='fromVal']")).sendKeys("900");
		driver.findElement(By.xpath("//input[@name='toVal']")).clear();
		driver.findElement(By.xpath("//input[@name='toVal']")).sendKeys("1200");
		driver.findElement(By.xpath("(//div[@class='price-input'])[2]/following::div")).click();

		Thread.sleep(5000);
		action.moveToElement(driver.findElement(By.xpath("//div[@class='product-tuple-image ']/parent::div")))
				.perform();
		driver.findElement(By.xpath("//div[@class='clearfix row-disc']/div")).click();
		String price = driver.findElement(By.xpath("//span[@class='payBlkBig']")).getText();
		String percentage = driver.findElement(By.xpath("//span[@class='percent-desc ']")).getText();
		System.out.println(price);
		System.out.println(percentage);

		File src = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File("./snap/snapdeal.png");
		FileUtils.copyFile(src, dest);

		driver.quit();
	}
}