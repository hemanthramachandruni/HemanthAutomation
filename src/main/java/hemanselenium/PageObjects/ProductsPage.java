package hemanselenium.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hemanselenium.AbstractComponents.AbstractComponent;

public class ProductsPage extends AbstractComponent{
	
	WebDriver driver; // (1)
	
	public ProductsPage (WebDriver driver) {
		
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	By product = By.cssSelector(".mb-3");
	
	By toastMessage = By.cssSelector("#toast-container");
	
	//driver.findElement(By.cssSelector("")).click();
	
	@FindBy(css="[routerlink*='cart']")
	WebElement cartButton;
	
	@FindBy(css=".ng-animating")
	WebElement invisible;

	By addToCart = By.cssSelector(".card-body button:last-of-type");
	
	
	public List<WebElement> getProductsList() {
		
		waitForElementTOAppear(product);
		return products;
	}
		
		
		public WebElement getProductByName(String productName) {
			
			WebElement prod = getProductsList().stream().filter(products ->
			  products.findElement(By.cssSelector("b")).getText().equals(productName)).
			  findFirst().orElse(null);
			return prod;
			
		}
		
		public  void addProductToCart(String productName) {
			
			WebElement prod = getProductByName(productName);
			prod.findElement(addToCart).click();
			waitForElementTOAppear(toastMessage);
			waitForElementToDisappear(invisible);
			
			
			
		}
		
		public void cartbutton() {
			
			goToCartPage();
		}
	}	



	
	
	
