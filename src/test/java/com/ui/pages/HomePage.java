package com.ui.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Browser;
import com.utility.BrowserUtility;
import com.utility.JSONUtility;
import com.utility.LoggerUtility;

import static com.constants.Env.*;

public final class HomePage extends BrowserUtility {
	Logger logger = LoggerUtility.getLogger(this.getClass());
	public HomePage(Browser browserName, boolean isHeadless) {
		super(browserName, isHeadless);
		maximizeWindow();
		goToWebsite(JSONUtility.readJSONConfig(QA).getUrl());
	}
	
	public HomePage(WebDriver driver) {
		super(driver);
		maximizeWindow();
		goToWebsite(JSONUtility.readJSONConfig(QA).getUrl());
	}

	private static final By SIGNINLINKLOCATOR = By.xpath("//a[contains(text(),\"Sign in\")]");

	public LoginPage goToLogInPage() {
		logger.info("Trying to perform Click Sign in button to go to login page");
		clickOn(SIGNINLINKLOCATOR);

		return new LoginPage(getDriver());
	}

	public void quit() {
		getDriver().quit();
	}
}