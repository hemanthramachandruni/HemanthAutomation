package hemanselenium.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hemanselenium.AbstractComponents.AbstractComponent;

public class LoginPage extends AbstractComponent{
	
	WebDriver driver; // (1)
	
	public LoginPage(WebDriver driver) {
		
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	// This java class is not aware of any driver , so we created an local variable(1) , Created a new constructor and
	// Invoked form the another class where we already declared the class.
	
	
// by using the page factory we initializing the objects in this way
	
	// We have totally 4 pages in this application and each page name 
	
	// every class name or test name ends with page is POM for that Web page.
	
	
	
	@FindBy(id="userEmail")
	WebElement user;
	
	@FindBy(id="userPassword")
	WebElement password;
	
	@FindBy(id="login")
	WebElement submit;
	
	public void loginCredentials(String username , String passkey) {
		
		user.sendKeys(username);
		password.sendKeys(passkey);
		submit.click();
		
	}	
		
		public void goTo() {
			
			driver.get("https://rahulshettyacademy.com/client");
		}	
}