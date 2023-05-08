package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage extends BasePage {

	
	private By username = By.cssSelector("#email");
	private By pwd = By.cssSelector("[name='password']");
	private By cpwd = By.cssSelector("[name='confirmPassword']");
	private By sbmtButton = By.cssSelector("input#register-btn");
	
	
	public RegistrationPage(WebDriver driver) {
		super(driver);
 
	}
	
	public void goTo() {
		
		driver.get("https://vins-udemy.s3.amazonaws.com/docker/docker-book-flight.html");
	}
	
	public void enterUsername(String name) {
		
		driver.findElement(username).sendKeys(name);
	}
	
	public void enterpwd(String passwd) {
		
		driver.findElement(pwd).sendKeys(passwd);
		driver.findElement(cpwd).sendKeys(passwd);
	}
	
	public RegistrationConfirmationPage submit() {
		
		driver.findElement(sbmtButton).click();
		return new RegistrationConfirmationPage(driver);
		 
	}
	

	public void comboRegister(String name, String passwd) {
		
		driver.findElement(username).sendKeys(name);
		driver.findElement(pwd).sendKeys(passwd);
		driver.findElement(cpwd).sendKeys(passwd);
	    
	}
}
