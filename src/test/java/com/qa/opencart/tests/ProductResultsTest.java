package com.qa.opencart.tests;

import java.util.Map;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ExcelUtil;

public class ProductResultsTest extends BaseTest {
	
	@BeforeClass
	public void productInfoSetUp() {
		accPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	//: The Precondition for this class are: You have to login first 2: you will have to search for a product (Accounts Page)
	// 3: You will have click on selected product
	
	@DataProvider
	public Object[][] getSearchData() {
		return new Object [][] {
			{"MacBook", "MacBook Pro", 4},
			{"MacBook", "MacBook Air", 4},
			{"iMac", "iMac", 3},
			{"Samsung", "Samsung SyncMaster 941BW", 1}
		};
	}
	
	@DataProvider
	public Object[][] getSearchExcelData() {
		Object[][] productItems = ExcelUtil.getTestData(AppConstants.PRODUCT_DATA_SHEET_NAME);
		return productItems;
		// or you can directly return. no need to create an extra variable 
//		return ExcelUtil.getTestData(AppConstants.PRODUCT_DATASHEET_NAME);
	}
	
	
	@Test (dataProvider = "getSearchExcelData")
	public void productImageTest(String searchKey, String productName, String imageCount) {
		searchResultsPage = accPage.doSearch(searchKey);
		productInfoPage = searchResultsPage.selectProduct(productName);
		int actProuctImages = productInfoPage.getProductImagesCount(); // TDD 
		Assert.assertEquals(String.valueOf(actProuctImages), imageCount); // if we dont convert the int into string we will be
		// getting MethodMatcherException
		
		// Or we can directly assert it without storing it into a variable Assert.assertEquals(productInfoPage.getProductImagesCount(), 4);	
//		and do the int to String conversion
//		Assert.assertEquals(String.valueOf(productInfoPage.getProductImagesCount()), imageCount); // TDD

	}
	
	@Test
	public void productInfoTest() {
		searchResultsPage = accPage.doSearch("MacBook");
		productInfoPage = searchResultsPage.selectProduct("MacBook Pro");
		Map<String, String> productDetailsMap = productInfoPage.getProductDetails();
		
		// Verification part: Remember that we cannot verify the complete HashMap, we will verify it partly
//		Assert.assertEquals(productDetailsMap.get("Brand"), "Applpe");
//		Assert.assertEquals(productDetailsMap.get("Availability"), "In Stock");
//		Assert.assertEquals(productDetailsMap.get("Product Code"), "Product 18");
//		Assert.assertEquals(productDetailsMap.get("Reward Points"), "800");
//		
//		Assert.assertEquals(productDetailsMap.get("Price"), "$2,000.00");
//		Assert.assertEquals(productDetailsMap.get("ExTaxPrice"), "$2,000.00");
		
		softAssert.assertEquals(productDetailsMap.get("Brand"), "Apple");
		softAssert.assertEquals(productDetailsMap.get("Availability"), "In Stock");
		softAssert.assertEquals(productDetailsMap.get("Product Code"), "Product 18");
		softAssert.assertEquals(productDetailsMap.get("Reward Points"), "800");
		
		softAssert.assertEquals(productDetailsMap.get("Price"), "$2,000.00");
		softAssert.assertEquals(productDetailsMap.get("ExTaxPrice"), "$2,000.00");
		
		softAssert.assertAll(); // assertAll() method is mandatory, and it will tell that out of 6 assertions, how many
//		will get fail
	}

	/*
	 	In case of having multiple hard assertions in one Test method, if one assertion fails, the test will stop right at the
	 	assertion which has failed. So, in order to ignore and move to next assertions we will have to use Soft assertions 
	 	concept.
	 	
	 */
	


}
