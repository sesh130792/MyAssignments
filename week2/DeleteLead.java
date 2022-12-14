package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class DeleteLead {

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
		driver.findElement(By.xpath("//span[text()='Lead List']/following::div//table/tbody/tr/td[1]/div/a")).click();
		/*
		 * Click find leads button
		   Verify message "No records to display" in the Lead List. This message confirms the successful deletion
		   Close the browser (Do not log out)
		 */
	

	}

}
