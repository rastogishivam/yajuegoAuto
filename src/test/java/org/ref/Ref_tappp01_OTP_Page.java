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

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.Set;



@Listeners(org.ref_app_listener.Listener.class)

public class Ref_tappp01_OTP_Page extends Ref_App_Launch_Close {

    public ExtentReports extent;
    public ExtentTest extentTest;

    //To test an application
    @Test
    public void test_suite_1_TC01_verify_show_hide_panel_is_displaying_or_not() {
        extentTest = extent.startTest("Test_Suite_1_TC01 Verify show hide panel is displaying or not");
        final var Panel_Button_Page = new Panel_Button_Page(driver);
        Assert.assertTrue(Panel_Button_Page.show_hide_button_select_is_displayed(), "test case 01 fail: show hide panel button is not displaying");
    }


    @Test
    public void test_suite_1_TC02_verify_panel_button_is_enabled_to_accept_otp() throws InterruptedException {
        extentTest = extent.startTest("Test_Suite_1_TC02 Verify show hide panel button is enabled or not","............");
        final var Panel_Button_Page = new Panel_Button_Page(driver);
        Assert.assertTrue(Panel_Button_Page.show_hide_button_select_is_enabled(), "test case fail: panel button for otp is disable");
    }


@Test
public void test_suite_1_TC03_verify_continue_button_before_entering_otp() throws InterruptedException {
    extentTest = extent.startTest("Test_Suite_1_TC03 Verify continue button before entering otp on otp screen");
//    final var Access_Page = new Access_Page(driver);
//    Access_Page.access_accept();
//    final var Panel_Button_Page = new Panel_Button_Page(driver);
//    Panel_Button_Page.show_hide_button_select_is_enabled();
    final var otp_page = new OTP_page(driver);
    Thread.sleep(10000);
    Set<String> s = driver.getContextHandles();
    for (String ContextName : s) {
        System.out.println(ContextName); //Will print the name of both Native and WebView ContextId
    }
    //pass the WebView name
    driver.context("NATIVE_APP");
    Assert.assertFalse(otp_page.continue_button_before_entering_otp(),"Test case ref_tappp_03: failed, connector button is enable before entering otp");
}
    //@Test
    public void test_suite_1_TC04_verify_OTP_length(){
        extentTest = extent.startTest("Test_Suite_1_TC04 Verify OTP length");
        final var otp_page = new OTP_page(driver);
        Set<String> s = driver.getContextHandles();
        for (String ContextName : s) {
            System.out.println(ContextName); //Will print the name of both Native and WebView ContextId
        }
        //pass the WebView name
        driver.context("NATIVE_APP");
       // Assert.assertTrue(otp_page.otp_length()==6,"Test_Suite_1_TC04: failed, OTP length is not matching");
        int otpLength = otp_page.otp_length();
        System.out.println("OTP Length: " + otpLength);

        // Assert that OTP length is 6
        Assert.assertEquals(otpLength, 6, "Test_Suite_1_TC04: failed, OTP length is not matching");
    }
   // @Test
    public void test_suite_1_TC05_Verify_OTP_alphanumeric(){
        extentTest = extent.startTest("Test_Suite_1_TC05 Verify otp digits does not contains special characters");
        final var otp_page = new OTP_page(driver);
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
        Assert.assertFalse(otp_page.otp_alphanumeric(),"Test_Suite_1_TC05 failed: otp contains special characters");
    }
    @Test
    public void test_suite_1_TC06_Verify_error_message_is_displaying_or_not_in_case_of_invalid_OTP_or_not() throws InterruptedException {
        extentTest = extent.startTest("Test_Suite_1_TC06 Verify error message is displaying or not in case of invalid OTP or not");
        final var otp_page = new OTP_page(driver);
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
        // Verify error message after entering wrong OTP
        boolean isErrorMessageDisplayed = otp_page.tap_continue_button_after_entering_wrong_otp_error_message();
        Assert.assertTrue(isErrorMessageDisplayed, "Test_Suite_1_TC06 failed: After entering wrong OTP error message is not displaying");
    }

