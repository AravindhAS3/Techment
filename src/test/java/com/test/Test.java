package com.test;

import java.io.IOException;
import java.time.Duration;

import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.base.BaseClass;
import com.pages.RegPage;

public class Test extends BaseClass {
	ExtentTest test;
	ExtentReports extent;

	
	@BeforeTest
	public void setup() {
		ExtentSparkReporter spark = new ExtentSparkReporter("Spark.html");
		extent = new ExtentReports();
		extent.attachReporter(spark);
		test = extent.createTest("Test", "My Report");
	}

	@AfterTest
	public void getResult(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, result.getThrowable().getMessage());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, result.getTestName());
		} else {
			test.log(Status.SKIP, result.getTestName());
		}
		extent.flush();
	}

	@org.testng.annotations.Test
	public void tc1( ) {
		extent.createTest("Test Case ", "The test case 1 has passed");
		LaunchBrowser();
		launchUrl("");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		RegPage regPage = new RegPage();

		driver.quit();

	}

}