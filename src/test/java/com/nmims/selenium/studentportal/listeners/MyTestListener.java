package com.nmims.selenium.studentportal.listeners;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyTestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        // Called when a test method starts
        System.out.println("Test started: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // Called when a test method succeeds
        System.out.println("Test passed: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        // Called when a test method fails
        System.out.println("Test failed: " + result.getName());
    }

	@Override
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

    // Other methods like onTestSkipped, onTestFailedButWithinSuccessPercentage, etc.
}
