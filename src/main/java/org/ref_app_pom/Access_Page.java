package org.ref_app_pom;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Access_Page {
    //Webelement declaration
   // private static final By access_message = AppiumBy.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button");

    private static IOSDriver driver;
    private final WebDriverWait wait;

    //Constructor for initialization of webelements
    public Access_Page(final IOSDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    //Methods to perform operation on web elements
    public void access_accept() {
             //   this.wait.until(ExpectedConditions.elementToBeClickable(this.access_message)).click();
    }


}
