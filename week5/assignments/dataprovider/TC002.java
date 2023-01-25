package marathon.testng.dataprovider;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC002 extends BaseTC {

	@Test(dataProvider = "readTC002")
	public void createNewOppurtunity(String name, String amount, String date) throws InterruptedException {
		driver.findElement(By.xpath("//a/span[text()='View All Key Deals']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[text()='New']/..")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys(name);
		driver.findElement(By.xpath("//label[text()='Type']/following::button")).click();
		driver.findElement(By.xpath("//span[text()='New Customer']")).click();
		driver.findElement(By.xpath("//label[text()='Lead Source']/following::button")).click();
		driver.findElement(By.xpath("//span[text()='Partner Referral']")).click();
		driver.findElement(By.xpath("//label[text()='Amount']/following::input")).sendKeys(amount);
		driver.findElement(By.xpath("//label[text()='Close Date']/following::input")).sendKeys(date);
		driver.findElement(By.xpath("//label[text()='Stage']/following::button")).click();
		driver.findElement(By.xpath("//label[text()='Stage']/following::span[text()='Needs Analysis']")).click();
		driver.findElement(By.xpath("//label[text()='Primary Campaign Source']/following::input")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//li[@class='slds-listbox__item'])[2]")).click();
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		assert driver.findElement(By.xpath("//div[@role='alertdialog']")).isDisplayed(); 
	}
	
	@DataProvider(name = "readTC002")
	public String[][] readTC001Data() throws IOException {
		String[][] tc002Data = ReadFromExcelMarathon.readExcel("./data/tc002.xlsx");
		return tc002Data;
	}
}
