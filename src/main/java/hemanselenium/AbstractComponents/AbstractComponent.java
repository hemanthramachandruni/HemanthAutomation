package hemanselenium.AbstractComponents;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponent {
	
	WebDriver driver;
	
	public AbstractComponent(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(css="[routerlink*='cart']")
	WebElement cartButton;
	
	@FindBy(css="[routerlink*='myorders']")
	WebElement ordersButton;
	

	public void waitForElementTOAppear(By findBy) {

	WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));

}
	
	public WebElement waitForElementToDisappear(WebElement ele) {
		
		WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(ele));
		return ele;
	}

	public void action(String element) {
		
		Actions actions = new Actions(driver);
		
		actions.sendKeys(element).build().perform();
		
	}
	
	public void goToCartPage() {
		
		cartButton.click();
		
	}
	
	public void goToOrdersPage() {
		
		ordersButton.click();
		
	}
	
public void EnterButton(String element) {
		
		Actions actions = new Actions(driver);
		
		actions.keyDown(Keys.ENTER);
		
	}
	
	
		
		
	}
	
	
	
	
	
	
	
	
	
