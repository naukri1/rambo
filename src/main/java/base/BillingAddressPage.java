package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BillingAddressPage extends BasePage {

	private By address = By.cssSelector("input#input_53_addr_line1");
	private By submit = By.cssSelector("input#buyFlights");

	public BillingAddressPage(WebDriver driver) {
		super(driver);
	}

	public void EnterAddressDetails(String details) {

		driver.findElement(address).sendKeys(details);
	}

	public FlightConfirmationPage clickOnContinue() {

		driver.findElement(submit).click();
		return new FlightConfirmationPage(driver);
	}
}
