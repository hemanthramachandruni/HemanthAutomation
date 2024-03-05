package hemanselenium.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import hemanselenium.AbstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent {

WebDriver driver;

public CartPage(WebDriver driver) {
		super(driver);
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}

@FindBy(css=".cartSection h3")
List<WebElement> cart;

//driver.findElement(By.cssSelector(".totalRow button")).click();

@FindBy(css=".totalRow button")
WebElement continueButton;

@FindBy(css="li.ng-star-inserted")
List<WebElement> cartList;


public Boolean validation(String productName) {
	
	Boolean result = cart.stream().anyMatch(cartproduct -> cartproduct.getText().equalsIgnoreCase(productName));

	return result;
	
}

public void checkout() {
	
	continueButton.click();
	
	
	
}

public WebElement GetItemsToDelete(String ItemToDelete) {
	
	WebElement item = cartList.stream().filter(product ->  product.findElement(By.cssSelector("h3")).getText().equalsIgnoreCase
			(ItemToDelete)).findFirst().orElse(null);
	
	return item;
	
}

public  void DeleteItemFromCart(String ItemToDelete) {
	
	WebElement item = GetItemsToDelete(ItemToDelete);
	item.findElement(By.cssSelector("i.fa-trash-o")).click();
	
}

}





	
	


