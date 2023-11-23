package MavenTestNg;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.opentelemetry.semconv.resource.attributes.ResourceAttributes.TelemetrySdkLanguageValues;

public class TelemetryPage  {
	
	WebDriver driver;
	NewTest nTest;
	/*
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
    @FindBy(xpath = "//*[@id=\"footer\"]/button")
    private WebElement okayBtn;
    @FindBy(xpath = "//*[@id=\"dynamic-columns\"]/app-device-list/div[2]/div[3]/div[1]/div[6]/button")
    private WebElement submitBtn; */

    // Constructor or init method to initialize elements

	@BeforeClass
	public void beforeClass() throws InterruptedException{
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	driver.get("http://172.16.1.231:8082/simpliworks/#/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));

	}
   @Test(priority = 5)
    public void historicalDataTest() {
	   
	 //  NewTest newTest = new NewTest(driver);
	   
	nTest = new NewTest(driver);
	nTest.HistoricalData();
	
    }
}
