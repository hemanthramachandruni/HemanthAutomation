package hemanselenium.PageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hemanselenium.AbstractComponents.AbstractComponent;

public class HomePage extends AbstractComponent{
	
	WebDriver driver; // (1)
	
	public HomePage(WebDriver driver) {
		
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	// This java class is not aware of any driver , so we created an local variable(1) , Created a new constructor and
	// Invoked form the another class where we already declared the class.
	
	
// by using the page factory we initializing the objects in this way
	
	// We have totally 4 or more pages in this application and each page name 
	
	// every class name or test name ends with page is POM for that Web page.
	
	
	
	@FindBy(xpath="//*[@id='sidebar']/form/div[1]/input")
	WebElement searchBox;
	
	
	
	public void SearchBox(String searchText) {

		searchBox.sendKeys(searchText);
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.ENTER).perform();	
	((JavascriptExecutor)driver).executeScript("arguments[0].select();" , searchBox);
	actions.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();
	
		
	}
		
		
	
	
	
	
}