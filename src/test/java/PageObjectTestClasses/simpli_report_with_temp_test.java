package PageObjectTestClasses;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import PageObjectClasses.LogInPage;
import PageObjectClasses.simpli_report_with_temp;
import io.github.bonigarcia.wdm.WebDriverManager;

public class simpli_report_with_temp_test {
	WebDriver driver;
	LogInPage lPage; 	
	simpli_report_with_temp srp;
	

		
	
	//@FindBy(xpath = "//input[@name='email']") private WebElement username;
	//@FindBy(xpath = "//input[contains(@name,'password')]")private WebElement password;
	//@FindBy(xpath = "//button[@name='go']")private WebElement go;
	
	@BeforeClass
	public void setUP() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		//driver.get("http://172.16.1.231:8082/simpliworks/#/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driver.get("http://172.16.1.231:8082/simpliworks/#/");
		driver.manage().window().maximize();

		lPage = new LogInPage(driver);
		srp = new simpli_report_with_temp(driver);				
		//log in
		lPage.setUsername1("admin");
		Thread.sleep(3000);
		lPage.setPassword1("123");
		Thread.sleep(3000);
		lPage.ClickSubmit();
		Thread.sleep(3000);
	}
	
  @Test(priority = 1)
  public void create_report() throws InterruptedException {
	  srp.select_simpliReport();
	  srp.addWithTemplateReport();
	  srp.importDocs();
	  srp.dragNDrop();
	  srp.saveLatestReport();
  }
  
  @Test(priority = 2)
	public void closeDriver() throws InterruptedException {
		driver.quit();
 }
  
}
