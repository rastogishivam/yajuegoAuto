package org.ref_app_bp_test;

import com.org.yajuego.constant.Constant;
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

//this class contains all otp related positive as well as negative test cases and best offer option 1 related end to end test cases
public class Dth_Ref_tappp_All_Tests extends Ref_App_Launch_Close {
    public ExtentReports extent;
    public ExtentTest extentTest;
    SoftAssert so = new SoftAssert();
    SoftAssert sa = new SoftAssert();


    //To test an application

    @Test
    public void test_suite_1_TC10_Verify_after_entering_correct_otp_user_able_to_land_on_best_offer_page1() throws InterruptedException {
        extentTest = extent.startTest("test_suite_1_TC10 Verify after entering correct otp user able to land on change profile page");
        final var otp_page = new OTP_page(driver);
        Offer_List_Page offer_list_page = new Offer_List_Page(driver);
        Set<String> s = driver.getContextHandles();
        driver.context("NATIVE_APP");
        Assert.assertTrue(otp_page.continue_button_after_entering_correct_otp(), "test_suite_1_TC10: failed, User is not able to land on desired page after entering correct OTP");
        offer_list_page.swipeToOffer("Goles", Constant.RIGHT);
        offer_list_page.swipeToOfferAmount("6000", Constant.RIGHT);
    }

    @Test
    public void test_suite_1_TC00_verify_Environment_Change_functionality() throws InterruptedException {
        extentTest = extent.startTest("Test_Suite_1_TC00 Verify Environment Change functionality");
        final var environment_Page = new Environment_Page(driver);
        environment_Page.toggleButtonAutomation();
    }

    // @Test
    public void test_suite_1_TC01b_verify_Switch_to_Sandbox_functionality() throws InterruptedException {
        extentTest = extent.startTest("Test_Suite_1_TC01 Verify Switch to Sandbox functionality");
        final var environment_Page = new Environment_Page(driver);
        environment_Page.toggleButtonAutomation();
    }

    //@Test
    public void test_suite_1_TC01_verify_show_hide_panel_is_displaying_or_not() {
        extentTest = extent.startTest("Test_Suite_1_TC01 Verify show hide panel is displaying or not");
        final var Panel_Button_Page = new Panel_Button_Page(driver);
        Assert.assertTrue(Panel_Button_Page.show_hide_button_select_is_displayed(), "test case 01 fail: show hide panel button is not displaying");
    }


    // @Test
    public void test_suite_1_TC02_verify_panel_button_is_enabled_to_accept_otp() throws InterruptedException {
        extentTest = extent.startTest("Test_Suite_1_TC02 Verify show hide panel button is enabled or not", "............");
        final var Panel_Button_Page = new Panel_Button_Page(driver);
        Assert.assertTrue(Panel_Button_Page.show_hide_button_select_is_enabled(), "test case fail: panel button for otp is disable");
    }


    //@Test
    public void test_suite_1_TC03_verify_continue_button_before_entering_otp() throws InterruptedException {
        extentTest = extent.startTest("Test_Suite_1_TC03 Verify continue button before entering otp on otp screen");
        final var otp_page = new OTP_page(driver);
        Thread.sleep(10000);
        Set<String> s = driver.getContextHandles();
        for (String ContextName : s) {
            System.out.println(ContextName); //Will print the name of both Native and WebView ContextId
        }
        //pass the WebView name
        driver.context("NATIVE_APP");
        Assert.assertFalse(otp_page.continue_button_before_entering_otp(), "Test case ref_tappp_03: failed, connector button is enable before entering otp");
    }

    //@Test
    // @Parameters("environment")
    public void test_suite_1_TC04_verify_OTP_length() {
        extentTest = extent.startTest("Test_Suite_1_TC04 Verify OTP length");
        final var otp_page = new OTP_page(driver);
        Set<String> s = driver.getContextHandles();
        for (String ContextName : s) {
            System.out.println(ContextName); //Will print the name of both Native and WebView ContextId
        }
        //pass the WebView name
        driver.context("NATIVE_APP");
        int otpLength = otp_page.otp_length();
        System.out.println("OTP Length: " + otpLength);

        // Assert that OTP length is 6
        Assert.assertEquals(otpLength, 6, "Test_Suite_1_TC04: failed, OTP length is not matching");
    }

