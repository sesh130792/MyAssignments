package week5.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.sukgu.Shadow;

public class DeleteCallerServicenow {
	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://dev138130.service-now.com/");

		UpdateCallerServicenow caller = new UpdateCallerServicenow();
		driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys(caller.username);
		driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys(caller.password);
		driver.findElement(By.xpath("//button[@id='sysverb_login']")).click();
//		Thread.sleep(3000);

		Shadow sh = new Shadow(driver);
		sh.setImplicitWait(30);
		sh.findElementByXPath("//div[text()='All']").click();
		sh.findElementByXPath("//input[@id='filter']").sendKeys("Callers");
		sh.findElementByXPath("//span/mark[text()='Callers']").click();

		driver.switchTo().frame(sh.findElementByXPath("//iframe[@name='gsft_main']"));
		Select sel = new Select(driver.findElement(By.xpath("//select[@role='listbox']")));
		sel.selectByVisibleText("Last name");

		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("Sesh", Keys.ENTER);
		driver.findElement(By.xpath("//table[@id='sys_user_table']//tbody/tr[1]/td[3]/a")).click();
		driver.findElement(By.xpath("//button[@id='sysverb_delete_bottom']")).click();
		driver.findElement(By.xpath("//button[@id='ok_button']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("Sesh", Keys.ENTER);
		assert driver.findElement(By.xpath("//table[@id='sys_user_table']//tbody/tr[1]/td[3]/a")).getText() != "Sesh";

	}

}
