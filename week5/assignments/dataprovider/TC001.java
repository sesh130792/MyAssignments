package marathon.testng.dataprovider;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC001 extends BaseTC {

	
	@Test(dataProvider = "readTC001")
	public void createChatter(String Question, String text) throws InterruptedException {
		driver.executeScript("arguments[0].click();", driver.findElement(By.xpath("//a/span[text()='Chatter']")));
		System.out.println(driver.getTitle());
		assert driver.getTitle().equalsIgnoreCase("Chatter Home | Salesforce");
		driver.findElement(By.xpath("//span[text()='Question']")).click();
		driver.findElement(By.xpath("//textarea[@role='textbox']")).sendKeys(Question);
		driver.findElement(By.xpath("//div[@role='textbox']")).sendKeys(text);
		driver.findElement(By.xpath("//button[text()='Ask']")).click();
		System.out.println(driver.findElement(By.xpath("//div[contains(@class,'forceChatterFeedBodyQuestionWithoutAnswer')]/span")).getText());
//		assert driver.findElement(By.xpath("//div[contains(@class,'forceChatterFeedBodyQuestionWithoutAnswer')]/span"))
//				.getText().equalsIgnoreCase("What is your salary?");
		Thread.sleep(3000);
	}
	
	@DataProvider(name = "readTC001")
	public String[][] readTC001Data() throws IOException {
		String[][] tc001Data = ReadFromExcelMarathon.readExcel("./data/tc001.xlsx");
		return tc001Data;
	}
}
