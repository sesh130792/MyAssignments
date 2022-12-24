package week4.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class DropdownA2 {
	public static void main(String[] args) {

		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://leafground.com/select.xhtml;jsessionid=node01b6hhw7csjf211q4hnvqtdlyg710515.node0");

		Select automationToolDd = new Select(driver
				.findElement(By.xpath("//h5[text()='Which is your favorite UI Automation tool?']/following::select")));
		automationToolDd.selectByVisibleText("Selenium");

		driver.findElement(By.xpath("//div[@id='j_idt87:country']")).click();
		driver.findElement(By.xpath("//li[text()='India']")).click();

		try {
			driver.findElement(By.xpath("//div[@id='j_idt87:city']")).click();
			driver.findElement(By.xpath("//li[text()='Chennai']")).click();
		} catch (StaleElementReferenceException e) {
			driver.findElement(By.xpath("//div[@id='j_idt87:city']")).click();
			driver.findElement(By.xpath("//li[text()='Chennai']")).click();
		}

		driver.findElement(By.xpath("//h5[text()='Choose the Course']/following::div/button")).click();
		driver.findElement(By.xpath("//li[text()='Selenium WebDriver']")).click();
//		driver.findElement(By.xpath("//h5[text()='Choose the Course']/following::div/button")).click();
		driver.findElement(By.xpath("//li[text()='RestAssured']")).click();

		driver.findElement(By.xpath("//div[@id='j_idt87:lang']")).click();
		driver.findElement(By.xpath("//li[text()='Tamil']")).click();

		try {
			driver.findElement(By.xpath("//div[@id='j_idt87:value']")).click();
			driver.findElement(By.xpath("//li[@id='j_idt87:value_1']")).click();
		} catch (StaleElementReferenceException e) {
			driver.findElement(By.xpath("//div[@id='j_idt87:value']")).click();
			driver.findElement(By.xpath("//li[@id='j_idt87:value_1']")).click();
		}

	}

}
