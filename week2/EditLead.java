package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class EditLead {
	
	public static void main(String[] args) {
		
		String url = "http://leaftaps.com/opentaps";
		String username = "democsr";
		String password = "crmsfa";
		String usernameXpath= "//input[@id='username']";
		String passwordXpath = "//input[@id='password']";
		String loginButtonXpath = "//input[@value='Login']";
		String crmsfaXpath = "//a[contains(text(), '/SFA')]";
		String leadsXpath = "//a[text()='Leads']";
		String findLeadsXpath = "//a[text()='Find Leads']";
		String firstnameXpath = "(//input[@name='firstName'])[3]";
		
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
		driver.findElement(By.xpath(firstnameXpath)).sendKeys("test");
		//click on first result
		driver.findElement(By.xpath("//span[text()='Lead List']/following::div//table/tbody/tr/td[1]/div/a")).click();
		driver.findElement(By.xpath("//a[text()='Edit']")).click();
		driver.findElement(By.xpath("//input[@id='updateLeadForm_companyName']")).clear();
		driver.findElement(By.xpath("//input[@id='updateLeadForm_companyName']")).sendKeys("Test");	
		driver.findElement(By.xpath("//input[@value='Update']")).click();
		String updatedCompany = driver.findElement(By.xpath("//span[@id='viewLead_companyName_sp']")).getText();
		assert updatedCompany.split(" ")[0] == "Test";
		driver.close();
	}

}
