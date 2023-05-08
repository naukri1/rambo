package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FlightConfirmationPage extends BasePage {
	
	
	By pageName = By.xpath("//font[contains(text(),'Flight Itinerary Page')]");
	By flightConfirm = By.xpath("//font[contains(text(),'Flight Confirmation')]");
	
	By totalPrice = By.cssSelector("#confirm-table > tbody > tr:nth-child(3) > td:nth-child(2) > font");
	By signingout = By.partialLinkText("SIGN-OFF");
	
	
	public FlightConfirmationPage (WebDriver driver) {
		
		super(driver);
	}
	
	
	public int getPrice() {
		
		 int price= Integer.parseInt(driver.findElement(totalPrice).getText().split(" ")[0].replace("$", ""));
         return price;
	}
	
	public void printSomeInformation() {
		
		System.out.println(driver.findElement(pageName).getText());
		System.out.println(driver.findElement(flightConfirm).getText());
		driver.findElement(signingout).click();
	}
	

}
