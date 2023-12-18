package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class AccountsPage {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	// By locators: --> Object Repository; locators Repository
	private By logoutLink = By.xpath("//a[text()='Logout' and @class='list-group-item']");
	private By search = By.xpath("//input[@name='search']");
	private By searchIcon = By.cssSelector("div#search button");
	private By accHeaders = By.cssSelector("div#content > h2"); // css div#content h2 or xpath = //h2
	
	// Page Constructor
	public AccountsPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(this.driver);
	}
	
	// Page actions/methods
	
	public String getAccPageTitle() { 
		String title = eleUtil.waitForTitleIs(AppConstants.ACCOUNTS_PAGE_TITLE, AppConstants.MEDIUM_DEFAULT_WAIT);
		System.out.println("Account page title is: " + title);
		return title;
	}
	
	public String getAccPageURL() {	
		String url = eleUtil.waitForURLContains(AppConstants.ACCOUNT_PAGE_URL_FRACTION, AppConstants.SHORT_DEFAULT_WAIT);
		System.out.println("Account page url is: " + url);
		return url;
	}
	
	public boolean isLogoutLinkExist() {
		return eleUtil.waitForVisibilityOfElement(logoutLink, AppConstants.SHORT_DEFAULT_WAIT).isDisplayed();
	}
	
	public void logout() {
		if(isLogoutLinkExist()) {
			eleUtil.doClick(logoutLink);
		}
	}
	
	public boolean isSearchFieldExist() {
		return eleUtil.waitForVisibilityOfElement(search, AppConstants.SHORT_DEFAULT_WAIT).isDisplayed();
	}
	
	public List<String> getAccountHeaders() {
		List<WebElement> headersList = eleUtil.waitForVisibilityOfElements(accHeaders, AppConstants.MEDIUM_DEFAULT_WAIT);
		List<String> headersValue = new ArrayList<String>();
		for(WebElement e : headersList) {
			String text = e.getText();
			headersValue.add(text);
		}
		return headersValue;
	}
	
	
	public SearchResultsPage doSearch(String searchKey) {
		eleUtil.waitForVisibilityOfElement(search, AppConstants.MEDIUM_DEFAULT_WAIT).clear();
		eleUtil.waitForVisibilityOfElement(search, AppConstants.MEDIUM_DEFAULT_WAIT).sendKeys(searchKey);
		eleUtil.doClick(searchIcon);
		return new SearchResultsPage(driver); // TDD
	}
	

}
