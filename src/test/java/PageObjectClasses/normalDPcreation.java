package PageObjectClasses;

import java.time.Duration;

import org.apache.poi.hssf.record.PageBreakRecord.Break;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import org.openqa.selenium.JavascriptExecutor;
public class normalDPcreation {

	public WebDriver driver;

	//constructor
	public normalDPcreation(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	//WebElements
	@FindBy(xpath ="//*[@id=\"uitree\"]/div/ul/p-treenode/li[2]/ul/p-treenode/li[2]/ul/p-treenode/li[2]/ul/p-treenode[3]/li[2]/ul/p-treenode[1]/li[2]/ul/p-treenode/li[2]/ul/p-treenode[1]/li[2]/div/span[3]/span/span" )
	private WebElement IOT_DEV_301;
	@FindBy(xpath = "//span[contains(.,'Add DP Parameter')]")public static WebElement add_DP_Parameter;
	@FindBy(xpath = "//input[@formcontrolname='parameterName']") public static WebElement parameterName;
	@FindBy(xpath = "//button[contains(.,'Add')]") public WebElement addDp;
	@FindBy(xpath = "//select[contains(@formcontrolname,'uom')]")public WebElement UOM;
	@FindBy(xpath = "//select[contains(@id,'selectedOperatorType')]")public WebElement OPRATOR_TYPE;
	@FindBy(xpath = "(//span[@class='ui-tree-toggler fa fa-fw fa-caret-right'])[3]")public WebElement expand_301;
	@FindBy(xpath = "(//span[@class='ui-tree-toggler fa fa-fw fa-caret-right'])[3]")public WebElement expand_param;
	@FindBy(xpath = "(//span[contains(.,'D_301_Param2')])[1]")public WebElement IOT_DEV_302;
	@FindBy(xpath = "(//p[contains(@class,'text-danger')])[2]")public WebElement box;
	@FindBy(xpath = "//div[@class='appCalculatorMathOperand ng-star-inserted'][contains(.,'/')]")public WebElement divide;
	@FindBy(xpath = "//div[@class='appCalculatorMathOperand'][contains(.,'1')]")public WebElement one;
	@FindBy(xpath = "//div[@class='appCalculatorMathOperand'][contains(.,'0')]")public WebElement zero;
	@FindBy(xpath = "//button[@title='Validate Expression']")public WebElement validate;
	@FindBy(xpath = "//button[contains(@type,'submit')]")public WebElement save;



	@Test
	public void add_dp_param () {

		// Create an Actions object
		Actions actions = new Actions(driver);

		// Right-click the element
		actions.contextClick(IOT_DEV_301).perform();

		// Perform other actions as needed (e.g., select context menu options)
		add_DP_Parameter.click();

	}

	@Test
	public void dp_name_set (String dp_name) {
		parameterName.sendKeys(dp_name);
		addDp.click();

	}
	@Test
	public void dp_creation() throws InterruptedException {
		//select UOM
		UOM.click();
		Select dropdown = new Select(UOM);
		dropdown.selectByVisibleText("Test");;

		//SELECT OPERATOR
		OPRATOR_TYPE.click();
		Select dropdown1 = new Select(OPRATOR_TYPE);
		dropdown1.selectByVisibleText("Math");

		expand_301.click();
		Thread.sleep(3000);
		expand_param.click();
		Thread.sleep(2000);
	}
	@Test
	public void dragnDrop() throws InterruptedException{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			//WebElement elementToClick = driver.findElement(By.cssSelector("button.btn.btn-outline-primary"));
			wait.until(ExpectedConditions.elementToBeClickable(IOT_DEV_302));
			//DRAG AND DROP IOT 302
			Actions actions = new Actions(driver);
			// Perform the drag and drop operation
			actions.dragAndDrop(IOT_DEV_302, box).build().perform();
			Thread.sleep(2000);
			
	}
		// Switch back to the default content
		//  driver.switchTo().defaultContent();
			public void opration_ndp() throws InterruptedException{
		divide.click();
		one.click();
		// zero.click();

		//Click 3 times on zero

		// Number of times to click
		int numberOfClicks = 3;

		// Perform the clicks
		for (int i = 0; i < numberOfClicks; i++) {
			zero.click();
		}

		//validate.click();
		//Thread.sleep(2000);
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",validate);
		validate.click();
		
		save.click();
		Thread.sleep(3000);

	}


}
