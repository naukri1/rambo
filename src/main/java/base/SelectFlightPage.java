package base;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SelectFlightPage extends BasePage {
	
	
	private By departureFlight = By.cssSelector("#cid_37 > table:nth-child(2) > tbody");
	private By returnFlight = By.cssSelector("#cid_37 > table:nth-child(4)> tbody");
	private By submit = By.cssSelector("input#reserveFlights");
	
	
	public SelectFlightPage(WebDriver driver) {
		
		super(driver);
	}
	
	
	public void selectDepartureFlight(String brand) {
		
		WebElement table1 = driver.findElement(departureFlight);

        List<WebElement> rows= table1.findElements(By.tagName("tr"));
        System.out.println("Rows "+ rows.size());
        
        for(int i=1; i<=rows.size(); i++) {
        	
        	 String text= driver.findElement(By.cssSelector("#cid_37 > table:nth-child(2) > tbody > tr:nth-child("+i+") > th")).getText();
        	 if(text.equalsIgnoreCase(brand)) {
        		 
        		 driver.findElement(By.cssSelector("#cid_37 > table:nth-child(2) > tbody > tr:nth-child("+i+") > td:nth-child(2)")).click();
        	     break;
        	 }
        	 
        	
        }
        
		
	}
	
	
	public void selectReturnFlight(String brand) {
		
		WebElement table1 = driver.findElement(returnFlight);

        List<WebElement> rows= table1.findElements(By.tagName("tr"));
        
        for(int i=1; i<=rows.size(); i++) {
        	
       	 String text= driver.findElement(By.cssSelector("#cid_37 > table:nth-child(4) > tbody > tr:nth-child("+i+") > th")).getText();
       	 if(text.equalsIgnoreCase(brand)) {
       		 
       		 driver.findElement(By.cssSelector("#cid_37 > table:nth-child(4) > tbody > tr:nth-child("+i+") > td:nth-child(2)")).click();
       	     break;
       	 }
       	 
       	
       }
        
		
	}
	
	public BillingAddressPage submitButton() {
		driver.findElement(submit).click();
		return new BillingAddressPage(driver);
	}

}
