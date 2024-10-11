package org.ref;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.restassured.internal.util.IOUtils;
import org.ref_app_base.Ref_App_Launch_Close;
import org.ref_app_common_methods.Utility_Common_Methods;
import org.ref_app_pom.Access_Page;
import org.ref_app_pom.OTP_page;
import org.ref_app_pom.Offer_List_Page;
import org.ref_app_pom.Panel_Button_Page;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.Set;
@Listeners(org.ref_app_listener.Listener.class)
public class Ref_tappp03_Bet_Amount_Horizontal_slider extends Ref_App_Launch_Close {
    SoftAssert sa=new SoftAssert();
    public ExtentReports extent;
    public ExtentTest extentTest;

    @Test
    public void test_suite_1_TC14_verify_slider_value_25000_dollar_enabled_by_default() throws InterruptedException {
        extentTest = extent.startTest("test_suite_1_TC14 verify slider value 25000 dollar enabled by default");
       // Thread.sleep(20000);
        final var offer_page = new Offer_List_Page(driver);
        Set<String> s = driver.getContextHandles();
        for (String ContextName : s) {
            System.out.println(ContextName); //Will print the name of both Native and WebView ContextId
        }
        Assert.assertTrue(offer_page.default_value(),"test suite 1 TC14: failed, default value 25000 dollar not showing on slider");
}
@Test
public void test_suite_1_TC15_Verify_all_slider_values_are_enabled() throws InterruptedException {
    extentTest = extent.startTest("test_suite_1_TC15 Verify all horizontal slider values are enabled");
    Set<String> contextHandles = driver.getContextHandles();
    boolean webviewFound = false;
    // Iterate through all context handles
    for (String contextName : contextHandles) {
        System.out.println(contextName); // Print the name of both Native and WebView ContextId
        if (contextName.contains("WEBVIEW")) {
            driver.context(contextName); // Switch to WebView context
            webviewFound = true;
            break;
        }
    }
    // If no WebView context is found, log an error
    if (!webviewFound) {
        extentTest.log(LogStatus.ERROR, "WebView context not found");
        Assert.fail("WebView context not found");
    }
    final var offer_page = new Offer_List_Page(driver);
    Assert.assertTrue(offer_page.all_slider_values_read(),"test suit 2 TC15: failed, all slider values are not enable");
}


    @BeforeSuite
    public void setExtent() throws InterruptedException {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        extent = new ExtentReports(System.getProperty("user.dir") + "/Reports/" + "Tappp_Ref_app" + timeStamp + ".html", true);
        extent.addSystemInfo("Host Name", "Kavyas-MacBook-Air.local");
        extent.addSystemInfo("User Name", "kavyapathuri");
        extent.addSystemInfo("Environment", "QA");

    }

   // @AfterSuite
    public void endReport(){
        extent.flush();
        extent.close();
        tearDown();
    }
    //To open an application
    @BeforeClass
    public void setupClass() throws MalformedURLException, InterruptedException {
        configureAppium();
    }

    //to close an application
    @AfterMethod
    public void tear_Down(ITestResult result) throws IOException, InterruptedException {

        if(result.getStatus()==ITestResult.FAILURE){
            extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS "+result.getName()); //to add name in extent report
            extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS "+result.getThrowable()); //to add error/exception in extent report
            if(result.getName().equals("test_suite_1_TC14_verify_slider_value_25000_dollar_enabled_by_default")){
                extentTest.log(LogStatus.INFO,"test_suite_1_TC14 failed: Actual Result: Bet amount slider default value 25000 dollar is disable," +
                        " Expected Result: Bet amount slider default value 25000 dollar should be enable");
            }
            else if (result.getName().equals("test_suite_1_TC15_Verify_all_slider_values_are_enabled")) {
                extentTest.log(LogStatus.INFO,"test_suite_1_TC15 failed: Actual Result: All fields of bet amount slider are not enabled, one or more field are disable , " +
                        "Expected Result: All bet amount slider fields should be enable");
            }

            String screenshotPath = Utility_Common_Methods.takeScreenshotmethod(driver, result.getTestName());
            InputStream in=new FileInputStream(screenshotPath);
            byte[] ssBytes = IOUtils.toByteArray(in);
            String base64 = Base64.getEncoder().encodeToString(ssBytes);
            extentTest.log(LogStatus.FAIL, extentTest.addBase64ScreenShot("data:image/png;base64,"+base64)); //to add screenshot in extent report
            //extentTest.log(LogStatus.FAIL, extentTest.addScreencast(screenshotPath)); //to add screencast/video in extent report
        }
        else if(result.getStatus()==ITestResult.SKIP){
            extentTest.log(LogStatus.SKIP, "Test Case SKIPPED IS " + result.getName());
        }
        else if(result.getStatus()==ITestResult.SUCCESS){
            extentTest.log(LogStatus.PASS, "Test Case PASSED IS " + result.getName());
            String screenshotPath = Utility_Common_Methods.takeScreenshotmethod(driver, result.getTestName());
            InputStream in=new FileInputStream(screenshotPath);
            byte[] ssBytes = IOUtils.toByteArray(in);
            String base64 = Base64.getEncoder().encodeToString(ssBytes);
            extentTest.log(LogStatus.PASS, extentTest.addBase64ScreenShot("data:image/png;base64,"+base64)); //to add screenshot in extent report

        }
        extent.endTest(extentTest); //ending test and ends the current test and prepare to create html report


        //tearDown();
        Thread.sleep(5000);
    }

}
