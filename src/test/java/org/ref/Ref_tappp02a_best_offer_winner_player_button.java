package org.ref;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.restassured.internal.util.IOUtils;
import org.ref_app_base.Ref_App_Launch_Close;
import org.ref_app_common_methods.Utility_Common_Methods;
import org.ref_app_pom.Offer_List_Page;
import org.ref_app_pom.OTP_page;
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
public class Ref_tappp02a_best_offer_winner_player_button extends Ref_App_Launch_Close {
    public ExtentReports extent;
    public ExtentTest extentTest;
    SoftAssert so=new SoftAssert();

    @Test
    public void test_suite_1_TC11_verify_Best_Offer_button_1_enabled_by_default() throws InterruptedException {
        extentTest = extent.startTest("Test suite 1 TC11 Verify Best Offer option 1 field is enable or not ");
       //final var otp_page=new OTP_page(driver);
       // Thread.sleep(20000);
        final var offer_page=new Offer_List_Page(driver);
        Set<String> s = driver.getContextHandles();
        for (String ContextName : s) {
            System.out.println(ContextName); //Will print the name of both Native and WebView ContextId
        }
       // otp_page.continue_button_after_entering_correct_otp();
        so.assertTrue(offer_page.offer_button_1_by_default(),"test script 1: failed, Best offer button is disable by default");
    }
    @Test
    public void test_suite_1_TC12_verify_Winner_button_2_enabled_by_default() throws InterruptedException {
        extentTest = extent.startTest("ref_tappp_12_verify_Winner_button_2_enabled_by_default");
        final var offer_page=new Offer_List_Page(driver);
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
        so.assertTrue(offer_page.offer_button_2_by_default(),"test script 2: failed, winner button is disable by default");
    }
    @Test
    public void test_suite_1_TC13_verify_Player_button_3_enabled_by_default() throws InterruptedException {
        extentTest = extent.startTest("ref_tappp_13_verify_Player_button_3_enabled_by_default");
        final var offer_page=new Offer_List_Page(driver);
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
        so.assertTrue(offer_page.offer_button_3_by_default(),"test script 13: failed, player button is disable by default");
    }

    @BeforeSuite
    public void setExtent() throws InterruptedException {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        extent = new ExtentReports(System.getProperty("user.dir") + "/Reports/" + "Tappp_Ref_app" + timeStamp + ".html", true);
        extent.addSystemInfo("Host Name", "Kavyas-MacBook-Air.local");
        extent.addSystemInfo("User Name", "kavyapathuri");
        extent.addSystemInfo("Environment", "QA");

    }

    @AfterSuite
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
            if(result.getName().equals("test_suite_1_TC11_verify_Best_Offer_button_1_enabled_by_default")){
                extentTest.log(LogStatus.INFO,"Test case 11 failed: Actual Result: Best offer tab is not diplaying, " +
                        "Expected Result: Best offer tab should display and enable by default");
            }
            else if (result.getName().equals("test_suite_1_TC12_verify_Winner_button_2_enabled_by_default")) {
                extentTest.log(LogStatus.INFO,"Test case 12 failed: Actual Result: Winner tab is not displaying on panel, " +
                        "Expected Result: Winner tab should display and enable ");;
            }
            else if (result.getName().equals("test_suite_1_TC13_verify_Player_button_3_enabled_by_default")) {
                extentTest.log(LogStatus.INFO, "Test case 7 failed: Actual Result: Player tab is not displaying on panel," +
                        " Expected Result: Player tab should display on panel and should be enable");
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
        Thread.sleep(10000);
    }


}


