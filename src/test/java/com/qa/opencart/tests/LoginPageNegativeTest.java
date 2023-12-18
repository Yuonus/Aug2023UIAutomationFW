package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ExcelUtil;

public class LoginPageNegativeTest extends BaseTest{
	
	@DataProvider
	public Object[][] incorrectLoginTestData() {
		return new Object[][] {
			{"automatione", "Testwew"},
			{"><><>", "Abaseen123$"},
			{"''''''", "[][]-0-0"},
			{"@#$$%&!?", "+_)(*&^"},
			{"07996655??", "  "},
			{"", ""},
		};
	}
	
	
	
	@DataProvider
	public Object[][] getLoginNegativeExcelData() {
		Object[][] wrongCredentials = ExcelUtil.getTestData(AppConstants.WRONG_LOGIN_DATA_SHEET_NAME);
		return wrongCredentials;
	}
	
	
	@Test (dataProvider = "incorrectLoginTestData" )
	public void loginWithWrongCredentialsTest(String userName, String password) {
		Assert.assertTrue(loginPage.doLoginWithWrongCredentials(userName, password));
	}

}
