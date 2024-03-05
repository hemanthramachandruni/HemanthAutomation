package hemanselenium.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import hemanselenium.AbstractComponents.AbstractComponent;

public class OrdersPage extends AbstractComponent {

WebDriver driver;

public OrdersPage(WebDriver driver) {
		super(driver);
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}

@FindBy(css="tr td:nth-child(3)")
List<WebElement> orders;

@FindBy(css="tbody tr.ng-star-inserted")
List<WebElement> ordersList;

//driver.findElement(By.cssSelector(".totalRow button")).click();




public Boolean validation(String productName) {
	
	Boolean result = orders.stream().anyMatch(orderName -> orderName.getText().equalsIgnoreCase(productName));

	return result;
	
}




	
	
	
}





	
	


