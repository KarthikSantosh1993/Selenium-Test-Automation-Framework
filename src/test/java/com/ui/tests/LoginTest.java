package com.ui.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pojo.User;

@Listeners(com.ui.listeners.TestListener.class)
public class LoginTest extends BaseTest{
	
	
//
//	@Test(description = "Verifying login functionality of application with valid user using data from JSON File", groups = {
//			"e2e",
//			"sanity" }, dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "LoginDataProvider",retryAnalyzer = com.ui.listeners.MyRetryAnalyzer.class)
//	public void loginTest(User user) {
//		assertEquals(homePage.goToLogInPage().doLogin(user.getEmailAddress(), user.getPassword()).getUserName(),
//				"Karthik D");
//	}
//
//	@Test(description = "Verifying login functionality of application with valid user using data from CSV File", groups = {
//			"e2e",
//			"sanity" }, dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "loginTestCSVDataProvider")
//	public void loginCSVTest(User user) {
//		assertEquals(homePage.goToLogInPage().doLogin(user.getEmailAddress(), user.getPassword()).getUserName(),
//				"Karthik D");
//	}

	@Test(description = "Verifying login functionality of application with valid user using data from Excel File", groups = {
			"e2e",
			"sanity" }, dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "loginTestExcelDataProvider", retryAnalyzer = com.ui.listeners.MyRetryAnalyzer.class)
	public void loginExcelTest(User user) {
		assertEquals(homePage.goToLogInPage().doLogin(user.getEmailAddress(), user.getPassword()).getUserName(),
				"Karthik D");
	}
}