package hemanthselenium.Tests;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import hemanselenium.PageObjects.ProductsPage;
import hemanthselenium.TestComponents.BaseTest;
import hemanselenium.PageObjects.CartPage;
import hemanselenium.PageObjects.ConfirmationPage;
import hemanselenium.PageObjects.LoginPage;
import hemanselenium.PageObjects.OrdersPage;
import hemanselenium.PageObjects.PaymentPage;

import io.github.bonigarcia.wdm.WebDriverManager;



public class PlaceOrder extends BaseTest{
	
	
	String productName = "ZARA COAT 3";
	String countryName = "India";
	@Test
	public void submitOrder() throws IOException , InterruptedException {

		
		login.loginCredentials("hemantha@gmail.com", "HaHa0252@");
		
	
		ProductsPage products = new ProductsPage(driver);
		products.addProductToCart(productName);
		products.goToCartPage();

		CartPage cartPage = new hemanselenium.PageObjects.CartPage(driver);
		Boolean result = cartPage.validation(productName);
		Assert.assertTrue(result);
		cartPage.checkout();

		PaymentPage payment = new PaymentPage(driver);
		payment.Paymentprocess(countryName);
		payment.submit();
		
		ConfirmationPage confirmationpage = new ConfirmationPage(driver);
		String cMessage = confirmationpage.Confirmation();
		String message = "THANKYOU FOR THE ORDER.";
		Assert.assertEquals(cMessage, message );
		
		  System.out.println(cMessage);
		Assert.assertTrue(true);
		
		driver.quit();
		
	}
	
	@Test(dependsOnMethods="submitOrder")
	public void OrderValidation() {
		
		login.loginCredentials("hemantha@gmail.com", "HaHa0252@");
		
		OrdersPage orderName = new OrdersPage(driver);
		orderName.goToOrdersPage();
		Assert.assertTrue(orderName.validation(productName));
		driver.quit();
		
	}	
	}
		
		
	
	

