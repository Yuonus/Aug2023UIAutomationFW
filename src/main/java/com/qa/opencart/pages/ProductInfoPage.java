package com.qa.opencart.pages;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class ProductInfoPage {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	// By locators: --> Object Repository; locators Repository
	
//	private By productHeader = By.xpath("//h1[text()='MacBook Pro']");	
	private By productHeader = By.cssSelector("div#content h1");
	private By productImages = By.cssSelector("ul.thumbnails img");
	private By productMetaData = By.xpath("(//div[@id='content']//ul[@class='list-unstyled'])[1]/li");
	private By productPriceData = By.xpath("(//div[@id='content']//ul[@class='list-unstyled'])[2]/li");
	
//	private Map<String, String> productMap = new HashMap<String, String>(); // Map does not maintain the order, while printing the products
//	private Map<String, String> productMap = new LinkedHashMap<String, String>();// LinkedHashMap maintain the product metadata order same as the UI
	private Map<String, String> productMap = new TreeMap<String, String>(); // TreeMap maintain the alphabetical order for Keys only
	
	
	// Page Constructor
	public ProductInfoPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(this.driver);
	}
	
	// Page actions/methods
	
	public String getProductHeaderName() {
		String productHeaderVal = eleUtil.doElementGetText(productHeader);
		System.out.println("Prdouct header is: " + productHeaderVal);
		return productHeaderVal;
	}

	public int getProductImagesCount() {
		// TODO Auto-generated method stub.  --> You have studied this STUB approach in manual testing. (To students)
		int imagesCount =  eleUtil.waitForVisibilityOfElements(productImages, AppConstants.MEDIUM_DEFAULT_WAIT).size();
		System.out.println("Product " + getProductHeaderName() + " images count : " + imagesCount);
		return imagesCount;	
	}
	
	private void getProductMetaData() {
		List<WebElement> metaDataList = eleUtil.waitForVisibilityOfElements(productMetaData, AppConstants.MEDIUM_DEFAULT_WAIT);
		
		for(WebElement e : metaDataList) {
			String metaData = e.getText(); // Brand: Apple
			String metaKey = metaData.split(":")[0].trim();
			String metaVal = metaData.split(":")[1].trim();
			
			// Let's start filling the HashMap
			productMap.put(metaKey, metaVal);
		}
	}
	
	private void getProductPriceData() {
		List<WebElement> metaPriceList = eleUtil.waitForVisibilityOfElements(productPriceData, AppConstants.MEDIUM_DEFAULT_WAIT);
		String prouctPrice = metaPriceList.get(0).getText();
		String prouctExTaxPrice = metaPriceList.get(1).getText().split(":")[1].trim();
		
		// We dont have a key for product price, so we have given our own custom key here.
		productMap.put("Price", prouctPrice);
		productMap.put("ExTaxPrice", prouctExTaxPrice);
	} 
	
	// To get the product complete Details we will create this given method
	
	public Map<String, String> getProductDetails() {
		// Before returning the product complete metadata and price data I want to return the product name
		productMap.put("Productname", getProductHeaderName());
		getProductMetaData();
		getProductPriceData();
		System.out.println(productMap);
		return productMap;
	}

	
}
