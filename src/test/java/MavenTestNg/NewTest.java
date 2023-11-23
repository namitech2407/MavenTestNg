package MavenTestNg;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import bsh.This;
import io.github.bonigarcia.wdm.WebDriverManager;

public class NewTest {
	WebDriver driver;

	@FindBy(xpath = "//*[@id=\"dynamic-columns\"]/app-device-list/div[2]/div[2]/label[3]")
	protected WebElement historicalData;
	@FindBy(xpath = "//*[@id=\"dtFrom\"]/span/input")
	protected WebElement dateInput1;
	@FindBy(xpath = "//*[@id=\"dtTo\"]/span/input")
	protected WebElement dateInput2;
	@FindBy(xpath = "//*[@id=\"dynamic-columns\"]/app-device-list/div[2]/div[3]/div[1]/div[5]/button")
	protected WebElement selectParameter;
	@FindBy(xpath = "//*[@id=\"noRow\"]/div/div[2]/div[2]/table/thead/tr/th[2]/input")
	protected WebElement uncheckSelectAll;
	@FindBy(xpath = "//*[@id=\"footer\"]/button")
	protected WebElement okayBtn;
	@FindBy(xpath = "//*[@id=\"dynamic-columns\"]/app-device-list/div[2]/div[3]/div[1]/div[6]/button")
	protected WebElement submitBtn;


