package com.supplyhouse.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.supplyhouse.qa.base.TestBase;
import com.supplyhouse.qa.pages.BoilerPartsFinderPage;
import com.supplyhouse.qa.util.TestUtil;

public class BoilerPartsFinderPageTest extends TestBase{
	
	BoilerPartsFinderPage boilerPartsFinder;
	TestUtil testUtil;
	
	String sheetName = "modelnumbers";
	
	public BoilerPartsFinderPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		
		TestBase.initialization();
		testUtil = new TestUtil();
		boilerPartsFinder = new BoilerPartsFinderPage();
		
	}
		
	@DataProvider
	public Object[][] boilerPartsFinderTestData(){
		Object data[][] = TestUtil.getTestData("modelnumbers");
		return data;
	}
	
	@Test(dataProvider="boilerPartsFinderTestData")
	public void searchBoilerModelNumber(String modelNumber) throws IOException, InterruptedException{
		boilerPartsFinder.searchModelNumber(modelNumber);	
		String searchResult = boilerPartsFinder.verifySearchModel();
		Assert.assertEquals(searchResult.replace("\"", ""), modelNumber);
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
