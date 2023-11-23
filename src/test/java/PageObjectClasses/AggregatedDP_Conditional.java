package PageObjectClasses;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class AggregatedDP_Conditional {
	WebDriver driver;
	createAggregatedDp aDp;
	public AggregatedDP_Conditional(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@Test
	public void testAggregatedDP() throws InterruptedException {
		// Select a specific frequency and aggregation combination
		selectFrequencyAndAggregation("Daily", "Total");

		// Handle additional actions based on the selected combination
		conditional_agg("V_Status");

		// Perform "assign_param" action
		assign_param();
	}

	public void selectFrequencyAndAggregation(String frequency, String aggregation) {
		// Replace these selectors with the appropriate ones for your web page
		By frequencyDropdownSelector = By.id("frequency");
		By aggregationsDropdownSelector = By.id("aggregation");

		// Get the dropdown elements
		Select frequencyDropdown = new Select(driver.findElement(frequencyDropdownSelector));
		Select aggregationsDropdown = new Select(driver.findElement(aggregationsDropdownSelector));

		// Select the specified frequency and aggregation
		frequencyDropdown.selectByVisibleText(frequency);
		aggregationsDropdown.selectByVisibleText(aggregation);
	}

	public void conditional_agg(String deviceNm) {
		// Handle conditional actions based on the selected frequency and aggregation
		// ...

		// Example: Select device name, click elements, etc.
		aDp = new createAggregatedDp(driver);
		aDp.device_name_dpdn.sendKeys(deviceNm);   
		aDp.v_status.click();
		aDp.param_name_dpdn.click();
		aDp.statusBit1.click();
	}

	public void assign_param() throws InterruptedException {
		// Perform "assign_param" action
		aDp = new createAggregatedDp(driver);
		aDp.UOM.click();
		Select dropdown = new Select(aDp.UOM);
		dropdown.selectByVisibleText("Test");
	
		aDp.expand_301.click();
		Thread.sleep(3000);
		aDp.expand_param.click();
		Thread.sleep(2000);
		aDp.normalDPcreation.dragnDrop();
		Thread.sleep(4000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3000));
		WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(aDp.agg_save));	
		
		//WebElement saveButton = driver.findElement(agg_save);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", aDp.agg_save);
		aDp.agg_save.click();
		
		// ...

		// Example: Rest of the actions for "assign_param"
	}
}
