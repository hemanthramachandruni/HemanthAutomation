package hemanthselenium.Tests;

import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class StandAlone {
	
	@FindBy(xpath="//*[@id='icp-nav-flyout']")
	WebElement hover;
	
	@FindBy(css="#twotabsearchtextbox")
	WebElement searchBox;
	
	@Test
	
	public void AmazonTest() throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		
		// mouse Hover Action Using Selenium
		driver.get("https:www.amazon.com");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Actions actions = new Actions(driver);
		actions.moveToElement(hover).perform();
		
		searchBox.sendKeys("IPhone14");
		((JavascriptExecutor)driver).executeScript("arguments[0].select();" , searchBox);	
		
		// Scroll down using Java Selenium
		JavascriptExecutor js =  (JavascriptExecutor)driver;
		js.executeScript("window.scrollTO(0,500)");
		js.executeScript("Window.scrollBy(0, document.body.scrollHeight)");
		
		//drag and drop action
		WebElement dragElement = driver.findElement(By.cssSelector("hdh"));
		WebElement dropElement = driver.findElement(By.cssSelector("drop"));
		actions.dragAndDrop(dragElement, dropElement);
		
		// double click on WebElement
		actions.doubleClick(dropElement).perform();
		
		//right click
		actions.contextClick(dropElement).perform();
		
		// performing alerts
		Alert alert = driver.switchTo().alert();
		String str = alert.getText();
		alert.accept();
		
		//waits
		//driver.manage().timeouts().implicitlyWait(10  TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(dropElement));
		
		//Key Board Actions
		actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
		actions.moveToElement(dropElement).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
		
		
		//Assertions
		String title = driver.getTitle();
		Assert.assertTrue(title.contains("Example Domain") , "page title contains 'Example Domain'");
		Assert.assertFalse(title.isEmpty(), "Page title is not empty");
		
		//switch between windows
		
	Set<String> handles = driver.getWindowHandles();
	
	String firstTab = (String) handles.toArray()[1];
	String secondTab = (String) handles.toArray()[2];
	String thirdTab = (String) handles.toArray()[3];
	String FourthTab = (String) handles.toArray()[4];
	driver.switchTo().window(firstTab);
	
		
		
		// Exceptions in java and Selenium 
		// JAVA 
		// 1.No such Element found Exception 2.Method/class not found Exception , 3.
		
		
		
		
		
		
		
		
		
		
	}

}