	// constructor to initialize elements
	public NewTest(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@Test(priority=2)
	public void logIn() {

		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("123");
		driver.findElement(By.xpath("//button[@name='go']")).click();
	}

	@BeforeClass
	//@Test(priority=1)
	public void beforeClass() throws InterruptedException {
		/*System.setProperty("Webdriver.chrome.driver", "F:\\VegaAutomation\\chromeDriver_exe\\chromedriver-win32\\chromedriver.exe");
	 WebDriver driver = new ChromeDriver();
	 driver.manage().window().maximize();
	 driver.manage().deleteAllCookies();
	 driver.get("http://172.16.1.231:8082/simpliworks/#/");
	 //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 Thread.sleep(10);*/
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("http://172.16.1.231:8082/simpliworks/#/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));

	}
	@Test(priority=3)
	public void IntelliView() throws InterruptedException {

		//log in to intelliview

		driver.findElement(By.xpath("(//img[contains(@src,'190.svg')])[10]")).click();
		Thread.sleep(3000);
		//on premise env
		driver.findElement(By.xpath("//span[@class='ui-tree-toggler fa fa-fw fa-caret-right']")).click();
		Thread.sleep(3000);
		//pune baner
		driver.findElements(By.xpath("//span[@class='ui-tree-toggler fa fa-fw fa-caret-right']")).get(2).click();
		Thread.sleep(3000);
		//melting area
		driver.findElement(By.xpath("//*[@id=\"uitree\"]/div/ul/p-treenode/li[2]/ul/p-treenode/li[2]/ul/p-treenode/li[2]/ul/p-treenode[3]/li[2]/ul/p-treenode[1]/li[2]/div/span[1]")).click();
		Thread.sleep(3000);
		//eng monitor
		driver.findElement(By.xpath("//*[@id=\"uitree\"]/div/ul/p-treenode/li[2]/ul/p-treenode/li[2]/ul/p-treenode/li[2]/ul/p-treenode[3]/li[2]/ul/p-treenode[1]/li[2]/ul/p-treenode/li[2]/div/span[1]")).click();
		Thread.sleep(3000);
		//device selection
		driver.findElement(By.xpath("//*[@id=\"uitree\"]/div/ul/p-treenode/li[2]/ul/p-treenode/li[2]/ul/p-treenode/li[2]/ul/p-treenode[3]/li[2]/ul/p-treenode[1]/li[2]/ul/p-treenode/li[2]/ul/p-treenode[1]/li[2]/div/span[3]/span/span")).click();
		Thread.sleep(3000);
	}
	/*
	  @Test
	  public void updateParameterSettings() throws InterruptedException {

	  //update parameter settings
	  driver.findElement(By.xpath("//button[@class='btn btn-primary ng-star-inserted'][2]")).click();
	  // set low level fault
	  driver.findElement(By.xpath("//*[@id=\"updateParameter\"]/tbody/tr[1]/td[4]/input")).sendKeys("5");
	//set low level alarm 
	  driver.findElement(By.xpath("//*[@id=\"updateParameter\"]/tbody/tr[1]/td[5]/input")).sendKeys("10");
	//set high level alarm
	  driver.findElement(By.xpath("//*[@id=\"updateParameter\"]/tbody/tr[1]/td[6]/input")).sendKeys("15");
	//set high level fault
	  driver.findElement(By.xpath("//*[@id=\"updateParameter\"]/tbody/tr[1]/td[7]/input")).sendKeys("25");
	  }

	  @Test
	  public void AlertTextMessage() throws InterruptedException { 

	  //low level fault text
	  driver.findElements(By.xpath("//input[@type='text']")).get(5).sendKeys("llf");

	  //low level alarm text
	  driver.findElements(By.xpath("//input[@type='text']")).get(7).sendKeys("lla");

	  //high level alarm text
	  driver.findElements(By.xpath("//input[@type='text']")).get(9).sendKeys("hla");

	  //high level fault text
	  driver.findElements(By.xpath("//input[@type='text']")).get(11).sendKeys("hlf");

  }
	 @Test
	  public void integrationMode() throws InterruptedException { 
		  WebElement LLFIntmode = driver.findElement(By.xpath("//*[@id=\"updateParameter\"]/tbody/tr[1]/td[10]/ng-select")); //low level fault
		  LLFIntmode.click(); // This should open the ng-select dropdown

		  // Wait for ng-select options to load, if necessary
		 // WebDriverWait wait = new WebDriverWait(driver, 10);
		 // wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ng-dropdown-panel/ng-dropdown-panel/div/div")));
		  driver.findElement(By.xpath("//*[@id=\"updateParameter\"]/tbody/tr[1]/td[10]/ng-select")).click(); // Select sms
		  Thread.sleep(1000); // Optional pause
		  driver.findElement(By.xpath("/html/body/main-app/div[3]/app-manage-topology/div/div/div[2]/div[2]/app-device-list/div[2]/div[3]/div/div[2]/div/div[1]/table/tbody/tr[1]/td[10]/ng-select/ng-dropdown-panel/div/div[2]/div[7]")).click();

		  Thread.sleep(1000); // Optional pause
		  driver.findElement(By.xpath("/html/body/main-app/div[3]/app-manage-topology/div/div/div[2]/div[2]/app-device-list/div[2]/div[3]/div/div[2]/div/div[1]/table/tbody/tr[1]/td[10]/ng-select/ng-dropdown-panel/div/div[2]/div[8]")).click(); // Select email
		  Thread.sleep(1000); // Optional pause

		  driver.findElement(By.xpath("/html/body/main-app/div[3]/app-manage-topology/div/div/div[2]/div[2]/app-device-list/div[2]/div[3]/div/div[2]/div/div[1]/table/tbody/tr[1]/td[10]/ng-select/div[1]/span[2]/span")).click(); // Select sms
		  Thread.sleep(1000); // Optional pause



		  WebElement LLAIntmode = driver.findElement(By.xpath("//*[@id=\"updateParameter\"]/tbody/tr[1]/td[12]/ng-select/div[1]/div")); //low level ALARM
		  LLAIntmode.click(); // This should open the ng-select dropdown


		  driver.findElement(By.xpath("//div[@role='option'][1]")).click(); // Select sms
		  Thread.sleep(1000); // Optional pause
		  driver.findElement(By.xpath("//div[@role='option'][7]")).click(); // Select in app
		  Thread.sleep(1000); // Optional pause
		  driver.findElement(By.xpath("//span[@class='ng-option-label ng-star-inserted'][contains(.,'Email')]")).click(); // Select email
		  Thread.sleep(1000); // Optional pause
		  driver.findElement(By.xpath("//*[@id=\"updateParameter\"]/tbody/tr[1]/td[12]/ng-select/div[1]/span[2]/span")).click();

		  Thread.sleep(1000); 

		  WebElement HLAIntmode = driver.findElement(By.xpath("//*[@id=\"updateParameter\"]/tbody/tr[1]/td[12]/ng-select/div[1]/div")); //High level ALARM
		  HLAIntmode.click(); // This should open the ng-select dropdown


		  driver.findElement(By.xpath("//span[@class='ng-option-label ng-star-inserted'][1]")).click(); // Select sms
		  Thread.sleep(1000); // Optional pause
		  driver.findElement(By.xpath("//span[@class='ng-option-label ng-star-inserted'][7]")).click(); // Select in app
		  Thread.sleep(1000); // Optional pause
		  driver.findElement(By.xpath("//span[@class='ng-option-label ng-star-inserted'][8]")).click(); // Select email
		  Thread.sleep(1000); // Optional pause

		  driver.findElement(By.xpath("/html/body/main-app/div[3]/app-manage-topology/div/div/div[2]/div[2]/app-device-list/div[2]/div[3]/div/div[2]/div/div[1]/table/tbody/tr[1]/td[10]/ng-select/div[1]/span[2]/span")).click(); //ARROW UP
		  Thread.sleep(1000); // Optional pause


		  WebElement HLFIntmode = driver.findElement(By.xpath("//*[@id=\"updateParameter\"]/tbody/tr[1]/td[16]/ng-select")); //High level FAULT
		  HLFIntmode.click(); // This should open the ng-select dropdown


		  driver.findElement(By.xpath("//span[@class='ng-option-label ng-star-inserted'][1]")).click(); // Select sms
		  Thread.sleep(1000); // Optional pause
		  driver.findElement(By.xpath("//span[@class='ng-option-label ng-star-inserted'][7]")).click(); // Select in app
		  Thread.sleep(1000); // Optional pause
		  driver.findElement(By.xpath("//span[@class='ng-option-label ng-star-inserted'][8]")).click(); // Select email
		  Thread.sleep(1000); // Optional pause

		  driver.findElement(By.xpath("/html/body/main-app/div[3]/app-manage-topology/div/div/div[2]/div[2]/app-device-list/div[2]/div[3]/div/div[2]/div/div[1]/table/tbody/tr[1]/td[10]/ng-select/div[1]/span[2]/span")).click(); //ARROW UP
		  Thread.sleep(1000); // Optional pause

  }




/*  @AfterClass
  public void afterClass() {
	 driver.quit();
	 */

	@Test(priority = 5)
	public void HistoricalData() {
		historicalData.click();
		dateInput1.click();
		dateInput1.clear();
		
		String startDate = "28-10-2023 12:52:24"; // Provide the start date

		dateInput1.sendKeys(startDate);

		// End date selection
		dateInput2.click();
		dateInput2.clear();
		String endDate = "31-10-2023 12:52:24"; // Provide the end date

		dateInput2.sendKeys(endDate);
		// Select parameter list
		selectParameter.click();
		uncheckSelectAll.click();

		okayBtn.click();
		submitBtn.click();

	}

}



