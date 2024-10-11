package org.ref_app_pom;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.ref_app_common_methods.Utility_for_OTP;

import java.time.Duration;

public class Profile_Page {

    private final By t_1 = AppiumBy.xpath("(//XCUIElementTypeStaticText[@name=\"T\"]");
    private final By t_2 = AppiumBy.xpath("(//XCUIElementTypeStaticText[@name=\"K\"]");
    private final By test_profile2 = AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"test-profile-2\"]");
    private final By test_profile1 = AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"kavyaa\"]");
    private final By sentence_1 = AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Necesitas cambiar de perfil\"]");
    private final By sentence_2 = AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Para continuar, tu perfil en la app debe ser igual al de tu TV\"]");
    private final By change_profile = AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Cambiar el Perfil\"]");
    private final By not_now = AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Ahora no\"]");
    private final By user_id = AppiumBy.xpath("(//div[@id=\"user_id\"]/input");
    private final By password = AppiumBy.xpath("(//input[@id=\"password\"]");
    private final By start_session = AppiumBy.xpath("(//div[@id=\"all_login_content\"]/div[5]");


    private final IOSDriver driver;
    private final WebDriverWait wait;

    public Profile_Page(final IOSDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(80));
    }

    public boolean test_image_profile_1() throws InterruptedException {
        boolean t1_btn1 = this.wait.until(ExpectedConditions.visibilityOfElementLocated(this.t_1)).isDisplayed();
        return t1_btn1;
    }

    public boolean test_image_profile_2() throws InterruptedException {
        boolean t2_btn2 = this.wait.until(ExpectedConditions.visibilityOfElementLocated(this.t_2)).isDisplayed();
        return t2_btn2;
    }

    public boolean test_profile_1() throws InterruptedException {
        boolean t_profile1 = this.wait.until(ExpectedConditions.visibilityOfElementLocated(this.test_profile1)).isDisplayed();
        return t_profile1;
    }

    public boolean test_profile_2() throws InterruptedException {
        boolean t_profile2 = this.wait.until(ExpectedConditions.visibilityOfElementLocated(this.test_profile2)).isDisplayed();
        return t_profile2;
    }

    public boolean test_profile_sentence_1() throws InterruptedException {
        boolean t_profile_s1 = this.wait.until(ExpectedConditions.visibilityOfElementLocated(this.sentence_1)).isDisplayed();
        return t_profile_s1;
    }

    public boolean test_profile_sentence_2() throws InterruptedException {
        boolean t_profile_s2 = this.wait.until(ExpectedConditions.visibilityOfElementLocated(this.sentence_2)).isDisplayed();
        return t_profile_s2;
    }

    public boolean test_change_profile() throws InterruptedException {
        WebElement t_profile_change = this.wait.until(ExpectedConditions.elementToBeClickable(this.change_profile));
        boolean result1 = t_profile_change.isEnabled();
        t_profile_change.click();
        return result1;
    }

    public boolean test_profile_change_notnow() throws InterruptedException {
        boolean t_profile_notnow = this.wait.until(ExpectedConditions.visibilityOfElementLocated(this.not_now)).isDisplayed();
        return t_profile_notnow;
    }



}
