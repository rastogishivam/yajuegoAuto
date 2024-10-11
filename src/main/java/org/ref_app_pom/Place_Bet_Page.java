package org.ref_app_pom;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Place_Bet_Page {
    //Webelement declaration
    //private final By cancel_place_bet_button = AppiumBy.xpath("//div[@id=\"confirm-btn-canecl-btn-container\"]/div[2]");
    private final By cancel_place_bet_button = AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Cancelar\"]");

   // private final By place_bet_confirm_button_winner_scenario=AppiumBy.xpath("//div[@id=\"confirm-btn-canecl-btn-container\"]/div[1]");
    private final By place_bet_confirm_button_winner_scenario=AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Confirmar\"]");

   private final By place_bet_confirm_button_error = AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Entendido\"]");
   // private final By place_bet_confirm_button_error = AppiumBy.xpath("(//div[@id='confirm-btn-canecl-btn-container'])[2]/div");

    private final By place_bet_confirm_button_success = AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"¡FELICITACIONES!\"]");

    private final IOSDriver driver;
    private final WebDriverWait wait;

    //Constructor for initialization of webelements
    public Place_Bet_Page(final IOSDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    //Methods to perform operation on web elements
    public boolean place_bet_cancle_button() throws InterruptedException  {
        WebElement place_bet_cancel = this.wait.until(ExpectedConditions.visibilityOfElementLocated(this.cancel_place_bet_button));
        Thread.sleep(1000);
        boolean result = place_bet_cancel.isEnabled();
        place_bet_cancel.click();
        return result;
    }

    public boolean place_bet_confirm_button() throws InterruptedException{
        WebElement place_bet_confirm = this.wait.until(ExpectedConditions.elementToBeClickable(this.place_bet_confirm_button_winner_scenario));
        Thread.sleep(1000);
        boolean result = place_bet_confirm.isEnabled();
        place_bet_confirm.click();
        return result;
    }

    public boolean place_bet_confirm_button_error_page() throws InterruptedException {
        WebElement place_bet_confirm_error = this.wait.until(ExpectedConditions.elementToBeClickable(this.place_bet_confirm_button_error));
        Thread.sleep(1000);
        boolean result = place_bet_confirm_error.isEnabled();
        place_bet_confirm_error.click();
        return result;
    }

    public boolean place_bet_confirm_button_success_page() throws InterruptedException {
        WebElement place_bet_confirm_success = this.wait.until(ExpectedConditions.elementToBeClickable(this.place_bet_confirm_button_success));
        Thread.sleep(1000);
        boolean result = place_bet_confirm_success.isEnabled();
        place_bet_confirm_success.click();
        return result;
    }

}

