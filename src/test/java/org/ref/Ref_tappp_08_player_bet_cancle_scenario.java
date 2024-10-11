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
public class Ref_tappp_08_player_bet_cancle_scenario extends Ref_App_Launch_Close {
    public ExtentReports extent;
    public ExtentTest extentTest;
    SoftAssert so;

    @Test
    public void ref_tappp_16_verify_place_bet_cancel_for_player1() throws InterruptedException {
        extentTest = extent.startTest("ref_tappp_16_ Verify for player 1 bet place cancel scenario"," If test case pass means player 1 is able cancel bet, If test case failed: user is not able to cancel bet, user should able to cancel bet for player 1");
        final var Access_Page = new Access_Page(driver);
        Access_Page.access_accept();
        final var otp_page = new OTP_page(driver);
        Set<String> s = driver.getContextHandles();
        for (String ContextName : s) {
            System.out.println(ContextName); //Will print the name of both Native and WebView ContextId
        }
        //pass the WebView name
        driver.context("WEBVIEW_com.tappp.rmgreferenceapp");
        otp_page.continue_button_after_entering_correct_otp();
        final var offer_page = new Offer_List_Page(driver);
        offer_page.place_bet_for_player_option1();
        final var login_page= new Login_Page(driver);
        //login_page.access_accept();
        final var place_bet=new Place_Bet_Page(driver);
        so.assertTrue(place_bet.place_bet_cancle_button(),"Test case ref_tappp_16: failed: user is not able to cancel bet for player 1");


    }
    @Test
    public void ref_tappp_17_verify_place_bet_cancel_for_player2() throws InterruptedException {
        extentTest = extent.startTest("ref_tappp_17_verify_place_bet_cancel_for_player2");
        final var Access_Page = new Access_Page(driver);
        Access_Page.access_accept();
        final var otp_page = new OTP_page(driver);
        Set<String> s = driver.getContextHandles();
        for (String ContextName : s) {
            System.out.println(ContextName); //Will print the name of both Native and WebView ContextId
        }
        //pass the WebView name
        driver.context("WEBVIEW_com.tappp.rmgreferenceapp");
        otp_page.continue_button_after_entering_correct_otp();
        final var offer_page = new Offer_List_Page(driver);
        offer_page.place_bet_for_player_option2();
        final var login_page= new Login_Page(driver);
      //  login_page.access_accept();
        final var place_bet=new Place_Bet_Page(driver);
        Assert.assertTrue(place_bet.place_bet_cancle_button(),"test case 17: failed, cancel place button is disable");
    }


    @BeforeSuite
    public void setExtent(){
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        extent = new ExtentReports(System.getProperty("user.dir") + "/Reports/" + "Tappp_Ref_app" + timeStamp + ".html", true);
        extent.addSystemInfo("Host Name", "NEHAs-MacBook-Air-2.local");
        extent.addSystemInfo("User Name", "nehadeshmukh");
        extent.addSystemInfo("Environment", "QA");
    }

    @AfterSuite
    public void endReport(){
        extent.flush();
        extent.close();
    }
    //To open an application
    @BeforeMethod
    public void setupClass() throws MalformedURLException, InterruptedException {
        configureAppium();
    }

    //to close an application
    @AfterMethod
    public void tear_Down(ITestResult result) throws IOException, InterruptedException {

        if(result.getStatus()==ITestResult.FAILURE){
            extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS "+result.getName()); //to add name in extent report
            extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS "+result.getThrowable()); //to add error/exception in extent report
if(result.getName().equals("ref_tappp_16_verify_place_bet_cancel_for_player1")){
    extentTest.log(LogStatus.INFO,"ref_tappp_16 failed: User is not able to cancel bet for player 1, expected result is: user should able to cancel bet for player 1");
} else if (result.getName().equals("ref_tappp_17_verify_place_bet_cancel_for_player2")) {
    extentTest.log(LogStatus.INFO,"ref_tappp_16 failed: User is not able to cancel bet for player 2, expected result is: user should able to cancel bet for player 2");
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
        //driver.quit();
        tearDown();
        Thread.sleep(10000);
    }

}
