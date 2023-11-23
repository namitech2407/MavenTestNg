package PageObjectClasses;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class parameterSelection {
	 WebDriver driver;
	 

	public parameterSelection(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
			
	}
	
	//webElemets
	@FindBy(xpath = "//span[@class='ui-tree-toggler fa fa-fw fa-caret-right']")
    private WebElement on_premise_env;
	@FindBy(xpath = "(//span[@class='ui-tree-toggler fa fa-fw fa-caret-right'])[3]")
    private WebElement pune_baner ;
	@FindBy(xpath = "(//span[@class='ui-tree-toggler fa fa-fw fa-caret-right'])[3]")
    private WebElement melting_area;
	@FindBy(xpath = "(//span[@class='ui-tree-toggler fa fa-fw fa-caret-right'])[3]")
    private WebElement EngMonitor;
	@FindBy(xpath ="//*[@id=\"uitree\"]/div/ul/p-treenode/li[2]/ul/p-treenode/li[2]/ul/p-treenode/li[2]/ul/p-treenode[3]/li[2]/ul/p-treenode[1]/li[2]/ul/p-treenode/li[2]/ul/p-treenode[1]/li[2]/div/span[3]/span/span" )
    private WebElement IOT_DEV_301;
	
	//@FindBy(tagName = "a")
	//List<WebElement>linksElements;
   
	//ACTIONS
  @Test
  public void parameterSelection() throws InterruptedException {
	  on_premise_env.click();
	  Thread.sleep(3000);
	  pune_baner.click();
	  Thread.sleep(3000);
	  melting_area.click();
	  Thread.sleep(3000);
	  EngMonitor.click();
	  Thread.sleep(3000);
	  IOT_DEV_301.click();
	  
  }

}