    //@Test
    // @Parameters("environment")
    public void test_suite_1_TC05_Verify_OTP_alphanumeric() {
        extentTest = extent.startTest("Test_Suite_1_TC05 Verify otp digits does not contains special characters");
        final var otp_page = new OTP_page(driver);
       /* Set<String> contextHandles = driver.getContextHandles();
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
        }*/
        Assert.assertFalse(otp_page.otp_alphanumeric(), "Test_Suite_1_TC05 failed: otp contains special characters");
    }

    //@Test
    public void test_suite_1_TC06_Verify_error_message_is_displaying_or_not_in_case_of_invalid_OTP_or_not() throws InterruptedException {
        extentTest = extent.startTest("Test_Suite_1_TC06 Verify error message is displaying or not in case of invalid OTP or not");
        final var otp_page = new OTP_page(driver);
        Set<String> s = driver.getContextHandles();
        driver.context("NATIVE_APP");
        // Verify error message after entering wrong OTP
        boolean isErrorMessageDisplayed = otp_page.tap_continue_button_after_entering_wrong_otp_error_message();
        Assert.assertTrue(isErrorMessageDisplayed, "Test_Suite_1_TC06 failed: After entering wrong OTP error message is not displaying");
    }

    // @Test
    public void test_suite_1_TC07_Verify_OTP_mismatching_error_as_per_requirement_or_not() throws InterruptedException {
        extentTest = extent.startTest("test_suite_1_TC07_Verify clicking on continue button after entering wrong OTP dislaying correct error message or not");
        final var otp_page = new OTP_page(driver);
        Set<String> s = driver.getContextHandles();
        driver.context("NATIVE_APP");
        Assert.assertEquals(otp_page.continue_button_after_entering_wrong_otp_error_message_matching(), "Verifica el código ingresado", "test_suite_1_TC07 : failed, Error message is not matching with requirement");
    }

    //@Test
    public void test_suite_1_TC08_Verify_continue_button_after_entering_special_characters() throws InterruptedException {
        extentTest = extent.startTest("test_suite_1_TC08 Verify continue button will enable or not after entering special characters");
        final var otp_page = new OTP_page(driver);
        Set<String> s = driver.getContextHandles();
        driver.context("NATIVE_APP");
        boolean isButtonDisabled = otp_page.special_char_wrong_otp_acceptance();

        if (!isButtonDisabled) {
            extentTest.log(LogStatus.PASS, "The Connect button is correctly disabled after entering special characters in OTP fields.");
        } else {
            extentTest.log(LogStatus.FAIL, "The Connect button is enabled, but it should be disabled after entering special characters in OTP fields.");
            Assert.fail("The Connect button is enabled when it should be disabled.");
        }
    }

    //@Test
    public void test_suite_1_TC09_verify_continue_button_after_entering_five_digit_otp() throws InterruptedException {
        extentTest = extent.startTest("test_suite_1_TC09_Verify continue button is enabled or not after entering 5 digit otp");
        final var otp_page = new OTP_page(driver);
        Set<String> s = driver.getContextHandles();
        driver.context("NATIVE_APP");
        boolean isButtonDisabled = otp_page.tap_continue_button_after_entering_five_digit_otp();

        if (isButtonDisabled) {
            extentTest.log(LogStatus.PASS, "The Connect button is correctly disabled after entering a 5-digit OTP.");
        } else {
            extentTest.log(LogStatus.FAIL, "The Connect button is enabled when it should be disabled after entering a 5-digit OTP.");
            Assert.fail("test_suite_1_TC09: failed, after entering 5-digit OTP, the Connect button is not disabled.");
        }
    }

    @Test
    public void test_suite_1_TC10_Verify_after_entering_correct_otp_user_able_to_land_on_best_offer_page() throws InterruptedException {
        extentTest = extent.startTest("test_suite_1_TC10 Verify after entering correct otp user able to land on change profile page");
        final var otp_page = new OTP_page(driver);
        Set<String> s = driver.getContextHandles();
        driver.context("NATIVE_APP");
        Assert.assertTrue(otp_page.continue_button_after_entering_correct_otp(), "test_suite_1_TC10: failed, User is not able to land on desired page after entering correct OTP");
    }

