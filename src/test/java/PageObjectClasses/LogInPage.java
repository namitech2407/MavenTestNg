package PageObjectClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class LogInPage {
	public WebDriver driver;
	
	
	//constructor
	public LogInPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
			
	}
	
	//WebElements
	@FindBy(xpath = "//input[@formcontrolname='UserLogin']") private WebElement emailbtn;
	@FindBy(xpath = "//input[contains(@formcontrolname,'UserPasswd')]")private  WebElement passwordbtn;
	@FindBy(xpath = "//button[@type='submit']") private  WebElement logInbtn;
	@FindBy(xpath = "//img[@alt='Company_Logo']") private WebElement logo;
	@FindBy(xpath = "//input[@name='email']") private WebElement username1;
	@FindBy(xpath = "//input[contains(@name,'password')]")private WebElement password1;
	@FindBy(xpath = "//button[@name='go']")private WebElement go1;
	
	//Action Methods
	
	
  @Test
  public void setUsername(String username) {
	  emailbtn.sendKeys(username);
  }
  
  public void setPassword(String Password) {
	  passwordbtn.sendKeys(Password);
  }
  
  public void ClickSubmit() {
	  logInbtn.click();
  }
  
  //methods below are for log in to other modules
  public void setUsername1(String username) {
	  username1.sendKeys(username);
  }
  
  public void setPassword1(String Password) {
	  password1.sendKeys(Password);
  }
  
  public void ClickSubmit1() {
	  go1.click();
  }
  

  
  //public boolean CheckLogoPresence() {
	//  boolean status = logo.isDisplayed();
	  //return status;
  //}
  
}
