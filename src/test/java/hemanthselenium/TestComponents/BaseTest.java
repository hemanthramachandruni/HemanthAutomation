package hemanthselenium.TestComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

import hemanselenium.PageObjects.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseTest {
	
	 public WebDriver driver; 
	public LoginPage login;
	
	
	
	
	
	public WebDriver initializedriver() throws IOException {
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\hemanselenium\\resources\\GlobalData.properties");
		prop.load(fis);
		String BrowserName = prop.getProperty("browser");
		
		if(BrowserName.equalsIgnoreCase("chrome")) {
		 driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		}
		/*
		 * else if (BrowserName.equalsIgnoreCase("edge")) {
		 * 
		 * WebDriverManager.edgedriver().setup(); // for the browsers other than chrome
		 * we have give the system.set properties (path of the specified browser here)
		 * driver = new EdgeDriver(); } else if
		 * (BrowserName.equalsIgnoreCase("firefox")) {
		 * 
		 * WebDriverManager.firefoxdriver().setup(); // for the browsers other than
		 * chrome we have give the system.set properties (path of the specified browser
		 * here) driver = new FirefoxDriver(); }
		 */
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
		
	}
	
	@BeforeMethod
	public  LoginPage launchApplication() throws IOException {
		
		 WebDriver driver =initializedriver();
		 login = new LoginPage(driver);
		login.goTo();
		return login;	
	}	
		
	}
