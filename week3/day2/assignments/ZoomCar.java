package week3.day2.assignments;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ZoomCar {

	public static void main(String[] args) throws InterruptedException {

		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.zoomcar.com/");
		driver.findElement(By.xpath("//input[@placeholder='Select country']/parent::div")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='India']/..")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Chennai']/..")).click();
		driver.findElement(By.xpath("//button[@class='city-lightbox__confirm-button']")).click();
		driver.findElement(By.xpath("//div[@class='field field-address']")).click();
		driver.findElement(By.xpath("(//h3[text()='Suggested Pick Up Locations']/following::div)[1]")).click();
		driver.findElement(By.xpath("//div[@class='left-calendar']/table/tbody/tr[5]/td[1]")).click();
		driver.findElement(By.xpath("//div[@class='left-calendar']/table/tbody/tr[5]/td[5]")).click();
		driver.findElement(By.xpath("(//button[@class='button-primary'])[2]")).click();
		driver.findElement(By.xpath("(//button[@class='button-primary'])[1]")).click();
		File sc = driver.getScreenshotAs(OutputType.FILE);
		File dt = new File(".\\snap\\zoom.jpg");
		try {
			FileUtils.copyFile(sc, dt);
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<WebElement> allCars = driver.findElements(By.xpath("//div[@class='car-list']/div"));
		Map<String, Integer> carsList = new HashMap<String, Integer>();
		for (WebElement car : allCars) {
			String carName = car.findElement(By.xpath("(.//div[@class='desc']/div/h3)[1]")).getText();
			String carPrice = car.findElement(By.xpath("(.//div[@class='price-book-ctr']/div/div)[1]")).getText();
//			System.out.println(carName + " : " + carPrice);
			if(!carsList.containsKey(carName)) {
				carsList.put(carName, Integer.parseInt((carPrice.split(" ")[1].replace(",", ""))));
			}
			else {
				if(carsList.get(carName) > Integer.parseInt((carPrice.split(" ")[1].replace(",", "")))){
					carsList.put(carName, Integer.parseInt((carPrice.split(" ")[1].replace(",", ""))));
				}
			}
		}
		System.out.println(allCars);
		for (Entry<String, Integer> car : carsList.entrySet()) {
			System.out.println(car.getKey() + " : " + car.getValue());
		}
	}

}
