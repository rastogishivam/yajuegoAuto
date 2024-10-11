package org.ref_app_pom;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Environment_Page {

    private final By more_option = AppiumBy.xpath("//XCUIElementTypeButton[@name='more']");
    private final By toggleButton = AppiumBy.xpath("//XCUIElementTypeSwitch[@value='0']");
    private final By pickerWheel = AppiumBy.xpath("//XCUIElementTypePickerWheel[@value='SANDBOX']");
    private final By submitButton = AppiumBy.xpath("//XCUIElementTypeStaticText[@name='Submit']");


    private final IOSDriver driver;
    private final WebDriverWait wait;

    public Environment_Page(final IOSDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(80));
    }

    public void navigateToTogglePage() {
        WebElement moreOptionElement = wait.until(ExpectedConditions.visibilityOfElementLocated(more_option));
        moreOptionElement.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(toggleButton));
    }
    public void toggleButtonAutomation() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        navigateToTogglePage();
        Thread.sleep(1000);
        // Click the toggle button
        WebElement toggleButtonElement = this.wait.until(ExpectedConditions.visibilityOfElementLocated(toggleButton));
        toggleButtonElement.click();
        Thread.sleep(1000);
        // Select value from the picker wheel
        WebElement pickerWheelElement = wait.until(ExpectedConditions.visibilityOfElementLocated(pickerWheel));
        pickerWheelElement.sendKeys("PROD");
        Thread.sleep(1000);
        // Click the submit button
        WebElement submitButtonElement = wait.until(ExpectedConditions.visibilityOfElementLocated(submitButton));
        submitButtonElement.click();
    }

}
