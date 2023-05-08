package testcases;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
	
	protected WebDriver driver;
	
	@BeforeTest
	public void setUp() throws MalformedURLException {
		
		String host ="localhost";
		Capabilities mc ;
		
		if(System.getProperty("BROWSER") !=null && System.getProperty("BROWSER").equalsIgnoreCase("firefox")) {
			
			mc = new FirefoxOptions();
		}
		else { 
			
			List<String> options = new ArrayList<>();
			options.add("--disable-extensions");
			options.add("--headless");
			options.add("--incognito");
			options.add("--disable-dev-shm-usage");
			options.add("--disable-application-cache");
			options.add("--disable-gpu");
			options.add("--no-sandbox");
			options.add("--disable-gpu");
			mc = new ChromeOptions().addArguments(options);
		}	
		
		if(System.getProperty("HUB_HOST")!=null ) {
			
			host =System.getProperty("HUB_HOST"); 
			
		}
		
		String completedUrl = "http://" + host + ":4444/wd/hub";
		this.driver = new RemoteWebDriver(new URL(completedUrl),mc);
		
				
				
	}
	
	@AfterTest
	public void quit() {
		driver.quit();
	}
}
