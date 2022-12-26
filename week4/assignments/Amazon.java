package week4.assignments;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Amazon {
	/*
	 * 1.Load the URL https://www.amazon.in/ 2.search as oneplus 9 pro 3.Get the
	 * price of the first product 4. Print the number of customer ratings for the
	 * first displayed product 5. Click the first text link of the first image 6.
	 * Take a screen shot of the product displayed 7. Click 'Add to Cart' button 8.
	 * Get the cart subtotal and verify if it is correct. 9.close the browser
	 */
	public static void main(String[] args) throws InterruptedException, IOException {

		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");

		ChromeDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.amazon.in/");

		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro", Keys.ENTER);
		driver.findElement(By.tagName("h2")).click();

		Set<String> allTabsSet = driver.getWindowHandles();
		List<String> allTabsList = new ArrayList<String>(allTabsSet);
		driver.switchTo().window(allTabsList.get(1));

		String price = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[5]")).getText();
		System.out.println("Price of the item is " + price);

		String ratings = driver.findElement(By.xpath("//span[@id='acrCustomerReviewText']")).getText();
		System.out.println("Item has " + ratings);

		driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
		File srcFile = driver.getScreenshotAs(OutputType.FILE);
		File destFile = new File("./snap/" + driver.getTitle().split(" ")[0] + ".png");
		FileUtils.copyFile(srcFile, destFile);

		Thread.sleep(5000);
		String cartPrice = driver.findElement(By.xpath("//span[@id='attach-accessory-cart-subtotal']")).getText();
		System.out.println(cartPrice.replaceAll("[^1-9,]", ""));
		assert price == cartPrice;
		
		driver.quit();
		
	}
}
