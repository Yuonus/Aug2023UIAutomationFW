package com.qa.opencart.constants;

import java.util.Arrays;
import java.util.List;

public class AppConstants {
	
	public static final String LOGIN_PAGE_TITLE = "Account Login";
	public static final String ACCOUNTS_PAGE_TITLE = "My Account";
	
	public static final String LOGIN_PAGE_URL_FRACTION = "route=account/login";
	public static final String ACCOUNT_PAGE_URL_FRACTION = "route=account/account";
	
	/* We can also have some timouts value declared as constants
	 		1: Short Wait
	 		2: Medium Wait
	 		3: Long Wait
	 */
	public static final int SHORT_DEFAULT_WAIT = 5;
	public static final int MEDIUM_DEFAULT_WAIT = 10;
	public static final int LONG_DEFAULT_WAIT = 20;
	public static final int POLLING_DEFAULT_WAIT = 5;
	public static final int ACCOUNT_PAGE_HEADER_COUNT = 4;
	
//	public void test() {
//		  List<String> accountsPageHeadersList = Arrays.asList("My Account", "My Orders", "My Affiliate Account", "Newsletter");
//		}
	
	
	public static final List<String> ACCOUNTS_PAGE_HEADERS_LIST = 
				  Arrays.asList("My Account", "My Orders", "My Affiliate Account", "Newsletter");
	
	public static final String USER_REGISTER_SUCCESS_MESSG = "Your Account Has Been Created!";
	
	public static final String REGISTER_DATA_SHEET_NAME = "register";
	public static final String PRODUCT_DATA_SHEET_NAME = "product";
	public static final String LOGIN_ERROR_MESSAGE = "Warning: No match for E-Mail Address and/or Password.";
	public static final String WRONG_LOGIN_DATA_SHEET_NAME = "login";
	
	
	

}
