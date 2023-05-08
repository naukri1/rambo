package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationConfirmationPage extends BasePage{
	
	
	
	private By flightslink = By.cssSelector("a#flight-link");

	public RegistrationConfirmationPage(WebDriver driver) {
		super(driver);
 
	}
	
	
	public FlightsDetailPage clickonFlightlink() {
		
		driver.findElement(flightslink).click();
		return new FlightsDetailPage(driver);
	}

}
