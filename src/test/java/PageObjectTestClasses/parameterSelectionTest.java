package PageObjectTestClasses;

import java.sql.Driver;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import PageObjectClasses.LogInPage;
import PageObjectClasses.parameterSelection;
import io.github.bonigarcia.wdm.WebDriverManager;

public class parameterSelectionTest {
	WebDriver driver;
	LogInPage logIn;
	LogInTest logInTest;
	parameterSelection param;
	LogInPage lPage1;
	
	@Test(priority = 1)
	public void setUP() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		//driver.get("http://172.16.1.231:8082/simpliworks/#/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driver.get("http://172.16.1.231:8082/simpliView/#/simpliView/ManageTopology");
		driver.manage().window().maximize();
		
		logIn = new LogInPage(driver);
		logInTest = new LogInTest(); 
		lPage1 = new LogInPage(driver);
	}
	
  @Test(priority = 2)
  public void login() throws InterruptedException {
	  
	 // logInTest.testLogin();
	  lPage1.setUsername("admin"); 
	lPage1.setPassword("123"); 
	lPage1.ClickSubmit();
  }
  @Test(priority = 3)
public void SelectParameterTest() throws InterruptedException {
	//lPage = new LogInPage(driver);
	 //logInTest.testLogin();  
	param=new parameterSelection(driver);
	param.parameterSelection();
	
}
  @Test(priority = 3)
  public void checkkVisibleDropdwn() throws InterruptedException {
  	//lPage = new LogInPage(driver);
  	 //logInTest.testLogin();  
  	param=new parameterSelection(driver);
  	param.parameterSelection();
  	
  }
}
