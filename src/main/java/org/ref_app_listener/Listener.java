package org.ref_app_listener;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.restassured.internal.util.IOUtils;
import org.openqa.selenium.WebElement;
import org.ref_app_base.Ref_App_Launch_Close;
import org.ref_app_common_methods.Utility_Common_Methods;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Base64;


public class Listener extends Ref_App_Launch_Close implements ITestListener {
    public ExtentReports extent;
    public ExtentTest extentTest;

    @Override
    public void onTestStart(ITestResult result) {
        String r = result.getName();
        Reporter.log("TC " + r + " Execution started", true);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        Reporter.log("TC " + result.getName() + " Execution skipped", true);

    }

    public void onTestFailure(ITestResult result, String WebElement) {
        Reporter.log("TC " + result.getName() + " Execution Failed", true);
        try {

            Utility_Common_Methods.takeScreenshotmethod(driver, result.getTestName());

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        Reporter.log("TC " + result.getName() + " Execution successful", true);
    }

}
