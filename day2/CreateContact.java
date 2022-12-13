package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateContact {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "http://leaftaps.com/opentaps";
		String username = "democsr";
		String password = "crmsfa";
		String usernameXpath= "//input[@id='username']";
		String passwordXpath = "//input[@id='password']";
		String loginButtonXpath = "//input[@value='Login']";
		String crmsfaXpath = "//a[contains(text(), '/SFA')]";
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
		driver.findElement(By.xpath(usernameXpath)).sendKeys(username);
		driver.findElement(By.xpath(passwordXpath)).sendKeys(password);
		driver.findElement(By.xpath(loginButtonXpath)).click();
		driver.findElement(By.xpath(crmsfaXpath)).click();
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//a[text()='Create Contact']")).click();
		driver.findElement(By.xpath("//input[@id='firstNameField']")).sendKeys("Sesh");
		driver.findElement(By.xpath("//input[@id='lastNameField']")).sendKeys("Test");
		driver.findElement(By.xpath("//input[@id='createContactForm_firstNameLocal']")).sendKeys("Raj");
		driver.findElement(By.xpath("//input[@id='createContactForm_lastNameLocal']")).sendKeys("Test");
		driver.findElement(By.xpath("//input[@id='createContactForm_departmentName']")).sendKeys("Test");
		driver.findElement(By.xpath("//textarea[@id='createContactForm_description']")).sendKeys("Test description");
		driver.findElement(By.xpath("//input[@id='createContactForm_primaryEmail']")).sendKeys("testuser22@gmail.com");
		Select state = new Select(driver.findElement(By.xpath("//select[@id='createContactForm_generalStateProvinceGeoId']")));
		state.selectByVisibleText("New York");
		driver.findElement(By.xpath("//input[@class='smallSubmit']")).click();
		driver.findElement(By.xpath("//a[text()='Edit']")).click();
		driver.findElement(By.xpath("//textarea[@id='updateContactForm_description']")).clear();
		driver.findElement(By.xpath("//textarea[@name='importantNote']")).sendKeys("Important description");
		driver.findElement(By.xpath("//input[@name='submitButton']")).click();
		String title = driver.getTitle();
		System.out.println(title);
		driver.close();
		
			
	}

}
