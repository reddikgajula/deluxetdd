package com.supplyhouse.qa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.supplyhouse.qa.base.TestBase;

public class BoilerPartsFinderPage extends TestBase{

	@FindBy(id = "model-number")
	WebElement modelNumber;
		
	@FindBy(xpath = "//button[@type='submit' and @class = 'search-btn btn button-blue upper col-sm-1 col-md-4']")
	WebElement search;
	
	@FindBy(xpath = "//*[@id=\"search-result-message\"]/p/span")
	WebElement searchitem;
	
	
	public BoilerPartsFinderPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void searchModelNumber(String mNumber){
		
		modelNumber.sendKeys(mNumber);	
		search.sendKeys(Keys.SPACE);
		
	}
	
	public String verifySearchModel(){
		WebDriverWait wait = new WebDriverWait(driver, 5);	
		wait.until(ExpectedConditions.visibilityOf(searchitem));
		return searchitem.getText();
	}

}
