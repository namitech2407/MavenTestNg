package PageObjectClasses;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class simpli_report_with_temp {
	public WebDriver driver;

	public simpli_report_with_temp(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	//locators
	@FindBy(xpath = "(//img[contains(@src,'190.svg')])[12]")private WebElement simpliReportLogoElement;
	@FindBy(xpath = "//span[@class='fa fa-plus']")private WebElement add_report;
	@FindBy(xpath = "//span[@class='ui-menuitem-text'][contains(.,'With Template')]")private WebElement with_template;
	@FindBy(xpath = "//span[contains(@class,'fa fa-upload')]")private WebElement import_doc;
	@FindBy(xpath = "(//input[contains(@role,'combobox')])[1]")private WebElement dpdwn;
	@FindBy(xpath = "//input[contains(@autocomplete,'a211eca3df5b')]")private WebElement selectTemplate;
	@FindBy(xpath = "//span[contains(.,'nn_dl_ver')]")private WebElement dl_ver;
	@FindBy(xpath = "//strong[contains(.,'Import')]")private WebElement Import;
	@FindBy(xpath = "//span[contains(@class,'ui-tree-toggler fa fa-fw fa-caret-right')]")private WebElement on_premise_env;
	@FindBy(xpath = "(//span[contains(@class,'ui-tree-toggler fa fa-fw fa-caret-right')])[3]")private WebElement pune_baner;
	@FindBy(xpath = "(//span[contains(@class,'ui-tree-toggler fa fa-fw fa-caret-right')])[3]")private WebElement melting_area;
	@FindBy(xpath = "(//span[contains(@class,'ui-tree-toggler fa fa-fw fa-caret-right')])[3]")private WebElement eng_monitor;
	@FindBy(xpath = "(//span[contains(@class,'ui-tree-toggler fa fa-fw fa-caret-right')])[3]")private WebElement iot_dev_301;
	@FindBy(xpath = "(//div[@pdraggable='dd'][contains(.,'D_301_Param1')])[2]")private WebElement iot_dev_301para1;
	@FindBy(xpath = "(//div[@pdraggable='dd'][contains(.,'D_301_Param2')])[2]")private WebElement iot_dev_301para2;
	@FindBy(xpath = "//*[@id=\"spreadsheet\"]/div[2]/table/tbody/tr[4]/td[5]")private WebElement field1;
	@FindBy(xpath = "//*[@id=\"spreadsheet\"]/div[2]/table/tbody/tr[4]/td[6]")private WebElement field2;
	@FindBy(xpath = "//span[contains(@class,'fa fa-floppy-o')]")private WebElement save;
	@FindBy(xpath = "//button[@class='btn btn-primary ng-star-inserted'][contains(.,'Submit')]")private WebElement latest_sbmt;
	@FindBy(xpath = "//input[contains(@autocomplete,'abc54d16e0f3')]")private WebElement feq_selectn;
	@FindBy(xpath = "//span[@class='ng-option-label ng-star-inserted'][contains(.,'Minute')]")private WebElement minute;
	@FindBy(xpath = "//span[contains(.,'Horizontal')]")private WebElement hz;
	@FindBy(xpath = "//input[contains(@autocomplete,'a3673896487b')]")private WebElement direction;
	@FindBy(xpath = "//input[contains(@value,'withfrequency')]")private WebElement feq_toggle;
	@FindBy(xpath = "//button[contains(.,'Complete')]")private WebElement complete;

	@Test
	public void select_simpliReport() throws InterruptedException {
		simpliReportLogoElement.click();
		Thread.sleep(2000);

	}

	@Test
	public void addWithTemplateReport() throws InterruptedException {
		add_report.click();
		Thread.sleep(2000);
		with_template.click();
		Thread.sleep(2000);
	}
	@Test
	public void importDocs() throws InterruptedException {
		import_doc.click();
		Thread.sleep(2000);
		dpdwn.click();
		Thread.sleep(2000);
		//selectTemplate.click();
		//Thread.sleep(2000);
		dl_ver.click();
		Import.click();

	}

	@Test
	public void dragNDrop() throws InterruptedException {
		on_premise_env.click();
		pune_baner.click();
		melting_area.click();
		eng_monitor.click();
		iot_dev_301.click();
		// iot_dev_301para1.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//WebElement elementToClick = driver.findElement(By.cssSelector("button.btn.btn-outline-primary"));
		wait.until(ExpectedConditions.elementToBeClickable(iot_dev_301para1));
		//DRAG AND DROP IOT 302
		Actions actions1 = new Actions(driver);
		Actions actions2 = new Actions(driver);
		// Perform the drag and drop operation
		actions1.dragAndDrop(iot_dev_301para1, field1).build().perform();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(iot_dev_301para2));
		actions2.dragAndDrop(iot_dev_301para2, field2).build().perform();
		save.click();
	}
	@Test
	public void saveLatestReport() throws InterruptedException{
		latest_sbmt.click();
		Thread.sleep(2000);
		WebElement alert= driver.findElement(By.xpath("(//input[contains(@type,'input')])[1]"));
		String alertText = alert.getText();
		if (alertText.equals("Report Name Already Exist..")) {
			System.out.println("Report Name Already Exist..");
			String newReportName = generateUniqueReportName(); //changed file name
			driver.findElement(By.xpath("//input[contains(@type,'input')])[1]")).sendKeys(newReportName);
			complete.click();
		}else {
			complete.click();
		}
		//complete.click();
		//check if report name already exists
		
	//	WebDriverWait wait = new WebDriverWait(driver,  Duration.ofSeconds(10));
		//wait.until(ExpectedConditions.alertIsPresent());
	
		//alert.accept();

	}
	private String generateUniqueReportName() {

		return "report_" + System.currentTimeMillis();
	}

	@Test
	public void saveWithFEQReportVer()throws InterruptedException{
		feq_toggle.click();
		Thread.sleep(2000);
		feq_selectn.click();
		minute.click();
		latest_sbmt.click();
		Thread.sleep(2000);
		complete.click();
	}
	@Test
	public void saveWithFEQReporthz()throws InterruptedException{
		feq_toggle.click();
		Thread.sleep(2000);
		direction.click();
		hz.click();
		feq_selectn.click();
		minute.click();
		latest_sbmt.click();
		Thread.sleep(2000);
		complete.click();
	}


}