   // @Test
    public void test_suite_1_TC07_Verify_OTP_mismatching_error_as_per_requirement_or_not() throws InterruptedException {
        extentTest = extent.startTest("test_suite_1_TC07_Verify clicking on continue button after entering wrong OTP dislaying correct error message or not");
        final var otp_page = new OTP_page(driver);
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
        Assert.assertEquals(otp_page.continue_button_after_entering_wrong_otp_error_message_matching(),"El código ingresado es incorrecto o ha expirado","test_suite_1_TC07 : failed, Error message is not matching with requirement");
    }
   // @Test
    public void test_suite_1_TC08_Verify_continue_button_after_entering_special_characters() throws InterruptedException {
        extentTest = extent.startTest("test_suite_1_TC08 Verify continue button will enable or not after entering special characters");
        final var otp_page = new OTP_page(driver);
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
        Assert.assertTrue(otp_page.special_char_wrong_otp_acceptance(),"test_suite_1_TC08: failed, OTP field accepting special characters");
    }
   // @Test
    public void test_suite_1_TC09_verify_continue_button_after_entering_five_digit_otp() throws InterruptedException {
        extentTest = extent.startTest("test_suite_1_TC09_Verify continue button is enabled or not after entering 5 digit otp");
        final var otp_page = new OTP_page(driver);
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
        Assert.assertTrue(otp_page.tap_continue_button_after_entering_five_digit_otp(),"test_suite_1_TC09: failed,after entering five digit otp connector button is not disable");
    }
    @Test
    public void test_suite_1_TC10_Verify_after_entering_correct_otp_user_able_to_land_on_best_offer_page() throws InterruptedException{
        extentTest = extent.startTest("test_suite_1_TC10 Verify after entering correct otp user able to land on change profile page");
        final var otp_page = new OTP_page(driver);
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
        Assert.assertTrue(otp_page.continue_button_after_entering_correct_otp(),"test_suite_1_TC10: failed, User is not able to land on desired page after entering correct OTP");
       //boolean result = otp_page.continue_button_after_entering_correct_otp();
    }

    @BeforeSuite
    public void setExtent() throws InterruptedException {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        extent = new ExtentReports(System.getProperty("user.dir") + "/Reports/" + "Tappp_Ref_app" + timeStamp + ".html", true);
        extent.addSystemInfo("Host Name", "Kavyas-MacBook-Air.local");
        extent.addSystemInfo("User Name", "kavyapathuri");
        extent.addSystemInfo("Environment", "QA");

    }

  //  @AfterSuite
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
   // @AfterMethod
    public void tear_Down(ITestResult result) throws IOException, InterruptedException {

        if(result.getStatus()==ITestResult.FAILURE){
            extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS "+result.getName()); //to add name in extent report
            extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS "+result.getThrowable()); //to add error/exception in extent report
            if(result.getName().equals("test_suite_1_TC01_verify_show_hide_panel_is_displaying_or_not")){
                extentTest.log(LogStatus.INFO,"test_suite_1_TC01 failed: Actual Result: Show hide panel not displaying," +
                        " Expected Result: Show hide panel should display on screen");
            }
            else if (result.getName().equals("test_suite_1_TC02_verify_panel_button_is_enabled_to_accept_otp")) {
                extentTest.log(LogStatus.INFO,"test_suite_1_TC02 failed: Actual Result:Show hide panel screen is disable to accept otp, " +
                        "Expected Result: Should show and hide enter otp screen after clicking on show hide panel");
            }
            else if (result.getName().equals("test_suite_1_TC03_verify_continue_button_before_entering_otp")) {
                extentTest.log(LogStatus.INFO,"test_suite_1_TC03 failed: Actual Result: Enter otp screen continue button is enable, " +
                        "Expected Result: Continue button should be disable until user enter 6 digit otp");
            }
            else if (result.getName().equals("test_suite_1_TC04_verify_OTP_length")) {
                extentTest.log(LogStatus.INFO,"test_suite_1_TC04 failed: Actual Result: User not getting 6 digit OTP, Expected Result: User should recieve 6 digit OTP ");
            }
            else if (result.getName().equals("test_suite_1_TC05_Verify_OTP_alphanumeric")) {
                extentTest.log(LogStatus.INFO,"test_suite_1_TC05 failed: Actual Result: OTP contains values other than alphanumeric values Expected Result: User should get OTP which contains alphanumeric values only ");
            }
            else if (result.getName().equals("test_suite_1_TC06_Verify_error_message_is_displaying_or_not_in_case_of_invalid_OTP_or_not")) {
                extentTest.log(LogStatus.INFO,"test_suite_1_TC06 failed: Actual Result:Error message not displaying, Expected Result: Error message should display in case of wrong OTP");
            }
            else if (result.getName().equals("test_suite_1_TC07_Verify_OTP_mismatching_error_as_per_requirement_or_not")) {
                extentTest.log(LogStatus.INFO," test_suite_1_TC07 failed: Actual Result: OTP error is not matching with requirement, Expected Result: Error message should match with requirement");
            }
            else if (result.getName().equals("test_suite_1_TC08_Verify_continue_button_after_entering_special_characters")) {
                extentTest.log(LogStatus.INFO,"test_suite_1_TC08 failed: Actual Result: OTP text fields are accepting special characters, Expected Result: OTP text fields should not accept special characters");
            }
            else if (result.getName().equals("test_suite_1_TC09_verify_continue_button_after_entering_five_digit_otp")) {
                extentTest.log(LogStatus.INFO," test_suite_1_TC09 failed: Actual Result: Continue button is enable after entering five digit OTP, Expected Result: Continue button should be disable before entering six digit OTP");
            }
            else if (result.getName().equals("test_suite_1_TC10_Verify_after_entering_correct_otp_user_able_to_land_on_best_offer_page")) {
                extentTest.log(LogStatus.INFO,"test_suite_1_TC10 failed: Actual Result: User not able to land on best offer page even after entering correct OTP, Expected Result: User should navigate to best offer page after entering correct OTP");
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

