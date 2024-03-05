package hemanthselenium.Tests;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import hemanselenium.PageObjects.LoginPage;
import hemanthselenium.TestComponents.BaseTest;

public class LoginValidation extends BaseTest{
	
	@Test
	public void Logincheck() {
		
 
 
 login.loginCredentials("hemantha@gmail.com", "HaHa0252@");
		
	String Expected = driver.getTitle();
		
	Assert.assertEquals(Expected, "Let's Shop");
		
	
		
	}

}
