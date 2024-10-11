package org.ref_app_pom;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Panel_Button_Page {
    //private final By panel_button_otp = AppiumBy.id("com.tappp.rmgreferenceapp:id/floatingButtonOtp");
    //private final By show_hide_button = AppiumBy.xpath("//android.widget.ImageButton[@content-desc=\"button for toggle of panel view\"]");
    //private final By panel_button = AppiumBy.xpath("//android.widget.ImageButton[@resource-id=\"com.tappp.rmgreferenceapp:id/floatingButton\"]");
    private final By show_hide_button = AppiumBy.xpath("//XCUIElementTypeButton[@name=\"click\"]");

    private final By more_button = AppiumBy.xpath("//XCUIElementTypeButton[@name=\"more\"]");

    private final By show_hide_button1 = AppiumBy.xpath("//XCUIElementTypeButton[@name=\"click\"]");


    private final IOSDriver driver;
    private final WebDriverWait wait;

    public Panel_Button_Page(final IOSDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(80));
    }

//    public Boolean panel_button_otp_select() {
//        WebElement panel_otp = this.wait.until(ExpectedConditions.elementToBeClickable(this.panel_button_otp));
//        Boolean d=panel_otp.isEnabled();
//        panel_otp.click();
//        return d;
//    }

    public Boolean show_hide_button_select_is_enabled() {
        WebElement a=this.wait.until(ExpectedConditions.elementToBeClickable(this.show_hide_button));
        Boolean d=a.isEnabled();
        return d;
    }
    public Boolean show_hide_button_select_is_displayed() {
        Boolean b=this.wait.until(ExpectedConditions.elementToBeClickable(this.show_hide_button)).isDisplayed();
        return b;
    }

//    public Boolean panel_button_select() {
//        Boolean c=this.wait.until(ExpectedConditions.elementToBeClickable(this.panel_button)).isEnabled();
//        return c;
//    }


}
