package hemanthselenium.Tests;

import org.testng.annotations.Test;

import hemanselenium.PageObjects.HomePage;
import hemanthselenium.TestComponents.BaseTest;

public class SamplePlayTest extends BaseTest {
	
	
	
	@Test

	public void SampleTest() {
		
		login.loginCredentials("hemantha@gmail.com", "HaHa0252@");
		
		
		
		HomePage home = new HomePage(driver);
		
		home.SearchBox("ZARA COAT 3");
		driver.quit();
	
		
	}
}
