package com.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.testbase.TestBase;

public class ListnerEx extends TestBase implements ITestListener {

	public void onTestStart(ITestResult result) {

		test = TestBase.report.createTest(result.getName());
		log.info("testcase ready to start with name" + result.getName());

	}

	public void onTestSuccess(ITestResult result) {
		log.info("testcase pass succesfully with name" + result.getName());
		test.log(Status.PASS, "testcase pass succesfully");

	}

	public void onTestFailure(ITestResult result) {

		log.info("testcase fail  with name" + result.getName());
		test.log(Status.FAIL, "testcase failed");
		test.log(Status.FAIL, result.getThrowable());
		String path = takescreanshot(result.getName());
		test.addScreenCaptureFromPath(path);
	}

	
	public void onTestSkipped(ITestResult result) {

		log.info("testcase skip  with name" + result.getName());
	}
	
	public void onStart(ITestContext Contex) {
		
		log.info("test suite is started"+Contex.getName());
	
	}

	public void onFinish(ITestContext Contex) {
		
		log.info("test suite is finised"+Contex.getName());
		report.flush();
		

	}
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {

	}

}
