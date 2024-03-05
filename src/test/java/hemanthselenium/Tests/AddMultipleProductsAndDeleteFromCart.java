package hemanthselenium.Tests;

import org.testng.annotations.Test;

import hemanselenium.PageObjects.CartPage;
import hemanselenium.PageObjects.LoginPage;
import hemanselenium.PageObjects.ProductsPage;
import hemanthselenium.TestComponents.BaseTest;

public class AddMultipleProductsAndDeleteFromCart extends BaseTest{
	
	String productName = "ZARA COAT 3";
	String ProductName2 = "ADIDAS ORIGINAL";
	String ProductName3 = "IPHONE 13 PRO";
	
	
	@Test
	public void AddMoreItems() {
		
		LoginPage login = new LoginPage(driver);
		login.loginCredentials("hemantha@gmail.com", "HaHa0252@");
		
		ProductsPage products = new ProductsPage(driver);
		products.addProductToCart(productName);
		products.addProductToCart(ProductName2);
		products.addProductToCart(ProductName3);
		products.cartbutton();
		
		CartPage cart = new CartPage(driver);
		cart.DeleteItemFromCart(ProductName2);
		driver.quit();
	} 

}


		
		
		
		
		
		
		
		
		
		
		
		

