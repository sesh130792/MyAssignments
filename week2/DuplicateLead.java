package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class DuplicateLead {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "http://leaftaps.com/opentaps";
		String username = "democsr";
		String password = "crmsfa";
		String usernameXpath= "//input[@id='username']";
		String passwordXpath = "//input[@id='password']";
		String loginButtonXpath = "//input[@value='Login']";
		String crmsfaXpath = "//a[contains(text(), '/SFA')]";
		String leadsXpath = "//a[text()='Leads']";
		String findLeadsXpath = "//a[text()='Find Leads']";
		
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
		driver.findElement(By.xpath(usernameXpath)).sendKeys(username);
		driver.findElement(By.xpath(passwordXpath)).sendKeys(password);
		driver.findElement(By.xpath(loginButtonXpath)).click();
		driver.findElement(By.xpath(crmsfaXpath)).click();
		driver.findElement(By.xpath(leadsXpath)).click();
		driver.findElement(By.xpath(findLeadsXpath)).click();
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("9876543210");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		String leadID = driver.findElement(By.xpath("//span[text()='Lead List']/following::div//table/tbody/tr/td[1]/div/a")).getText();
		System.out.println(leadID);
		String fname = driver.findElement(By.xpath("//span[text()='Lead List']/following::div//table/tbody/tr/td[3]/div/a")).getText();
		System.out.println(fname);
		driver.findElement(By.xpath("//span[text()='Lead List']/following::div//table/tbody/tr/td[1]/div/a")).click();
		driver.findElement(By.xpath("//a[text()='Duplicate Lead']")).click();
		assert driver.getTitle() == "Duplicate Lead | opentaps CRM";
		driver.findElement(By.xpath("//input[@name='submitButton']")).click();
		assert fname == driver.findElement(By.xpath("//span[@id='viewLead_firstName_sp']")).getText();
		driver.close();
	}

}
