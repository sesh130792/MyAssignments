package week4.assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestHandles {
	public static void main(String[] args) {
		
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		
		ChromeDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://leafground.com/window.xhtml;jsessionid=node0ohpw87cjok1dz9p1fgudvj6l12019.node0");
		driver.findElement(By.xpath("//button[@id='j_idt88:new']")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windows = new ArrayList<String>(windowHandles);
		
		//one window
		driver.switchTo().window(windows.get(1));
		System.out.println(driver.getTitle());
		driver.close();
		driver.switchTo().window(windows.get(0));
		System.out.println(driver.getTitle());
		
		//multiple window
		driver.findElement(By.xpath("//span[text()='Open Multiple']/..")).click();
		Set<String> windowHandles2 = driver.getWindowHandles();
		List<String> windows2 = new ArrayList<String>(windowHandles2);
		driver.switchTo().window(windows2.get(2));
		System.out.println(driver.getTitle());
		driver.close();
		driver.switchTo().window(windows2.get(1));
		System.out.println(driver.getTitle());
		driver.close();
		driver.switchTo().window(windows.get(0));
		System.out.println(driver.getTitle());
	}

}
