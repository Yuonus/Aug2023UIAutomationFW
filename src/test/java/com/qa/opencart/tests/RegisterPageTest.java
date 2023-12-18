package com.qa.opencart.tests;

import java.util.UUID;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ExcelUtil;

public class RegisterPageTest extends BaseTest{
	
	// Precondition for Registration page: We dont have to login to register, we just need the object reference of the LoginPage
	// to call the navigate method in order to click on "Register" link.
	
	@BeforeClass
	public void regSetUp() {
		registerPage = loginPage.navigateToRegisterPage();
	}
	
	public String getRandomEmailID() {
		// 1st Approach
		return "testAutomation" + System.currentTimeMillis() + "@gmail.com";
		
		// 2nd Approach: Using UUID class
//		return "testAutomation" + UUID.randomUUID() + "@gmail.com";
	}
	
	@DataProvider
	public Object[][] geUserRegData() {
		return new Object [][] {
			{"Zala", "Yuonus", "2027356749", "Zala123$", "yes"},
			{"Abaseen", "Automation", "2027656789", "Zala123$", "no"},
			{"Sarah", "Walker", "20279356789", "Zala123$", "yes"}
		};
	}
	
	@DataProvider
	public Object[][] getUserRegTestExcelData() {
		Object regData[][] = ExcelUtil.getTestData(AppConstants.REGISTER_DATA_SHEET_NAME);
		return regData;
	}
	
	@Test (dataProvider = "geUserRegData")
	public void userRegTest(String firstName, String lastName, String telephone, 
			String password, String subscribe) {
		boolean isRegDone = registerPage.userRegisteration
				(firstName, lastName, getRandomEmailID(), telephone, password, subscribe);
		Assert.assertTrue(isRegDone);
	}
	
	

}
