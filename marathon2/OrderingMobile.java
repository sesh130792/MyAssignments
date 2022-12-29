package marathon2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.sukgu.Shadow;

public class OrderingMobile {

	public static void main(String[] args) throws InterruptedException, IOException {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");

		ChromeDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://dev57553.service-now.com/");
		driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("5$dJ*EFdhhW0");
		driver.findElement(By.xpath("//button[@id='sysverb_login']")).click();

		Shadow sh = new Shadow(driver);
		sh.setImplicitWait(30);
		sh.findElementByXPath("//div[@id='all']").click();
		sh.setImplicitWait(30);
		sh.findElementByXPath("//span[text()='Service Catalog']/..").click();
		WebElement frameEle = sh.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(frameEle);
		driver.findElement(By.xpath("(//td[@class='homepage_category_only_description_cell'])[8]/a")).click();
		sh.findElementByXPath("//a[text()='iPhone 6s']").click();

		WebElement colorEle = driver.findElement(By.xpath("(//select[@class='form-control cat_item_option '])[1]"));
		Select sel1 = new Select(colorEle);
		sel1.selectByVisibleText("Gold");
		WebElement memoryEle = driver.findElement(By.xpath("(//select[@class='form-control cat_item_option '])[2]"));
		Select sel2 = new Select(memoryEle);
		sel2.selectByVisibleText("128");

		driver.findElement(By.xpath("//button[@id='oi_order_now_button']")).click();
		String reqNum = driver.findElement(By.xpath("//a[@id='requesturl']")).getText();
		System.out.println("Request number is: " + reqNum);

		File src = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File("./snap/assignment3.png");
		FileUtils.copyFile(src, dest);

		driver.quit();

	}

}
