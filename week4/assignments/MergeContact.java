package week4.assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class MergeContact {

	public static void main(String[] args) throws InterruptedException {
		String username = "democsr";
		String password = "crmsfa";
		String usernameXpath= "//input[@id='username']";
		String passwordXpath = "//input[@id='password']";
		String loginButtonXpath = "//input[@value='Login']";
		String crmsfaXpath = "//a[contains(text(), '/SFA')]";
		
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		
		ChromeDriver driver =  new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.findElement(By.xpath(usernameXpath)).sendKeys(username);
		driver.findElement(By.xpath(passwordXpath)).sendKeys(password);
		driver.findElement(By.xpath(loginButtonXpath)).click();
		driver.findElement(By.xpath(crmsfaXpath)).click();
		
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.linkText("Merge Contacts")).click();
		
		driver.findElement(By.xpath("//input[@id='ComboBox_partyIdFrom']/following::a")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windowHandlesList = new ArrayList<String>(windowHandles);
		driver.switchTo().window(windowHandlesList.get(1));
		driver.findElement(By.xpath("//span[text()='Contact List']/following::table[2]/../following-sibling::div[1]/table/tbody/tr/td/div/a")).click();
		
		driver.switchTo().window(windowHandlesList.get(0));
		driver.findElement(By.xpath("//input[@id='ComboBox_partyIdFrom']/following::a[2]")).click();
		Set<String> windowHandles2 = driver.getWindowHandles();
		List<String> windowHandlesList2 = new ArrayList<String>(windowHandles2);
		driver.switchTo().window(windowHandlesList2.get(1));
		driver.findElement(By.xpath("//span[text()='Contact List']/following::table[2]/../following-sibling::div[2]/table/tbody/tr/td/div/a")).click();	
		driver.switchTo().window(windowHandlesList2.get(0));
		driver.findElement(By.xpath("//a[text()='Merge']")).click();
		
		driver.switchTo().alert().accept();
		assert driver.getTitle() == "View Contact | opentaps CRM";
		
		Thread.sleep(5000);
		driver.quit();
	}

}
