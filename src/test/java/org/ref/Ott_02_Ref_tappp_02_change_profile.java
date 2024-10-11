package org.ref;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.restassured.internal.util.IOUtils;
import org.ref_app_base.Ref_App_Launch_Close;
import org.ref_app_common_methods.Utility_Common_Methods;
import org.ref_app_pom.Profile_Page;
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


@Listeners(org.ref_app_listener.Listener.class)


public class Ott_02_Ref_tappp_02_change_profile extends Ref_App_Launch_Close {

    public ExtentReports extent;
    public ExtentTest extentTest;

    //To test an application
  //  @Test
    public void test_suite_1_TC11_checkAllElementsofChangeProfilePage() throws InterruptedException{
        extentTest = extent.startTest("Test_Suite_1_TC011 Check all elements of the page");
        final var profile_page = new Profile_Page(driver);
        profile_page.test_image_profile_1();
        profile_page.test_image_profile_2();
        Assert.assertEquals(profile_page.test_profile_1(),"test-profile-1","test_suite_1_TC011 : failed, Error message is not matching with requirement");
        Assert.assertEquals(profile_page.test_profile_2(),"test-profile-2","test_suite_1_TC011 : failed, Error message is not matching with requirement");
        Assert.assertEquals(profile_page.test_profile_sentence_1(),"Necesitas cambiar de perfil","test_suite_1_TC011 : failed, Error message is not matching with requirement");
        Assert.assertEquals(profile_page.test_profile_sentence_2(),"Para continuar, tu perfil en la app debe ser igual al de tu TV","test_suite_1_TC011 : failed, Error message is not matching with requirement");
        Assert.assertEquals(profile_page.test_profile_change_notnow(),"Ahora no","test_suite_1_TC011 : failed, Error message is not matching with requirement");
    }
    @Test
    public void test_suite_2_TC12_checkUserAbleToClickOnChangeProfile() throws InterruptedException {
        extentTest = extent.startTest("Test_Suite_2_TC012 Verify user able to click on change profile or not");
        final var profile_page = new Profile_Page(driver);
        Assert.assertTrue(profile_page.test_change_profile(),"test_suite_2_TC12: failed, User is not able to change profile");
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
            if(result.getName().equals("test_suite_1_TC11_checkAllElementsofChangeProfilePage")){
                extentTest.log(LogStatus.INFO,"test_suite_1_TC11 failed: Actual Result: All elements not visible," +
                        " Expected Result: All Elements should be visible");
            }
            else if (result.getName().equals("test_suite_2_TC12_checkUserAbleToClickOnChangeProfile")) {
                extentTest.log(LogStatus.INFO,"test_suite_2_TC12 failed: Actual Result:User is not  able to click on change profile, " +
                        "Expected Result: User should be able to click on change profile");
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
