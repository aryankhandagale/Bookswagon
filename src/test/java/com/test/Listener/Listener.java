package com.test.Listener;

import com.aventstack.extentreports.ExtentTest;
import com.bookswagon.util.TestUtil;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.bookswagon.base.BaseClass;

import java.io.IOException;

public class Listener extends BaseClass implements ITestListener {
    TestUtil utility;

    public void onTestStart(ITestResult result) {
        System.out.println(".....onTestStart...... "+ result.getName());
        extent.attachReporter(spark);
    }

    public void onTestSuccess(ITestResult result) {
        System.out.println(".....onTestSuccess...... "+ result.getName());
        ExtentTest extentTest = extent.createTest(result.getName());
        extentTest.pass("Successfully Executed");
        extent.flush();
    }

    public void onTestFailure(ITestResult result) {
        System.out.println(".....onTestFailure...... "+ result.getName());
        ExtentTest extentTest = extent.createTest(result.getName());
        extentTest.fail("Test Failed");
        String failedName = result.getMethod().getMethodName();
        utility = new TestUtil();
        try {
            utility.failedTest(failedName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        extentTest.addScreenCaptureFromPath("C:\\Aryan\\Bookswagon\\Screenshots\\"+result.getMethod().getMethodName()+".png");
        extent.flush();
    }

    public void onTestSkipped(ITestResult result) {
        System.out.println(".....onTestSkipped...... "+ result.getName());
        ExtentTest extentTest = extent.createTest(result.getName());
        extentTest.skip("Test Skipped");
        extent.flush();
    }
}