package MavenTestNg.MavenTestNg;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Initialization {
	WebDriver driver;

	@Test(priority=1)
	public void SetUP() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("http://172.16.1.231:8082/simpliworks/#/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
	}

	@Test
	public void LogIn() throws InterruptedException {
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("123");
		driver.findElement(By.xpath("//button[@name='go']")).click();
	}
	
	@Test
	public void DriverClose() throws InterruptedException {
		driver.quit();
	}

	public void setup() {
		// TODO Auto-generated method stub
		
	}

	public void historicalDataTest() {
		// TODO Auto-generated method stub
		
	}
}
