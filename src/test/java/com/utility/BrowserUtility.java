package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import com.constants.Browser;

/*****
 * @Note
 *  BrowserUtility class contains 
 * 1. WebDriver 
 * 2. Constructor initialises BROWSER in which scripts need to be executed
 * 3. Common wrapper methods for performing actions
 */
public abstract class BrowserUtility {
	Logger logger = LoggerUtility.getLogger(this.getClass());
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	public BrowserUtility(WebDriver driver) {
		super();
		setDriver(driver);
	}

	public void setDriver(WebDriver driver) {
		this.driver.set(driver);
	}

	public WebDriver getDriver() {
		return driver.get();
	}

	public BrowserUtility(Browser browserName) {
		logger.info("Launching browser for "+browserName);
		if (browserName == Browser.CHROME) {
			setDriver(new ChromeDriver());
		} else if (browserName == Browser.FIREFOX) {	
			setDriver(new ChromeDriver());
		} else if (browserName == Browser.SAFARI) {
			setDriver(new ChromeDriver());
		} else {
			logger.error("Invalid browser Name ...!! Please Select Chrome or Edge or Safari");	
		}
	}
	
	public BrowserUtility(Browser browserName, boolean isHeadless) {
		
		logger.info("Launching browser for " + browserName);
		if (browserName == Browser.CHROME) {
			if (isHeadless) {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless");
				options.addArguments("--window-size=1920,1080");
				setDriver(new ChromeDriver(options));

			} else {
				setDriver(new ChromeDriver());
			}

		} else if (browserName == Browser.FIREFOX) {
			if (isHeadless) {
				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("--headless=old");
				options.addArguments("--window-size=1920,1080");
				setDriver(new FirefoxDriver(options));

			} else {
				setDriver(new FirefoxDriver());
			}

		} else if (browserName == Browser.SAFARI) {
			setDriver(new SafariDriver());

		} else {
			logger.error("Invalid browser Name ...!! Please Select Chrome or Firefox or Safari");

		}
	}

	public void maximizeWindow() {
		logger.info("maximizing the browser window");
		getDriver().manage().window().maximize();
	}

	public void goToWebsite(String url) {
		logger.info("navigating to Url: "+url);
		getDriver().get(url);
	}

	public void clickOn(By locator) {
		logger.info("finding Element with locator" + locator);
		WebElement element = getDriver().findElement(locator);
		logger.info("Element found and now performing click ");
		element.click();
	}

	public void enterText(By locator, String textToEnter) {
		logger.info("finding Element with locator" + locator);
		WebElement element = getDriver().findElement(locator);
		logger.info("Element found and now entering text:" +textToEnter);
		element.sendKeys(textToEnter);
	}

	public String getVisibleText(By locator) {
		logger.info("finding Element with locator" + locator);
		WebElement element = getDriver().findElement(locator);
		logger.info("Returning the visible text:" + element.getText());
		return element.getText();
	}
	
	public String takeScreenshot(String name) {
		Date date = new Date();
		SimpleDateFormat format= new SimpleDateFormat("HH-mm-ss");
		String timeStamp = format.format(date);
		
		String path = System.getProperty("user.dir")+ "/screenshots/"+ name + "-" + timeStamp + ".png"  ;
		
		TakesScreenshot screenshot = (TakesScreenshot) getDriver();
		File screenshotData = screenshot.getScreenshotAs(OutputType.FILE);
		
		File screenshotFile = new File(path);
		try {
			FileUtils.copyFile(screenshotData, screenshotFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;	
	}
}