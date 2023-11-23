package PageObjectTestClasses;

import java.sql.Driver;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import PageObjectClasses.LogInPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LogInTest {

	WebDriver driver;
	LogInPage lPage; 	
	@BeforeClass
	public void setUP() {
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		//driver.get("http://172.16.1.231:8082/simpliworks/#/");
		driver.get("http://172.16.1.231:8082/simpliView/#/simpliView/ManageTopology");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driver.manage().window().maximize();
		
		
	}

	//@Test(priority=1)
	//public void testLogo() {
		//lPage= new LogInPage(driver);
		//lPage.CheckLogoPresence();
		//Assert.assertEquals(lPage.CheckLogoPresence(), true);
	//}

	@Test(priority=2)
	public void testLogin() throws InterruptedException {
		lPage = new LogInPage(driver);
		lPage.setUsername("admin");
		Thread.sleep(3000);
		lPage.setPassword("123");
		Thread.sleep(3000);
		lPage.ClickSubmit();
		Thread.sleep(3000);
		
		driver.getTitle();
		Assert.assertEquals(driver.getTitle(), "IntelleView");

	}

	@AfterClass
	public void tesrDown() {

		driver.quit();
	}
}
