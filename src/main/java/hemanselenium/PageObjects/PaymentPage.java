package hemanselenium.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import hemanselenium.AbstractComponents.AbstractComponent;

public class PaymentPage extends AbstractComponent{
	
	WebDriver driver;

	public PaymentPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	
	@FindBy(css="[placeholder='Select Country']")
	WebElement country;
	
	@FindBy(xpath="(//button[contains(@class,'ta-item')])[2]")
	WebElement selectCountry;
	
	@FindBy(css=".action__submit")
	WebElement submit;
	
	By Element = By.cssSelector(".list-group");
	
	
	
	
	public void Paymentprocess(String countryName) {
		
		Actions action = new Actions(driver);
		  
		  
		  action.sendKeys(country, countryName).build().perform();
		  
		  waitForElementTOAppear(Element);
			 
		  selectCountry.click();
		  
		 
		
	
	}
	
	public void submit() {
		
		submit.click();
		
	}

}
