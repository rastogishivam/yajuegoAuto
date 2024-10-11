package org.ref_app_pom;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Error_Page_login {
    //private final By try_again=AppiumBy.xpath("//div[@id=\"tryAgainButtonHolder\"]/div");
    private final By try_again=AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Volver a intentar\"]");

    private final IOSDriver driver;
    private final WebDriverWait wait;

    public Error_Page_login(final IOSDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public boolean try_again() throws InterruptedException {
        WebElement try_again_button=this.wait.until(ExpectedConditions.elementToBeClickable(this.try_again));
        boolean result = try_again_button.isEnabled();
        try_again_button.click();
        return result;
    }
}