    @Test
    public void test_suite_1_TC11_verify_Best_Offer_button_1_enabled_by_default() throws InterruptedException {
        extentTest = extent.startTest("Test suite 1 TC11 Verify Best Offer option 1 field is enable or not ");
        final var offer_page = new Offer_List_Page(driver);
        Set<String> s = driver.getContextHandles();
        driver.context("NATIVE_APP");
        so.assertTrue(offer_page.offer_button_1_by_default(), "test script 1: failed, Best offer button is disable by default");
    }

    @Test
    public void test_suite_1_TC12_verify_Winner_button_2_enabled_by_default() throws InterruptedException {
        extentTest = extent.startTest("ref_tappp_12_verify_Winner_button_2_enabled_by_default");
        final var offer_page = new Offer_List_Page(driver);
        Set<String> s = driver.getContextHandles();
        driver.context("NATIVE_APP");
        so.assertTrue(offer_page.offer_button_2_by_default(), "test script 2: failed, winner button is disable by default");
    }

    @Test
    public void test_suite_1_TC13_verify_Player_button_3_enabled_by_default() throws InterruptedException {
        extentTest = extent.startTest("ref_tappp_13_verify_Player_button_3_enabled_by_default");
        final var offer_page = new Offer_List_Page(driver);
        Set<String> s = driver.getContextHandles();
        driver.context("NATIVE_APP");
        so.assertTrue(offer_page.offer_button_3_by_default(), "test script 13: failed, player button is disable by default");
    }

    @Test
    public void test_suite_1_TC14_verify_slider_value_25000_dollar_enabled_by_default() throws InterruptedException {
        extentTest = extent.startTest("test_suite_1_TC14 verify slider value 25000 dollar enabled by default");
        final var offer_page = new Offer_List_Page(driver);
        Set<String> s = driver.getContextHandles();
        driver.context("NATIVE_APP");
        Assert.assertTrue(offer_page.default_value(), "test suite 1 TC14: failed, default value 25000 dollar not showing on slider");
    }

    // @Test
    public void test_suite_1_TC15_Verify_all_slider_values_are_enabled() throws InterruptedException {
        extentTest = extent.startTest("test_suite_1_TC15 Verify all horizontal slider values are enabled");
        Set<String> s = driver.getContextHandles();
        driver.context("NATIVE_APP");
        final var offer_page = new Offer_List_Page(driver);
        Assert.assertTrue(offer_page.all_slider_values_read(), "test suit 2 TC15: failed, all slider values are not enable");
    }

    // @Test
    public void test_suite_1_TC16_verify_best_offer_option_1_is_enabled() throws InterruptedException {
        extentTest = extent.startTest("Test_suite_1_TC16 Verify best offer option 1 is enabled");
        final var offer_page = new Offer_List_Page(driver);
        Set<String> s = driver.getContextHandles();
        driver.context("NATIVE_APP");
        sa.assertTrue(offer_page.best_offer_option1_click(), "Test_suite_1_TC16: failed, best offer option 1 is not enable");
    }

    @Test
    public void test_suite_1_TC17_verify_best_offer_option_1_is_enabled() throws InterruptedException {
        extentTest = extent.startTest("Test_suite_1_TC17 Verify best offer option 1 is enabled");
        final var offer_page = new Offer_List_Page(driver);
        Set<String> s = driver.getContextHandles();
        driver.context("NATIVE_APP");
        sa.assertTrue(offer_page.best_offer_option1(), "Test_suite_1_TC17: failed, best offer option 1 is not enable");
    }

    @Test
    public void test_suite_1_TC18_verify_best_offer_option_1_place_bet_is_enabled() throws InterruptedException {
        extentTest = extent.startTest("Test_suite_1_TC18 Verify best offer option 1 place bet tab is enabled");
        Set<String> s = driver.getContextHandles();
        driver.context("NATIVE_APP");
        final var offer_page = new Offer_List_Page(driver);
        sa.assertTrue(offer_page.place_bet_for_best_offer_option1(), "Test_suite_1_TC18: failed, place bet option for best offer option 1 not showing on panel");
    }

    @Test
    public void test_suite_1_TC19_verify_user_able_to_click_login_button_when_username_password_not_entered() throws InterruptedException {
        extentTest = extent.startTest("Test_suite_1_TC19 Verify user is able to click login button when username and password not entered");
        Set<String> s = driver.getContextHandles();
        driver.context("NATIVE_APP");
        final var login_page = new Login_Page(driver);
        sa.assertTrue(login_page.login_button_disable_before_entering_username_password(), "Test_suite_1_TC19: failed, Login button is enable even if username and password is blank");
    }

