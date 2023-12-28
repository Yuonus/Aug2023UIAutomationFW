package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.listeners.TestAllureListener;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("Epic 100: Design open cart login page")
@Story("US 101: Login Page features")
@Feature("F50: Feature Login page")
@Listeners(TestAllureListener.class) // if you manually write this allure annotation, with some windows system it will get "Cannot be resolved to a type". 
// So, to prevent this error you will need to delete .class and some parts of listener and then press CTRL + SPACE and manually write .class
public class LoginPageTest extends BaseTest{

	@Description("This is login page title test")
	@Severity(SeverityLevel.MINOR)
	@Test (priority = 1)
	public void loginPageTitleTest() {
		String actTitle = loginPage.getLoginPageTitle();
		Assert.assertEquals(actTitle, AppConstants.LOGIN_PAGE_TITLE);
		System.out.println("Title is correct.");
	}
	
	@Description("This is login page URL test")
	@Severity (SeverityLevel.CRITICAL)
	@Test (priority = 2)
	public void loginPageURLTest() {
		String actURL = loginPage.getLoginPageURL();
		Assert.assertTrue(actURL.contains(AppConstants.LOGIN_PAGE_URL_FRACTION));
	}
	
	@Description("Verifying forgot password link test")
	@Severity(SeverityLevel.CRITICAL)
	@Test (priority = 3)
	public void forgotPwdLinkExist() {
//		loginPage.isForgotPwdLinkExist(); // Since this method returns a boolean we can directly verify it.
		Assert.assertTrue(loginPage.isForgotPwdLinkExist());
	}
	
	@Description("Verifying App logo existence")
	@Severity(SeverityLevel.MINOR)
	@Test (priority = 4)
	public void appLogoExist() {
		Assert.assertTrue(loginPage.isLogoExist());
	}
	
	@Description("User is able to login with valid credenetials")
	@Severity(SeverityLevel.CRITICAL)
	@Test (priority = 5)
	public void loginTest() {
		accPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertTrue(accPage.isLogoutLinkExist());
	}
	
	
	
	
}
