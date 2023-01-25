package marathon.testng.dataprovider;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTC {
	
	ChromeOptions options;
	ChromeDriver driver;
	
	@Parameters({"url", "username", "password"})
	@BeforeMethod
	public void setUp(String url, String uname, String pwd) throws InterruptedException {
		options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("username")).sendKeys(uname);
		driver.findElement(By.id("password")).sendKeys(pwd);
		driver.findElement(By.id("Login")).click();
		
		driver.findElement(By.xpath("(//div[contains(@class, \"tooltipTrigger \")])[6]")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("(//input[@type='search'])[3]")).sendKeys("content");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button/span[text()='All Apps']/following::div//a")).click();
		Thread.sleep(5000);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
