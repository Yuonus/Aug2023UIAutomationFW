package com.qa.opencart.tests;

import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;

public class AccountsPageTest extends BaseTest{
	
	@BeforeClass
	public void accSetUp() {
		accPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test
	public void accPageTitleTest() {
		Assert.assertEquals(accPage.getAccPageTitle(), AppConstants.ACCOUNTS_PAGE_TITLE);
	}
	
	@Test
	public void accPageURLTest() {
		Assert.assertTrue(accPage.getAccPageURL().contains(AppConstants.ACCOUNT_PAGE_URL_FRACTION));
	}
	
	@Test
	public void isLogoutLinkExistTest() {
		Assert.assertTrue(accPage.isLogoutLinkExist());
	}
	
	@Test
	public void isSearchFieldExistTest() {
		Assert.assertTrue(accPage.isSearchFieldExist());
	}
	
	@Test
	public void accPageHeadersCountTest() {
		List<String> actAccPageHeadersCountList = accPage.getAccountHeaders();
		System.out.println(actAccPageHeadersCountList);
		Assert.assertEquals(actAccPageHeadersCountList.size(), AppConstants.ACCOUNT_PAGE_HEADER_COUNT);
	}
	
	@Test
	public void accPageHeadersTest() {
		List<String> actAccPageHeadersCountList = accPage.getAccountHeaders();
		System.out.println(actAccPageHeadersCountList);
		Assert.assertEquals(actAccPageHeadersCountList, AppConstants.ACCOUNTS_PAGE_HEADERS_LIST);
	}
	
	@Test
	public void searchTest() {
		searchResultsPage = accPage.doSearch("MacBook");
		productInfoPage = searchResultsPage.selectProduct("MacBook Pro");
		String actProductHeader = productInfoPage.getProductHeaderName();
		Assert.assertEquals(actProductHeader, "MacBook Pro");
	}
	

}
