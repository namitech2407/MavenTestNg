package PageObjectClasses;

import java.security.PublicKey;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ForCreation;

public class createAggregatedDp extends normalDPcreation {
	public createAggregatedDp(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	normalDPcreation normalDPcreation = new normalDPcreation(driver);

	//WebElemets
	@FindBy(xpath = "(//input[@type='radio'])[2]") private WebElement radio_agg;
	@FindBy(xpath = "//*[@id=\"dynamic-columns\"]/app-derived-paratmeters/div/div/div/div/form/div[3]/div/div/button[1]")
	protected WebElement agg_save;
	@FindBy(xpath = "(//input[@class='ng-star-inserted'])[1]")
	protected WebElement device_name_dpdn; //sendkeys
	@FindBy(xpath = "//span[@class='ng-option-label ng-star-inserted'][contains(.,'V_Status')]")
	public WebElement v_status; 
	@FindBy(xpath = "(//input[@class='ng-star-inserted'])[2]")
	public WebElement param_name_dpdn;
	@FindBy(xpath = "//span[@class='ng-option-label ng-star-inserted'][contains(.,'StatusBit_1')]")
	public WebElement statusBit1;
	@FindBy(xpath = "//input[contains(@value,'0')]")private WebElement False;
	

	@Test
	public void param_selection_agg() {

		//normalDPcreation normalDPcreation = new normalDPcreation(driver);
		normalDPcreation.add_dp_param();

	}

	@Test
	public void agg_dp_name_set() {
		normalDPcreation.parameterName.sendKeys("aggregations_dp");
		radio_agg.click();
		normalDPcreation.addDp.click();

	}

	@Test
	public void agg_feq() throws InterruptedException {
		// Replace these selectors with the appropriate ones for your web page
		By frequencyDropdownSelector = By.id("frequency");
		By aggregationsDropdownSelector = By.id("aggregation");

		// Get the dropdown elements
		Select frequencyDropdown = new Select(driver.findElement(frequencyDropdownSelector));
		Select aggregationsDropdown = new Select(driver.findElement(aggregationsDropdownSelector));

		// Get all frequency options
		for (WebElement frequencyOption : frequencyDropdown.getOptions()) {
			// Select a frequency option
			//frequencyDropdown.selectByVisibleText("hourly");
			frequencyDropdown.selectByVisibleText("Daily");
			//frequencyDropdown.selectByVisibleText

			// Get all aggregation options
			for (WebElement aggregationOption : aggregationsDropdown.getOptions()) {
				// Select an aggregation option
				//aggregationsDropdown.selectByVisibleText("None");
				aggregationsDropdown.selectByVisibleText("Total");
				//aggregationsDropdown.selectByVisibleText("Running Total");
				//aggregationsDropdown.selectByVisibleText("Difference");
				//aggregationsDropdown.selectByVisibleText("Simple AVG");
				//aggregationsDropdown.selectByVisibleText("Min");
				//aggregationsDropdown.selectByVisibleText("Max");
				// Perform actions with the selected frequency and aggregation combination
				// You can add your test logic here
				//select UOM
				UOM.click();
				Select dropdown = new Select(UOM);
				dropdown.selectByVisibleText("Test");
			
				expand_301.click();
				Thread.sleep(3000);
				expand_param.click();
				Thread.sleep(2000);
				normalDPcreation.dragnDrop();
				Thread.sleep(4000);
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3000));
				WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(agg_save));	
				
				//WebElement saveButton = driver.findElement(agg_save);
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", agg_save);
				agg_save.click();
				//saveButton.click();
				//Thread.sleep(2000);

				// Navigate back to the main page or reset the dropdowns if needed
				//driver.navigate().back();
				//frequencyDropdown = new Select(driver.findElement(frequencyDropdownSelector));
				//aggregationsDropdown = new Select(driver.findElement(aggregationsDropdownSelector));
			}
		}
	}
			@Test
			public void checkDpCREATED() throws InterruptedException {
				// Assuming driver is an instance of WebDriver
				String mainWindowHandle = driver.getWindowHandle();

				// Switch to the pop-up window
				for (String windowHandle : driver.getWindowHandles()) {
				    if (!windowHandle.equals(mainWindowHandle)) {
				        driver.switchTo().window(windowHandle);

				        // Validate pop-up content
				        String expectedTitle = "data Added successfully";
				        String actualTitle = driver.getTitle();
				        Assert.assertEquals(actualTitle, expectedTitle);

				        // Perform actions within the pop-up (if needed)
				        WebElement popupElement = driver.findElement(By.id("cd1"));
				        Assert.assertTrue(popupElement.isDisplayed());

				        // Switch back to the main window
				       // driver.switchTo().window(mainWindowHandle);
				        break;
				    }
				    System.out.println("data saved");
				}

				
			}
		
	}



