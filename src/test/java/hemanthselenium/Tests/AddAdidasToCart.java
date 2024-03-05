package hemanthselenium.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import hemanselenium.PageObjects.CartPage;
import hemanselenium.PageObjects.ConfirmationPage;
import hemanselenium.PageObjects.PaymentPage;
import hemanselenium.PageObjects.ProductsPage;
import hemanthselenium.TestComponents.BaseTest;

public class AddAdidasToCart extends BaseTest{
	
	
	String itemName="ADIDAS ORIGINAL";
	String countryName ="India";
	
	@Test
	public void AddItemsToCart() {
		
		login.loginCredentials("hemantha@gmail.com", "HaHa0252@");
		
		ProductsPage products = new ProductsPage(driver);
		products.addProductToCart(itemName);
		products.goToCartPage();
		
		CartPage cart = new CartPage(driver);
		Boolean result = cart.validation(itemName);
		Assert.assertTrue(result);
		cart.checkout();
		
		PaymentPage payment = new PaymentPage(driver);
		payment.Paymentprocess(countryName);
		payment.submit();
		
		ConfirmationPage confirm = new ConfirmationPage(driver);
		confirm.Confirmation();	
	}
	}