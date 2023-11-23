package PageObjectClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class intelliviewHistoricalData {
	public WebDriver driver;

	//constructor
	public intelliviewHistoricalData(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	//webElemets
	@FindBy(xpath = "//*[@id=\"dynamic-columns\"]/app-device-list/div[2]/div[2]/label[3]/input")
	private WebElement historicalData;
	@FindBy(xpath = "//*[@id=\"dtFrom\"]/span/input")
	private WebElement dateInput1;
	@FindBy(xpath = "//*[@id=\"dtTo\"]/span/input")
	private WebElement dateInput2;
	@FindBy(xpath = "//*[@id=\"dynamic-columns\"]/app-device-list/div[2]/div[3]/div[1]/div[5]/button")
	private WebElement selectParameter;
	@FindBy(xpath = "//*[@id=\"noRow\"]/div/div[2]/div[2]/table/thead/tr/th[2]/input")
	private WebElement uncheckSelectAll;
	@FindBy(xpath = "//input[@value='D_301_Param1']")
	private WebElement IOT_301;
	@FindBy(xpath = "//*[@id=\"footer\"]/button")
	private WebElement okayBtn;
	@FindBy(xpath = "//*[@id=\"dynamic-columns\"]/app-device-list/div[2]/div[3]/div[1]/div[6]/button")
	private WebElement submitBtn; 
	@FindBy(xpath = "//*[@id=\"dynamic-columns\"]/app-device-list/div[2]/div[2]/img")
	private WebElement dwnld_btn; 

	//action methods

	@Test
	public void GetHistoricalData() throws InterruptedException {
		historicalData.click();
		Thread.sleep(3000);
	}
	@Test
	public void StartDATE() throws InterruptedException {
		dateInput1.click();
		dateInput1.clear();
		String startDate = "28-10-2023 12:52:24"; // Provide the start date
		dateInput1.sendKeys(startDate);
	}

	public void EndDATE() throws InterruptedException {
		dateInput2.click();
		dateInput2.clear();
		String EndDate = "30-10-2023 12:52:24"; // Provide the start date
		dateInput1.sendKeys(EndDate);
	}
	public void SelectParameter() throws InterruptedException {
		selectParameter.click();
		uncheckSelectAll.click();
		IOT_301.click();
		okayBtn.click();
		
	}
	
	public void Submitbtn() throws InterruptedException {
		submitBtn.click();
		
	}
	public void dwnld_btn() throws InterruptedException {
		dwnld_btn.click();
		
	}
	
}
