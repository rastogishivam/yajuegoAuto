package org.ref;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.restassured.internal.util.IOUtils;
import org.ref_app_base.Ref_App_Launch_Close;
import org.ref_app_common_methods.Utility_Common_Methods;
import org.ref_app_pom.*;
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
public class Ref_tappp04_End_to_End_flow_best_offer extends Ref_App_Launch_Close {
    SoftAssert sa=new SoftAssert();
    public ExtentReports extent;
    public ExtentTest extentTest;


    @Test
    public void Test_suite_1_TC16_verify_best_offer_option_1_is_enabled() throws InterruptedException {
        extentTest = extent.startTest("Test_suite_1_TC16 Verify best offer option 1 is enabled");
        final var offer_page = new Offer_List_Page(driver);
        Set<String> s = driver.getContextHandles();
        for (String ContextName : s) {
            System.out.println(ContextName); //Will print the name of both Native and WebView ContextId
        }
        driver.context("NATIVE_APP");
        sa.assertTrue(offer_page.best_offer_option1_click(),"Test_suite_1_TC16: failed, best offer option 1 is not enable");
        //sa.assertTrue(offer_page.place_bet_for_1st_match_winner(),"test case 08: failed, place bet option for best offer option 1 not showing on panel");
    }
    @Test
    public void Test_suite_1_TC17_verify_best_offer_option_1_is_enabled() throws InterruptedException {
        extentTest = extent.startTest("Test_suite_1_TC17 Verify best offer option 1 is enabled");
        final var offer_page = new Offer_List_Page(driver);
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
        sa.assertTrue(offer_page.best_offer_option1(),"Test_suite_1_TC17: failed, best offer option 1 is not enable");
    }

    @Test
    public void Test_suite_1_TC18_verify_best_offer_option_1_place_bet_is_enabled() throws InterruptedException {
        extentTest = extent.startTest("Test_suite_1_TC18 Verify best offer option 1 place bet tab is enabled");
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
        sa.assertTrue(offer_page.place_bet_for_best_offer_option1(),"Test_suite_1_TC18: failed, place bet option for best offer option 1 not showing on panel");
    }
    @Test
    public void Test_suite_1_TC19_verify_user_able_to_click_login_button_when_username_password_not_entered() throws InterruptedException {
        extentTest = extent.startTest("Test_suite_1_TC19 Verify user is able to click login button when username and password not entered");
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
   final var login_page = new Login_Page(driver);
        sa.assertFalse(login_page.login_button_disable_before_entering_username_password(),"Test_suite_1_TC19: failed, Login button is enable even if username and password is blank");
    }
    @Test
    public void Test_suite_1_TC20_verify_user_able_to_click_login_button_when_username_password_entered() throws InterruptedException {
        extentTest = extent.startTest("Test_suite_1_TC20 Verify user is able to click on click on login after entering username and password");
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
        final var login_page = new Login_Page(driver);
        sa.assertFalse(login_page.login_button_after_entering_username_password(),"Test_suite_1_TC20: failed, Login button is enable even if username and password is blank");
    }
    @Test
    public void Test_suite_1_TC21_verify_user_able_to_click_login_with_incorrect_credential() throws InterruptedException {
        extentTest = extent.startTest("Test_suite_1_TC21 Verify user is able to login with incorrect credential");
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
        final var login_page = new Login_Page(driver);
        sa.assertEquals(login_page.wrong_login_credential(),"Landing on error page","Test_suite_1_TC21: failed, Login button is enable even if username and password is blank");
    }
    @Test
    public void Test_suite_1_TC22_verify_user_able_to_click_on_try_again_button_on_login_error_page() throws InterruptedException {
        extentTest = extent.startTest("Test_suite_1_TC22 Verify user is able to click on try again button on login error page");
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
        final var error_login=new Error_Page_login(driver);
        sa.assertFalse(error_login.try_again(),"Test_suite_1_TC22: failed, Login button is enable even if username and password is blank");
    }
    @Test
    public void Test_suite_1_TC23_verify_user_able_to_click_login_with_correct_credential() throws InterruptedException {
        extentTest = extent.startTest("Test_suite_1_TC23 Verify user is able to login with correct credential");
        final var login_page = new Login_Page(driver);
        //sa.assertTrue(offer_page.match_winner1_tab(),"test case 08: failed, match winner 1 not showing on panel");
        sa.assertTrue(login_page.correct_login_credential(),"Test_suite_1_TC23: failed, Login button is enable even if username and password is blank");
    }
    @Test
    public void Test_suite_1_TC24_verify_user_able_to_click_on_confirm_bet_for_best_offer_option_1() throws InterruptedException {
        extentTest = extent.startTest("Test_suite_1_TC24 Verify user is able to login with correct credential");
        //sa.assertTrue(offer_page.match_winner1_tab(),"test case 08: failed, match winner 1 not showing on panel");
        final var place_bet=new Place_Bet_Page(driver);
        sa.assertTrue(place_bet.place_bet_confirm_button(),"Test_suite_1_TC24: failed, Login button is enable even if username and password is blank");

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
