package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class FaceBook {

	public static void main(String[] args) {
		
	// Testdata
		String firstName = "Sesh";
		String lastName = "Srinivasan";
		String phoneNum = "9876543210";
		String password = "Testleaf@123";
	// Webelements
		String creatAccountXpath = "//a[text()='Create New Account']";
		String firstNameXpath = "//input[@name='firstname']";
		String lastNameXpath = "//input[@name='lastname']";
		String phoneNumXpath = "//input[@name='reg_email__']";
		String passwordXpath = "//input[@name='reg_passwd__']";
		String maleRadioXpath = "(//input[@name='sex'])[2]";
		String dateXpath = "(//select[@name='birthday_day'])";
		String monthXpath = "(//select[@id='month'])";
		String yearXpath = "(//select[@id='year'])";
		
		FirefoxDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://en-gb.facebook.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath(creatAccountXpath)).click();
		driver.findElement(By.xpath(firstNameXpath)).sendKeys(firstName);
		driver.findElement(By.xpath(lastNameXpath)).sendKeys(lastName);
		driver.findElement(By.xpath(phoneNumXpath)).sendKeys(phoneNum);
		driver.findElement(By.xpath(passwordXpath)).sendKeys(password);
		Select date = new Select(driver.findElement(By.xpath(dateXpath)));
		Select month = new Select(driver.findElement(By.xpath(monthXpath)));
		Select year = new Select(driver.findElement(By.xpath(yearXpath)));
		date.selectByVisibleText("13");
		month.selectByIndex(6);
		year.selectByValue("1990");
		driver.findElement(By.xpath(maleRadioXpath)).click();
		driver.close();

	}

}
