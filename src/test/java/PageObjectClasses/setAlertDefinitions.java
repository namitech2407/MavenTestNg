package PageObjectClasses;

import java.security.PublicKey;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import PageObjectTestClasses.LogInTest;
import PageObjectTestClasses.intelliviewHistoricalDataTest;
import PageObjectTestClasses.parameterSelectionTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class setAlertDefinitions extends intelliviewHistoricalDataTest {
	private static final String css = null;
	public WebDriver driver;
	public LogInTest lTest;
	parameterSelection param1;
	LogInPage logIn1;

	//constructor
	public setAlertDefinitions(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
			
	}

	//webElemts
	@FindBy(xpath = "//button[@class='btn btn-primary ng-star-inserted'][2]")
	private WebElement updateParameterSettings;
	@FindBy(xpath = "(//input[contains(@type,'number')])[3]")
	private WebElement set_low_level_fault;
	@FindBy(xpath = "(//input[contains(@type,'number')])[4]")
	private WebElement set_low_level_alarm ;
	@FindBy(xpath = "(//input[contains(@type,'number')])[5]")
	private WebElement set_high_level_alarm;
	@FindBy(xpath = "(//input[contains(@type,'number')])[6]")
	private WebElement set_high_level_fault;
	@FindBy(xpath = "(//input[contains(@type,'text')])[6]")
	private WebElement low_level_fault_text;
	@FindBy(xpath = "(//input[contains(@type,'text')])[8]")
	private WebElement low_level_alarm_text;
	@FindBy(xpath = "(//input[contains(@type,'text')])[10]")
	private WebElement high_level_alarm_text; 
	@FindBy(xpath = "(//input[contains(@type,'text')])[12]")
	private WebElement high_level_fault_text; 
	@FindBy(xpath = "(//*[@id=\"updateParameter\"]/tbody/tr[1]/td[10]/ng-select)")
	private WebElement int_llf_dpdwn; 
	@FindBy(xpath = "(//div[contains(.,'SMS')])[14]")
	private WebElement sms_llf; 
	@FindBy(xpath = "//span[contains(.,'In App Notification')]")
	private WebElement inAPP_llf; 
	@FindBy(xpath = "(//div[contains(.,'Email')])[14]")
	private WebElement EMAIL_llf; 
	@FindBy(xpath = "(//input[@class='ng-star-inserted'])[3]")
	private WebElement int_lla_dpdwn;
	@FindBy(xpath = "(//span[contains(.,'SMS')])[2]")
	private WebElement sms_lla;
	@FindBy(xpath = "(//span[contains(.,'In App Notification')])[2]")
	private WebElement inAPP_lla;
	@FindBy(xpath = "(//div[contains(.,'Email')])[17]")
	private WebElement EMAIL_lla; 
	@FindBy(xpath = "(//input[@class='ng-star-inserted'])[4]")
	private WebElement int_hla_dpdwn;
	@FindBy(xpath = "//div[@class='ng-option ng-option-marked ng-star-inserted']")
	private WebElement sms_hla; 
	@FindBy(xpath = "(//span[contains(.,'In App Notification')])[1]")
	private WebElement inApp_hla; 
	@FindBy(xpath = "(//div[contains(.,'Email')])[14]")
	private WebElement EMAIL_hla;
	@FindBy(xpath = "(//input[@class='ng-star-inserted'])[5]")
	private WebElement int_hlf_dpdwn;
	@FindBy(xpath = "(//span[contains(.,'SMS')])[2]")
	private WebElement sms_hlf; 
	@FindBy(xpath = "(//span[contains(.,'In App Notification')])[1]")
	private WebElement inApp_hlf;
	@FindBy(xpath = "(//div[contains(.,'Email')])[14]")
	private WebElement EMAIL_hlf;
	@FindBy(xpath = "(//button[@title='Add user list'])[1]")
	private WebElement addUser;
	@FindBy(xpath = "(//div[@class='mat-radio-outer-circle'])[2]")
	private WebElement addUserwise;
	@FindBy(xpath = "(//input[@name='list_name'])[3]")
	private WebElement ifSelected;
	@FindBy(xpath = "(//div[contains(@class,'mat-radio-outer-circle')])[2]")
	private WebElement userwise_Select;
	
	

	/*
	
	@Test(priority = 0)
	public void initialization() throws InterruptedException {
		logIn1 = new LogInPage(driver);
		
		setUP();
		login();
		
	}
		@Test(priority = 1)
		public void parasel() throws InterruptedException {
			//PageFactory.initElements(driver, this);
			param1=new parameterSelection(driver);
			param1.parameterSelection();
			}
*/
	
	@Test(priority = 2)
	public void setThresholdValue() throws InterruptedException {
		updateParameterSettings.click();
		set_low_level_fault.clear();
		set_low_level_alarm.clear();
		set_high_level_alarm.clear();
		set_high_level_fault.clear();
		Thread.sleep(3000);
		set_low_level_fault.sendKeys("5");
		Thread.sleep(3000);
		set_low_level_alarm.sendKeys("10");
		Thread.sleep(3000);
		set_high_level_alarm.sendKeys("15");
		Thread.sleep(3000);
		set_high_level_fault.sendKeys("20");
		Thread.sleep(3000);

	}
	
	@Test(priority = 3)
	public void setAlertText() throws InterruptedException {
		updateParameterSettings.click();
		low_level_fault_text.sendKeys("llf");
		low_level_alarm_text.sendKeys("lla");
		high_level_alarm_text.sendKeys("hla");
		high_level_fault_text.sendKeys("hlf");
	}
	@Test(priority = 4)
	public void setIntegrationModeLlf() throws InterruptedException {
		//Select dropdown = new Select(int_llf_dpdwn);
	int_llf_dpdwn.click();
		//dropdown.selectByIndex(0);
		//dropdown.selectByIndex(6);
		//dropdown.selectByIndex(7);
		
		// Get all selected options
		sms_llf.click();
		Thread.sleep(3000);
		inAPP_llf.click();
		Thread.sleep(3000);
		EMAIL_llf.click();
		Thread.sleep(3000);
	/*List<WebElement> options = driver.findElements(By.xpath("//*[@id=\"updateParameter\"]/tbody/tr[1]/td[10]/ng-select)"));
	for (WebElement option : options) {
	    option.click(); // Click on each ng-select option
	    */
	}
		
		
	@Test(priority = 5)
	public void setIntegrationModeLla() throws InterruptedException {
		
		Actions actions = new Actions(driver);
		actions.doubleClick(int_lla_dpdwn).perform();
		Thread.sleep(2000);

		//int_lla_dpdwn.click();
		//dropdown.selectByIndex(0);
		//dropdown.selectByIndex(6);
		//dropdown.selectByIndex(7);
		
		// // Get all selected options
		sms_lla.click();
		Thread.sleep(3000);
		inAPP_lla.click();
		Thread.sleep(3000);
		EMAIL_lla.click();
		Thread.sleep(3000);
		/*if (int_lla_dpdwn.isSelected()) {
            JavascriptExecutor executor = (JavascriptExecutor) driver;

            // Trigger the ng-select dropdown to open
            //executor.executeScript("arguments[0].click();", int_llf_dpdwn);

            // Select all options using JavaScript
            executor.executeScript(
                "Array.from(arguments[0].querySelectorAll('.ng-option'))"
                + ".forEach(option => option.click());",
                int_lla_dpdwn
            );
        }*/
		
		}	
	@Test(priority = 6)
public void setIntegrationModeHla() throws InterruptedException {
		
		Actions actions = new Actions(driver);
		actions.doubleClick(int_hla_dpdwn).perform();
		Thread.sleep(2000);

		//int_lla_dpdwn.click();
		//dropdown.selectByIndex(0);
		//dropdown.selectByIndex(6);
		//dropdown.selectByIndex(7);
		
		 // Get all selected options
		sms_hla.click();
		Thread.sleep(3000);
		inApp_hla.click();
		Thread.sleep(3000);
		EMAIL_hla.click();
		Thread.sleep(3000);
		/*if (int_hla_dpdwn.isEnabled()) {
            JavascriptExecutor executor = (JavascriptExecutor) driver;

            // Trigger the ng-select dropdown to open
            //executor.executeScript("arguments[0].click();", int_llf_dpdwn);

            // Select all options using JavaScript
            executor.executeScript(
                "Array.from(arguments[0].querySelectorAll('.ng-option'))"
                + ".forEach(option => option.click());",
                int_hla_dpdwn
            );
        }
		*/
		
		}			
				
	@Test(priority = 7)
	
	public void setIntegrationModeHlf() throws InterruptedException {
			
			Actions actions = new Actions(driver);
			actions.doubleClick(int_hlf_dpdwn).perform();
			Thread.sleep(2000);

			//int_lla_dpdwn.click();
			//dropdown.selectByIndex(0);
			//dropdown.selectByIndex(6);
			//dropdown.selectByIndex(7);
			
			 // Get all selected options
			sms_hlf.click();
			Thread.sleep(3000);
			inApp_hlf.click();
			Thread.sleep(3000);
			EMAIL_hlf.click();
			Thread.sleep(3000);
			/*if (int_hlf_dpdwn.isEnabled()) {
	            JavascriptExecutor executor = (JavascriptExecutor) driver;

	            // Trigger the ng-select dropdown to open
	            //executor.executeScript("arguments[0].click();", int_llf_dpdwn);

	            // Select all options using JavaScript
	            executor.executeScript(
	                "Array.from(arguments[0].querySelectorAll('.ng-option'))"
	                + ".forEach(option => option.click());",
	                int_hlf_dpdwn
	            );
	        }
			*/
			}				
	@Test(priority = 8)
	public void AddUser() throws InterruptedException {
			
		addUser.click();
		
		//ifSelected
		if (ifSelected.isEnabled()) {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", ifSelected);
            executor.executeScript("arguments[0].dispatchEvent(new Event('keydown', { key: 'Escape' }));", ifSelected);
        }
		userwise_Select.click();
		
			
			}				
	
	
		
	}
	

