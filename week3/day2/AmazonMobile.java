package week3.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonMobile {

	public static void main(String[] args) {

		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://amazon.in");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Mobiles");
//		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Mobiles", Keys.ENTER);
		driver.findElement(By.id("nav-search-submit-button")).click();

		List<WebElement> priceAllElements = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
		List<Integer> allPrices = new ArrayList<Integer>();

		for (int i = 0; i < priceAllElements.size(); i++) {
			if (priceAllElements.get(i).getText() != "") {
				String price = priceAllElements.get(i).getText().replace(",", "");
				allPrices.add(Integer.parseInt(price));
			}
		}

		Collections.sort(allPrices);
		System.out.println(allPrices);
		System.out.println("Lowest Price for a mobile " + allPrices.get(0));
		driver.quit();

	}
}
