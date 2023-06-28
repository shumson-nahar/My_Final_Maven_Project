package com.tutorialsninja.qa.listeners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.tutorialsninja.qa.utils.ExtentReporter;

public class MyListeners implements ITestListener{
	ExtentReports extentReport;
	@Override
	public void onStart(ITestContext context) {
		//System.out.println("Execution of project Tests started");
		try {
			extentReport = ExtentReporter.generateExtentReport();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

	@Override
	public void onTestStart(ITestResult result) {
		String testName=result.getName();
		System.out.println(testName+"started executing");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String testName=result.getName();
		System.out.println(testName+"got successfully executed");
				
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testName=result.getName();
		System.out.println(testName+"got failed");
		System.out.println(result.getThrowable());
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String testName = result.getName();
		System.out.println(testName+"got skipped");
		System.out.println(result.getThrowable());
		
	}

	

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Finished executing Project Tests");
		
	}

}
