package base;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchModulePage extends BasePage {
	
	
	private By searchBox = By.name("q");
	//private By searchIcon= By.cssSelector("#searchbox_homepage > div.searchbox_searchbox__eaWKL > div > button.searchbox_searchButton__F5Bwq.iconButton_button__6x_9C");
	private By linkies = By.cssSelector("#duckbar_static > li:nth-child(3) > a");
	private By  listVideos= By.cssSelector(".tile--vid");
    
	
	public SearchModulePage(WebDriver driver) {
		
		super(driver);
	}
	
	public void goTo() {
		
		driver.get("https://duckduckgo.com/");
		wait.until(ExpectedConditions.titleIs("DuckDuckGo — Privacy, simplified."));
		
	}
	
	
	public void enterTextandSearch(String value)  {
		try{
						
			Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox));
			wait.until(ExpectedConditions.elementToBeClickable(searchBox));
			driver.findElement(searchBox).sendKeys(value);
			//driver.findElement(searchIcon).click();
			driver.findElement(searchBox).sendKeys(Keys.ENTER);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		

	}
	
	public void navigateToVideoLink() {
		try {
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(linkies));
			driver.findElement(linkies).click();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public int getCountOfVideos() {
	
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(listVideos,0));
		List<WebElement> count = driver.findElements(listVideos);
		
		return count.size();
	}
	
	
	
}
