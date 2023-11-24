package PageObjectTestClasses;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import PageObjectClasses.AggregatedDP_Conditional;
import PageObjectClasses.LogInPage;
import PageObjectClasses.createAggregatedDp;
import PageObjectClasses.parameterSelection;
import io.github.bonigarcia.wdm.WebDriverManager;


public class aggregatedDP_condn_test {

	WebDriver driver;
	parameterSelection param;
	LogInPage lPage1;
	createAggregatedDp adp;
	AggregatedDP_Conditional condn;	


@BeforeClass
	public void setUP() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		//driver.get("http://172.16.1.231:8082/simpliworks/#/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driver.get("http://172.16.1.231:8082/simpliView/#/simpliView/ManageTopology");
		driver.manage().window().maximize();


		//logInTest = new LogInTest(); 
		lPage1 = new LogInPage(driver);
		param = new parameterSelection(driver);
		adp = new createAggregatedDp(driver);
		condn =  new AggregatedDP_Conditional(driver);
		//log in
		
		lPage1.setUsername("admin"); 
		lPage1.setPassword("123"); 
		lPage1.ClickSubmit();
	
	}

	
		
	@Test(priority = 1)
	public void SelectParameterTest() throws InterruptedException {
		//lPage = new LogInPage(driver);
		//logInTest.testLogin();  
		//param=new parameterSelection(driver);
		param.parameterSelection();
	}
	@Test(priority = 2)
	public void create_Agg_DP() throws InterruptedException {
		//lPage = new LogInPage(driver);
		//logInTest.testLogin();
		//adp = new createAggregatedDp(driver);
		//condn = new AggregatedDP_Conditional(driver);
		//adp = new createAggregatedDp(driver);
		adp.param_selection_agg();
		adp.agg_dp_name_set();
		condn.testAggregatedDP();

	}
	
	@Test(priority = 3)
	public void closeDriver() throws InterruptedException {
		driver.quit();

	}

}
