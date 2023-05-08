package testcases;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.SearchModulePage;

public class SearchModuleTest extends BaseTest{
	
	
	
	@Test
	@Parameters({"keyword"})
	public void searchFunctionalTest(String keyword) {
		SearchModulePage smp = new SearchModulePage(driver);
		smp.goTo();
		smp.enterTextandSearch(keyword);
		smp.navigateToVideoLink();
		System.out.println(smp.getCountOfVideos());
		Assert.assertTrue(smp.getCountOfVideos()> 0);
	
	}
	
	

}
