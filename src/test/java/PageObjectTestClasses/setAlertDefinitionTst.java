package PageObjectTestClasses;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import PageObjectClasses.LogInPage;
import PageObjectClasses.intelliviewHistoricalData;
import PageObjectClasses.parameterSelection;
import PageObjectClasses.setAlertDefinitions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class setAlertDefinitionTst {
	WebDriver driver;
	LogInPage logIn;
	//LogInTest logInTest;
	parameterSelection param;
	LogInPage lPage1;
	//setAlertDefinitions IHD;
	setAlertDefinitions alert;
	
	
  @Test
  public void initialization() throws InterruptedException {
	  logIn = new LogInPage(driver);
	  //logInTest =  new LogInTest();
	  WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		//driver.get("http://172.16.1.231:8082/simpliworks/#/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driver.get("http://172.16.1.231:8082/simpliView/#/simpliView/ManageTopology");
		driver.manage().window().maximize();
		
		logIn = new LogInPage(driver);
		//logInTest = new LogInTest(); 
		lPage1 = new LogInPage(driver);
  }
		  @Test (priority =2)
		  public void login() {
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
		  @Test(priority = 4)
		  public void setAlertDefinitions() throws InterruptedException {
		  	alert=new setAlertDefinitions(driver);
		 alert.setThresholdValue();
		 alert.setAlertText();
		 alert.setIntegrationModeLlf();
		 alert.setIntegrationModeLla();
		 alert.setIntegrationModeHla();
		 alert.setIntegrationModeHlf();
		 alert.AddUser();
  
  }
}
