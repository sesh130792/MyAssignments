package week2.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BookMyShowMarathon {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable notifications");
		ChromeDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://in.bookmyshow.com/");
//        driver.findElement(By.xpath("//input[@placeholder='Search for your city']")).sendKeys("Hyderabad");
		driver.findElement(By.xpath("//span[text()='Hyderabad']")).click();
		String[] citySelected = driver.getCurrentUrl().split("/");
		assert citySelected[citySelected.length - 1] == "hyderabad";
		System.out.println("City Selected is " + citySelected[citySelected.length - 1]);
		// select first movie from recommended movies
		driver.findElement(By.xpath("(//h2[text()='Recommended Movies']/ancestor::div)[10]/following-sibling::div//a"))
				.click();
		driver.findElement(By.xpath("//span[text()='Book tickets']/..")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("(//span[text()='English']/../following::section/div/span)")).click();
		System.out.println(driver.findElement(By.xpath("(//div[@class='details']//a)[1]")).getText());
		driver.findElement(By.xpath("//div[text()='INFO']/..")).click();
		assert driver.findElement(By.xpath("//div[contains(text(),'Parking')]")).isDisplayed();
		System.out.println(driver.findElement(By.xpath("//div[contains(text(),'Parking')]")).getText());
		driver.findElement(By.xpath("//div[@class='cross-container']")).click();
		driver.findElement(By.xpath("//ul[@id='venuelist']/li/div[2]/div[2]/div/a")).click();
		driver.findElement(By.xpath("//div[@id='btnPopupAccept']")).click();
		driver.findElement(By.xpath("//ul[@id='popQty']/li[text()='1']")).click();
		driver.findElement(By.xpath("//div[@id='proceed-Qty']")).click();
		driver.findElement(By.xpath("//a[@class='_available']")).click();
		driver.findElement(By.xpath("//a[@id='btmcntbook']")).click();
		driver.findElement(By.xpath("//button[@id='wzrk-cancel']")).click();
		String price = driver.findElement(By.xpath("//span[@id='subTT']")).getText();
		System.out.println(price);
		System.out.println("Price is " + driver.findElement(By.xpath("//span[@id='subTT']")).getText());
		File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\padma\\OneDrive\\Desktop\\screenshots\\bookMyShow.jpg");
		try {
			FileUtils.copyFile(screenshotAs, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.close();
	}
}
