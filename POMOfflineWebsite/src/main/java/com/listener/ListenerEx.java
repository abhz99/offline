package com.listener;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.report.ReportClass;
import com.utils.DriverUtils;

public class ListenerEx implements ITestListener{
	
	public static Logger log = Logger.getLogger(ListenerEx.class);
	
	// test is the ref of ExtentTest which is initialized by calling method createTest()
	@Override
	public void onTestStart(ITestResult result) 
	{
		ReportClass.test = ReportClass.report.createTest(result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) 
	{
		ReportClass.test.log(Status.PASS, "testcase passed");	
	}

	@Override
	public void onTestFailure(ITestResult result) 
	{
		ReportClass.test.log(Status.FAIL, "testcase failed");
		ReportClass.test.addScreenCaptureFromPath(DriverUtils.getScreenshot(result.getName()));
	}

	@Override
	public void onTestSkipped(ITestResult result) 
	{
		ReportClass.test.log(Status.SKIP, "testcase skipped");
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) 
	{
		ReportClass.reportInitialize();
		log.info("test cases finished time >> :: " + context.getName());
		log.info("start time >> " + new java.util.Date());
	}

	@Override
	public void onFinish(ITestContext context) 
	{
		log.info("test cases finished time >> :: "+context.getName() );
        log.info("finish time >> "+new java.util.Date());
		ReportClass.report.flush();
		
	}

}