    @Test
    public void test_suite_1_TC20_verify_user_able_to_click_login_button_when_username_password_entered() throws InterruptedException {
        extentTest = extent.startTest("Test_suite_1_TC20 Verify user is able to click on click on login after entering username and password");
        Set<String> s = driver.getContextHandles();
        driver.context("NATIVE_APP");
        final var login_page = new Login_Page(driver);
        sa.assertFalse(login_page.login_button_after_entering_username_password(), "Test_suite_1_TC20: failed, Login button is enable even if username and password is blank");
    }

    @Test
    public void test_suite_1_TC21_verify_user_able_to_click_login_with_incorrect_credential() throws InterruptedException {
        extentTest = extent.startTest("Test_suite_1_TC21 Verify user is able to login with incorrect credential");
        Set<String> s = driver.getContextHandles();
        driver.context("NATIVE_APP");
        final var login_page = new Login_Page(driver);
        sa.assertEquals(login_page.wrong_login_credential(), "Landing on error page", "Test_suite_1_TC21: failed, Login button is enable even if username and password is blank");
    }

    @Test
    public void test_suite_1_TC22_verify_user_able_to_click_on_try_again_button_on_login_error_page() throws InterruptedException {
        extentTest = extent.startTest("Test_suite_1_TC22 Verify user is able to click on try again button on login error page");
        Set<String> s = driver.getContextHandles();
        driver.context("NATIVE_APP");
        final var error_login = new Error_Page_login(driver);
        sa.assertFalse(error_login.try_again(), "Test_suite_1_TC22: failed, Login button is enable even if username and password is blank");
    }

    @Test
    public void test_suite_1_TC23_verify_user_able_to_click_login_with_correct_credential() throws InterruptedException {
        extentTest = extent.startTest("Test_suite_1_TC23 Verify user is able to login with correct credential");
        final var login_page = new Login_Page(driver);
        Set<String> s = driver.getContextHandles();
        driver.context("NATIVE_APP");
        sa.assertTrue(login_page.correct_login_credential(), "Test_suite_1_TC23: failed, Login button is enable even if username and password is blank");
    }

    @Test
    public void test_suite_1_TC24_verify_user_able_to_click_on_confirm_bet_for_best_offer_option_1() throws InterruptedException {
        extentTest = extent.startTest("Test_suite_1_TC24 Verify user is able to confirm bet for best offer option 1");
        final var place_bet = new Place_Bet_Page(driver);
        Set<String> s = driver.getContextHandles();
        driver.context("NATIVE_APP");
        sa.assertTrue(place_bet.place_bet_confirm_button(), "Test_suite_1_TC24: failed, User is not able to place the bet");
        place_bet.place_bet_confirm_button_error_page();
    }

    @Test
    public void test_suite_1_TC25_verify_place_bet_cancel_for_winner1_option_1() throws InterruptedException {
        extentTest = extent.startTest("ref_tappp_25_verify_place_bet_cancel_for_winner1_option1");
        Set<String> s = driver.getContextHandles();
        driver.context("NATIVE_APP");
        final var offer_page = new Offer_List_Page(driver);
        final var place_bet = new Place_Bet_Page(driver);
        offer_page.place_bet_for_winner_option1();
        Assert.assertTrue(place_bet.place_bet_cancle_button(), "test case 13: failed, cancel place button is disable");
    }

    @Test
    public void test_suite_1_TC26_verify_winner2_place_bet_confirm_scenario() throws InterruptedException {
        extentTest = extent.startTest("ref_tappp_15_verify_winner2_place_bet_confirm_scenario");
        Set<String> s = driver.getContextHandles();
        driver.context("NATIVE_APP");
        final var offer_page = new Offer_List_Page(driver);
        final var place_bet = new Place_Bet_Page(driver);
        offer_page.place_bet_for_winner_option2();
        Assert.assertTrue(place_bet.place_bet_confirm_button(), "test case 15: failed, confirm place button is disable for winner2");
        place_bet.place_bet_confirm_button_error_page();
    }

