package base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class FlightsDetailPage extends BasePage{

	
	private By passengerCount = By.cssSelector("select#passCount");
	private By submit = By.cssSelector("input#findFlights");
	
	
	
	public FlightsDetailPage(WebDriver driver) {
		super(driver);
	}
	
	
	public void passPassengerCount(String passenCount) {
		
		
		JavascriptExecutor js = (JavascriptExecutor ) driver;
		js.executeScript("window.scrollBy(0,-350)", driver.findElement(passengerCount));
		wait.until(ExpectedConditions.visibilityOfElementLocated(passengerCount));
		wait.until(ExpectedConditions.elementToBeClickable(passengerCount));
		
				
				
		Select select = new Select(driver.findElement(passengerCount));
		select.selectByValue(passenCount);
		
	}
	
	public SelectFlightPage clickonSubmit() {
		
		driver.findElement(submit).click();
		return new SelectFlightPage(driver);
	}
}
