package org.ref_app_base;

import com.google.common.collect.ImmutableMap;
import com.org.yajuego.base.BaseTest;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.Setting;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;


public class Ref_App_Launch_Close extends BaseTest {
    //static protected AndroidDriver driver;//declaration of android driver
    static protected IOSDriver driver; // Declaration of iOS driver

    public static IOSDriver getDriver() {
        return driver;
    }

    @BeforeClass
    public void configureAppium() throws MalformedURLException, InterruptedException {

        XCUITestOptions options = new XCUITestOptions(); // Create object of XCUITestOptions to set up the capabilities

        // Set iOS specific capabilities
        options.setPlatformName("iOS");
        options.setAutomationName("XCUITest");
        options.setDeviceName("iPhone 15 Pro");
        options.setPlatformVersion("17.2");
        options.setUdid("C0037282-A479-493A-ABC2-AF7725008481");
        options.setApp("/Users/test/Downloads/Workspace/dtv-squeezeBack-ref-app2.app");
        options.setBundleId("com.ios.dtv12-squeezeBack-ref-app.2");
        options.setCapability("showXcodeLog", true);
        options.setCapability("noReset", true);
        options.setCapability("newCommandTimeout", 600); // Seconds
        options.setCapability("wdaLaunchTimeout", 120000); // Seconds

        // Set the path to your IPA file
        // options.setCapability("app", "/Users/kavyapathuri/IdeaProjects/platform-test-automation/src/test/resources/dtv-squeezeBack-ref-app.ipa");

        // Initialization of iOS driver
        try {
            driver = new IOSDriver(new URL("http://0.0.0.0:4723"), options);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.setSetting(Setting.IGNORE_UNIMPORTANT_VIEWS, true);
    }

    // to scroll emulator screen
    public void scrollToEnd() {
        boolean canScrollMore;
        do {
            canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                    "left", 100, "top", 100, "width", 200, "height", 200,
                    "direction", "down",
                    "percent", 3.0
            ));
        } while (canScrollMore);
    }

    // to scroll upto perticular element
    public void scrollToElement(String ele) {
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"ele\"));"));
    }

    //perform swipe action
    public void swipeAction(WebElement ele, String swipeDirection) {

        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) ele).getId(),
                "direction", swipeDirection,
                "percent", 0.75
        ));
    }

    //to quit app
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}