    @Test
    public void test_suite_1_TC27_verify_place_bet_cancel_for_player1() throws InterruptedException {
        extentTest = extent.startTest("ref_tappp_16_ Verify for player 1 bet place cancel scenario", " If test case pass means player 1 is able cancel bet, If test case failed: user is not able to cancel bet, user should able to cancel bet for player 1");
        Set<String> s = driver.getContextHandles();
        driver.context("NATIVE_APP");
        final var offer_page = new Offer_List_Page(driver);
        final var place_bet = new Place_Bet_Page(driver);
        offer_page.place_bet_for_player_option1();
        so.assertTrue(place_bet.place_bet_cancle_button(), "Test case ref_tappp_16: failed: user is not able to cancel bet for player 1");
    }

    @Test
    public void test_suite_1_TC28_verify_player2_place_bet_confirm_scenario() throws InterruptedException {
        extentTest = extent.startTest("ref_tappp_17_verify_place_bet_cancel_for_player2");
        Set<String> s = driver.getContextHandles();
        driver.context("NATIVE_APP");
        final var offer_page = new Offer_List_Page(driver);
        final var place_bet = new Place_Bet_Page(driver);
        offer_page.place_bet_for_player_option2();
        Assert.assertTrue(place_bet.place_bet_confirm_button(), "test case 17: failed, cancel place button is disable");
        place_bet.place_bet_confirm_button_error_page();
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
    public void endReport() {
        extent.flush();
        extent.close();
    }

    //To open an application
    @BeforeClass
    public void setupClass() throws MalformedURLException, InterruptedException {
        configureAppium();
    }

    //to close an application
    @AfterMethod
    public void tear_Down(ITestResult result) throws IOException, InterruptedException {

        if (result.getStatus() == ITestResult.FAILURE) {
            extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS " + result.getName()); //to add name in extent report
            extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS " + result.getThrowable()); //to add error/exception in extent report
            if (result.getName().equals("ref_tappp_01_verify_show_hide_panel_is_displaying_or_not")) {
                extentTest.log(LogStatus.INFO, "Test case 1 failed: Actual Result: Show hide panel not displaying," +
                        " Expected Result: Show hide panel should display on screen");
            } else if (result.getName().equals("ref_tappp_02_verify_panel_button_is_enabled_to_accept_otp")) {
                extentTest.log(LogStatus.INFO, "Test case 2 failed: Actual Result:Show hide panel screen is disable to accept otp, " +
                        "Expected Result: Should show and hide enter otp screen after clicking on show hide panel");
            } else if (result.getName().equals("ref_tappp_03_verify_continue_button_before_entering_otp")) {
                extentTest.log(LogStatus.INFO, "Test case 3 failed: Actual Result: Enter otp screen continue button is enable, " +
                        "Expected Result: Continue button should be disable until user enter 6 digit otp");
            } else if (result.getName().equals("ref_tappp_04_verify_continue_button_after_entering_otp")) {
                extentTest.log(LogStatus.INFO, "Test case 4 failed: Actual Result: After entering 6 digit otp continue button is disable," +
                        " Expected Result: User should able to click on continue button after entering otp ");
            } else if (result.getName().equals("ref_tappp_05_verify_Best_Offer_button_1_enabled_by_default")) {
                extentTest.log(LogStatus.INFO, "Test case 5 failed: Actual Result: Best offer tab is not diplaying, " +
                        "Expected Result: Best offer tab should display and enable by default");
            } else if (result.getName().equals("ref_tappp_06_verify_Winner_button_2_enabled_by_default")) {
                extentTest.log(LogStatus.INFO, "Test case 6 failed: Actual Result: Winner tab is not displaying on panel, " +
                        "Expected Result: Winner tab should display and enable ");
            } else if (result.getName().equals("ref_tappp_07_verify_Player_button_3_enabled_by_default")) {
                extentTest.log(LogStatus.INFO, "Test case 7 failed: Actual Result: Player tab is not displaying on panel," +
                        " Expected Result: Player tab should display on panel and should be enable");
            } else if (result.getName().equals("ref_tappp_08_verify_slider_value_25000_dollar_enabled_by_default")) {
                extentTest.log(LogStatus.INFO, "Test case 8 failed: Actual Result: Slider value 25000 dollar is not enable by default ," +
                        " Expected Result: Slider value 25000 dollar should be enable(auto-selected) by default");
            } else if (result.getName().equals("ref_tappp_09_verify_best_offer_option_1_is_enabled")) {
                extentTest.log(LogStatus.INFO, "Test case 9 failed: Actual Result:Best Offer Option 1 is not displaying," +
                        " Expected Result: Best Offer option 1 should display on panel");
            } else if (result.getName().equals("ref_tappp_10_verify_best_offer_option_1_place_bet_is_enabled")) {
                extentTest.log(LogStatus.INFO, "Test case 10 failed: Actual Result: Best offer option 1 place bet tab is not diplaying or disable, " +
                        "Expected Result: User should able to click on Best offer option 1 place bet tab");
            } else if (result.getName().equals("ref_tappp_11_verify_best_offer_option2_place_bet_is_enabled")) {
                extentTest.log(LogStatus.INFO, "Test case 11 failed: Actual Result:Best offer option 2 place bet tab is not diplaying or disable, \" +\n" +
                        "                        \"Expected Result: User should able to click on Best offer option 2 place bet tab");
            } else if (result.getName().equals("ref_tappp_12_verify_user_able_to_login_for_bet_place")) {
                extentTest.log(LogStatus.INFO, "Test case 12 failed: Actual Result:User not able to login using username and password," +
                        " Expected Result: User should able to login with valid credentials");
            } else if (result.getName().equals("ref_tappp_13_verify_place_bet_cancel")) {
                extentTest.log(LogStatus.INFO, "Test case 13 failed: Actual Result: User not able to cancel bet for Best offer 1, " +
                        "Expected Result: User should able to cancel bet for Best Offer 1");
            } else if (result.getName().equals("ref_tappp_14_verify_winner1_place_bet_confirm_scenario")) {
                extentTest.log(LogStatus.INFO, "Test case 14 failed: Actual Result: User is not able to confirm bet for winner option 1, " +
                        "Expected Result: User should able to confirm bet for winner option 1");
            } else if (result.getName().equals("ref_tappp_15_verify_winner2_place_bet_confirm_scenario")) {
                extentTest.log(LogStatus.INFO, "Test case 15 failed: Actual Result: User is not able to confirm bet for winner option 2, \" +\n" +
                        "                        \"Expected Result: User should able to confirm bet for winner option 2");
            } else if (result.getName().equals("ref_tappp_16_verify_place_bet_cancel_for_player1")) {
                extentTest.log(LogStatus.INFO, "Test case 16 failed: Actual Result: User is not able to cancel bet for player 2," +
                        " Expected Result: User should able to cancel bet for player 1");
            } else if (result.getName().equals("ref_tappp_17_verify_place_bet_cancel_for_player2")) {
                extentTest.log(LogStatus.INFO, "Test case 17 failed: Actual Result: User is not able to cancel bet for player 2, " +
                        "Expected result: user should able to cancel bet for player 2");
            }
            String screenshotPath = Utility_Common_Methods.takeScreenshotmethod(driver, result.getTestName());
            InputStream in = new FileInputStream(screenshotPath);
            byte[] ssBytes = IOUtils.toByteArray(in);
            String base64 = Base64.getEncoder().encodeToString(ssBytes);
            extentTest.log(LogStatus.FAIL, extentTest.addBase64ScreenShot("data:image/png;base64," + base64)); //to add screenshot in extent report
            //extentTest.log(LogStatus.FAIL, extentTest.addScreencast(screenshotPath)); //to add screencast/video in extent report
        } else if (result.getStatus() == ITestResult.SKIP) {
            extentTest.log(LogStatus.SKIP, "Test Case SKIPPED IS " + result.getName());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            extentTest.log(LogStatus.PASS, "Test Case PASSED IS " + result.getName());
            String screenshotPath = Utility_Common_Methods.takeScreenshotmethod(driver, result.getTestName());
            InputStream in = new FileInputStream(screenshotPath);
            byte[] ssBytes = IOUtils.toByteArray(in);
            String base64 = Base64.getEncoder().encodeToString(ssBytes);
            extentTest.log(LogStatus.PASS, extentTest.addBase64ScreenShot("data:image/png;base64," + base64)); //to add screenshot in extent report

        }
        extent.endTest(extentTest); //ending test and ends the current test and prepare to create html report


        //tearDown();
        Thread.sleep(5000);
    }

}