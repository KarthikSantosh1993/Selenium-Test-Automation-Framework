package com.ui.listeners;

import java.util.Arrays;

import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.utility.BrowserUtility;
import com.utility.ExtentReporterUtility;
import com.utility.LoggerUtility;

import com.ui.tests.BaseTest;

public class TestListener implements ITestListener {

	Logger logger = LoggerUtility.getLogger(this.getClass());

	ExtentSparkReporter extentSparkReporter;
	ExtentReports extentReports;
	ExtentTest extentTest;

	@Override
	public void onStart(ITestContext context) {
		logger.info("Test Suite Started ");
		
		ExtentReporterUtility.setUpSparkReporter("report.html");
	}
	
	@Override
	public void onTestStart(ITestResult result) {
		logger.info(result.getMethod().getMethodName());
		logger.info(result.getMethod().getDescription());
		logger.info(Arrays.toString(result.getMethod().getGroups()));
		
		ExtentReporterUtility.createExtentTest(result.getMethod().getMethodName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		logger.info(result.getMethod().getMethodName() + " " + "PASSED");
		
		ExtentReporterUtility.getTest().log(Status.PASS, result.getMethod().getMethodName());

	}

	@Override
	public void onTestFailure(ITestResult result) {
		logger.error(result.getMethod().getMethodName() + " " + "FAILED");
		logger.error(result.getThrowable().getMessage());
		
		ExtentReporterUtility.getTest().log(Status.FAIL, result.getMethod().getMethodName());
		ExtentReporterUtility.getTest().log(Status.FAIL, result.getThrowable().getMessage());
		
		Object testclass= result.getInstance();
		
		BrowserUtility browserUtility= ((BaseTest)testclass).getInstance() ;
		logger.info("Capturing screenshot for failed test");
		String screenshotPath= browserUtility.takeScreenshot(result.getMethod().getMethodName());
		logger.info("Attaching screenshot to the HTML report");
		
		ExtentReporterUtility.getTest().addScreenCaptureFromPath(screenshotPath);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		logger.warn(result.getMethod().getMethodName() + " " + "SKIPPED");

		ExtentReporterUtility.getTest().log(Status.SKIP, result.getMethod().getMethodName());
	}

	@Override
	public void onFinish(ITestContext context) {
		logger.info("Test Suite Completed ");
		
		ExtentReporterUtility.flushReport();
	}
}
