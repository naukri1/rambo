package testcases;

import org.junit.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.BillingAddressPage;
import base.FlightConfirmationPage;
import base.FlightsDetailPage;
import base.RegistrationConfirmationPage;
import base.RegistrationPage;
import base.SelectFlightPage;

public class BookFlightTest extends BaseTest{
	
	
	
	private String noOfPassengers ;
	private int expectedPrice;
	
	@BeforeTest
	@Parameters({"noOfPassengers", "expectedPrice"})
	public void setUpParameters(String noOfPassengers, int expectedPrice) {
		this.noOfPassengers =noOfPassengers;
		this.expectedPrice = expectedPrice;
		
		
	}
	
	@Test
	public void registrationPageTest() {
		
		RegistrationPage rp = new RegistrationPage(driver);
		rp.goTo();
		rp.comboRegister("test1", "test1");
		rp.submit();
	}
	

	@Test(dependsOnMethods="registrationPageTest")
	public void registrationConfirmationPageTest() {
		
		RegistrationConfirmationPage rcp = new RegistrationConfirmationPage(driver);
		rcp.clickonFlightlink();
	}
	
	@Test(dependsOnMethods="registrationConfirmationPageTest")
	public void flightsDetailPageTest() {
		
		FlightsDetailPage fdp = new FlightsDetailPage(driver);
		fdp.passPassengerCount(noOfPassengers);
		fdp.clickonSubmit();
	    
	}
	
	@Test(dependsOnMethods="flightsDetailPageTest")
	public void selectFlightPageTest() {
		
		SelectFlightPage sfp = new SelectFlightPage(driver);
		sfp.selectDepartureFlight("Qatar");
		sfp.selectReturnFlight("Qatar");
		sfp.submitButton();
	    
	}
	
	@Test(dependsOnMethods="selectFlightPageTest")
	public void billingAddressPageTest() {
		
		BillingAddressPage bap = new BillingAddressPage(driver);
		bap.EnterAddressDetails("Soome address");
		bap.clickOnContinue();
	    
	}
	
	@Test(dependsOnMethods="billingAddressPageTest")
	public void flightConfirmationPageTest() {
		
		FlightConfirmationPage fcp = new FlightConfirmationPage(driver);
		System.out.println(fcp.getPrice());
		Assert.assertEquals(expectedPrice, fcp.getPrice());
		fcp.printSomeInformation();
	    
	}
	
	

}