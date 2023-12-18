package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class SearchResultsPage {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	// By locators: --> Object Repository; locators Repository
	
//	private By productName = By.linkText("MacBook Pro");
/*	Whenever the By locators are dynamic do not store them in the class level, you can store them in PageClasses 
	methods/functions because they are subject to change as they are not static. Think of the By locator for a product we 
	have used in SearchResultsPage, the product "MacBook Pro" could be change any minute or second.
	We only store the static/fixed By locators in class level like: searchIcon, search, logoutLink … etc. These By locators 
	will not change as they are static.
*/

	
	// Page Constructor
	public SearchResultsPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(this.driver);
	}
	
	// Page actions/methods
	
	public ProductInfoPage selectProduct(String productName) {
		By productNameLocator = By.linkText(productName);
		eleUtil.waitForVisibilityOfElement(productNameLocator, AppConstants.MEDIUM_DEFAULT_WAIT).click();
		return new ProductInfoPage(driver);
	}

	

}
