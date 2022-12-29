package marathon2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.sukgu.Shadow;

public class ArchitectCertifications {

	public static void main(String[] args) throws IOException {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");

		ChromeDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://login.salesforce.com/");
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Testleaf$321");
		driver.findElement(By.xpath("//input[@id='Login']")).click();
		driver.findElement(By.xpath("//span[text()='Learn More']")).click();

		Set<String> allWindowsSet = driver.getWindowHandles();
		List<String> allWindowsList = new ArrayList<String>(allWindowsSet);
		driver.switchTo().window(allWindowsList.get(1));

		driver.findElement(By.xpath("//button[text()='Confirm']")).click();
		Shadow sh = new Shadow(driver);
		sh.findElementByXPath("//span[text()='Learning']").click();
		WebElement lotEle = sh.findElementByXPath("//span[text()='Learning on Trailhead']");
		lotEle.click();
		sh.findElementByXPath("//a[text()='Salesforce Certification']").click();

		driver.findElement(By.xpath("(//div[@class='roleMenu-item_text']/..)[2]")).click();
		assert driver.getTitle() == "Certification - Architect Overview";
		String summary = driver.findElement(By.xpath("//h1[text()='Salesforce Architect']/following::div[1]"))
				.getText();
		System.out.println("Architect summary: ");
		System.out.println(summary);

		System.out.println("Certifications List: ");
		List<String> certifications = new ArrayList<String>();
		List<WebElement> certificationsEleList = driver
				.findElements(By.xpath("//div[@class='credentials-card_title']/a"));
		for (WebElement ele : certificationsEleList) {
			certifications.add(ele.getText());
		}
		System.out.println(certifications.toString());
		driver.executeScript("arguments[0].scrollIntoView();",
				driver.findElement(By.xpath("//h1[text()='Salesforce Architect Credentials']")));
		File src = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File("./snap/assignment2.png");
		FileUtils.copyFile(src, dest);

		driver.quit();
	}

}
