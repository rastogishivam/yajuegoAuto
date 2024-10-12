package org.ref_app_pom;

import com.org.yajuego.base.BaseMobilePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Offer_List_Page extends BaseMobilePage {

    // private final By offer_button_1 = AppiumBy.xpath("//div[@id=\"buttonContainer_0\"]");
    // private final By offer_button_2 = AppiumBy.xpath("//div[@id=\"buttonContainer_1\"]");
    // private final By offer_button_3 = AppiumBy.xpath("//div[@id=\"buttonContainer_2\"]");
    // private final By default_active_dollar= AppiumBy.xpath("//div[@id=\"BetSelectorCaraousel_dollarAmountSelected\"]");
    //private final By place_bet= AppiumBy.xpath("//div[@id=\"outcomeTeamPlaceBetActionCard\"]");
    // private final By winner_option11= AppiumBy.xpath("(//div[@id=\"tapppSVG_Card_Name_9219186$S_1X2_1\"])[2]");
    // private final By winner_option2= AppiumBy.xpath("(//div[@id=\"tappp_text_id\"])[17]");
    // private final By player_option1= AppiumBy.xpath("(//div[@id=\"tappp_text_id\"])[21]");
    //private final By slider_values_1=AppiumBy.xpath("(//div[@id=\"inActiveAmountSelction\"])[0]");
    //private final By slider_values_1=AppiumBy.xpath("(//div[@id=\"inActiveAmountSelction\"])[0]");
    //private final By best_offer_option11 = AppiumBy.xpath("//div[@id=\"tapppSVG_Card_Name_9219186$S_GGNG2T_Y\"]");

    private final By offer_button_1 = AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Mejor Oferta\"]");
    private final By offer_button_2 = AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Ganador\"]");
    private final By offer_button_3 = AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Goles\"]");
    private final By default_active_dollar1 = AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"2500\"]");
    private final By best_offer_option1 = AppiumBy.xpath("//XCUIElementTypeOther[@name=\"OfferListView\"]/XCUIElementTypeOther[4]/XCUIElementTypeOther[28]");
    private final By place_bet = AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Hacer Apuesta\"]");
    private final By best_offer_option2 = AppiumBy.xpath("//XCUIElementTypeOther[@name=\"OfferListView\"]/XCUIElementTypeOther[4]/XCUIElementTypeOther[29]");
    private final By winner_option1 = AppiumBy.xpath("//XCUIElementTypeOther[@name=\"OfferListView\"]/XCUIElementTypeOther[4]/XCUIElementTypeOther[32]");
    private final By winner_option2 = AppiumBy.xpath("//XCUIElementTypeOther[@name=\"OfferListView\"]/XCUIElementTypeOther[4]/XCUIElementTypeOther[33]");
    private final By player_option1 = AppiumBy.xpath("//XCUIElementTypeOther[@name=\"OfferListView\"]/XCUIElementTypeOther[4]/XCUIElementTypeOther[32]");
    private final By player_option2 = AppiumBy.xpath("//XCUIElementTypeOther[@name=\"OfferListView\"]/XCUIElementTypeOther[4]/XCUIElementTypeOther[33]");
    private final By slider_values_2 = AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"500\"]");
    private final By slider_values_3 = AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"1000\"]");
    private final By slider_values_4 = AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"1500\"]");
    private final By slider_values_5 = AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"2000\"]");
    private final By slider_values_6 = AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"2500\"]");
    private final By slider_values_7 = AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"3000\"]");
    private final By slider_values_8 = AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"3500\"]");
    private final By slider_values_9 = AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"4000\"]");
    private final By slider_values_10 = AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"4500\"]");
    private final By slider_values_11 = AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"5000\"]");
    private final By slider_values_12 = AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"5500\"]");
    private final By slider_values_13 = AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"6000\"]");
    private final By slider_values_14 = AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"6500\"]");
    private final By slider_values_15 = AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"7000\"]");
    private final By slider_values_16 = AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"7500\"]");
    private final By slider_values_17 = AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"8000\"]");
    private final By slider_values_18 = AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"8500\"]");
    private final By slider_values_19 = AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"9000\"]");
    private final By slider_values_20 = AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"9500\"]");
    private final By slider_values_2a = AppiumBy.xpath("(//XCUIElementTypeStaticText[@name=\"500\"])[2]");

    private final By bet_label = AppiumBy.xpath("//div[@id=\"betLabel\"]");
    public By offerElement = AppiumBy.xpath("//XCUIElementTypeOther[@name=\"OfferListView\"]/XCUIElementTypeOther[4]/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeStaticText");
    public By offerAmount = AppiumBy.xpath("//XCUIElementTypeOther[@name=\"OfferListView\"]/XCUIElementTypeOther[4]/XCUIElementTypeOther[8]/child::*[not (contains(@value,'$'))]");
    private IOSDriver driver = null;

    public Offer_List_Page(IOSDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(80));
    }

    public boolean offer_button_1_by_default() {
        WebElement offer_btn1 = this.wait.until(ExpectedConditions.elementToBeClickable(this.offer_button_1));
        boolean result1 = offer_btn1.isEnabled();
        offer_btn1.click();
        return result1;
    }

    public boolean offer_button_2_by_default() {
        WebElement offer_btn2 = this.wait.until(ExpectedConditions.elementToBeClickable(this.offer_button_2));
        boolean result2 = offer_btn2.isEnabled();
        offer_btn2.click();
        return result2;
    }

    public boolean offer_button_3_by_default() {
        WebElement offer_btn3 = this.wait.until(ExpectedConditions.elementToBeClickable(this.offer_button_3));
        boolean result3 = offer_btn3.isEnabled();
        offer_btn3.click();
        return result3;
    }

    public boolean default_value() {
        boolean result4 = this.wait.until(ExpectedConditions.visibilityOfElementLocated(this.default_active_dollar1)).isDisplayed();
        return result4;
    }

    public boolean best_offer_option1_click() {
        WebElement best_11 = this.wait.until(ExpectedConditions.elementToBeClickable(this.offer_button_1));
        boolean result = best_11.isEnabled();
        best_11.click();
        return result;
    }

    public boolean best_offer_option1() throws InterruptedException {
        // this.wait.until(ExpectedConditions.visibilityOfElementLocated(this.offer_button_11)).click();
        WebElement best_1 = this.wait.until(ExpectedConditions.elementToBeClickable(this.best_offer_option1));
        boolean result = best_1.isEnabled();
        best_1.click();
        return result;
    }

    public boolean place_bet_for_best_offer_option1() throws InterruptedException {
        WebElement place_bet_option_for_1st_best_offer = this.wait.until(ExpectedConditions.elementToBeClickable(this.place_bet));
        boolean result1 = place_bet_option_for_1st_best_offer.isEnabled();
        place_bet_option_for_1st_best_offer.click();
        Thread.sleep(1000);
        return result1;
    }

    public boolean place_bet_for_best_offer_option2() {
        this.wait.until(ExpectedConditions.elementToBeClickable(this.best_offer_option2)).click();
        WebElement place_bet_option_for_2nd_best_offer = this.wait.until(ExpectedConditions.elementToBeClickable(this.place_bet));
        boolean result = place_bet_option_for_2nd_best_offer.isEnabled();
        place_bet_option_for_2nd_best_offer.click();
        return result;
    }

    public boolean place_bet_for_winner_option1() throws InterruptedException {
        this.wait.until(ExpectedConditions.elementToBeClickable(this.offer_button_2)).click();
        this.wait.until(ExpectedConditions.elementToBeClickable(this.winner_option1)).click();
        Thread.sleep(1000);
        WebElement place_bet_option = this.wait.until(ExpectedConditions.elementToBeClickable(this.place_bet));
        Thread.sleep(1000);
        boolean r = place_bet_option.isEnabled();
        place_bet_option.click();
        return r;
    }

    public boolean place_bet_for_winner_option2() throws InterruptedException {
        this.wait.until(ExpectedConditions.elementToBeClickable(this.offer_button_2)).click();
        this.wait.until(ExpectedConditions.elementToBeClickable(this.winner_option2)).click();
        Thread.sleep(1000);
        WebElement place_bet_option_ = this.wait.until(ExpectedConditions.elementToBeClickable(this.place_bet));
        boolean result = place_bet_option_.isEnabled();
        place_bet_option_.click();
        return result;
    }

    public boolean place_bet_for_player_option1() throws InterruptedException {
        this.wait.until(ExpectedConditions.elementToBeClickable(this.offer_button_3)).click();
        this.wait.until(ExpectedConditions.elementToBeClickable(this.player_option1)).click();
        Thread.sleep(1000);
        WebElement place_bet_option = this.wait.until(ExpectedConditions.visibilityOfElementLocated(this.place_bet));
        Thread.sleep(1000);
        boolean r = place_bet_option.isEnabled();
        place_bet_option.click();
        return r;
    }

    public boolean place_bet_for_player_option2() throws InterruptedException {
        this.wait.until(ExpectedConditions.elementToBeClickable(this.offer_button_3)).click();
        this.wait.until(ExpectedConditions.elementToBeClickable(this.player_option2)).click();
        Thread.sleep(1000);
        WebElement place_bet_option_ = this.wait.until(ExpectedConditions.elementToBeClickable(this.place_bet));
        boolean result = place_bet_option_.isEnabled();
        place_bet_option_.click();
        return result;
    }

    public boolean place_bet_for_firsthalf_option1() throws InterruptedException {
        this.wait.until(ExpectedConditions.elementToBeClickable(this.offer_button_3)).click();
        this.wait.until(ExpectedConditions.elementToBeClickable(this.player_option1)).click();
        Thread.sleep(1000);
        WebElement place_bet_option = this.wait.until(ExpectedConditions.visibilityOfElementLocated(this.place_bet));
        Thread.sleep(1000);
        boolean r = place_bet_option.isEnabled();
        place_bet_option.click();
        return r;
    }

    public boolean all_slider_values_read() throws InterruptedException {
        WebElement slider4 = this.wait.until(ExpectedConditions.visibilityOfElementLocated(this.default_active_dollar1));
        slider4.click();
        this.wait.until(ExpectedConditions.elementToBeClickable(this.slider_values_5)).click();
        Thread.sleep(1000);
        this.wait.until(ExpectedConditions.elementToBeClickable(this.slider_values_4)).click();
        Thread.sleep(1000);
        this.wait.until(ExpectedConditions.elementToBeClickable(this.slider_values_3)).click();
        Thread.sleep(1000);
        this.wait.until(ExpectedConditions.elementToBeClickable(this.slider_values_2)).click();
        Thread.sleep(1000);
        this.wait.until(ExpectedConditions.elementToBeClickable(this.slider_values_3)).click();
        Thread.sleep(1000);
        this.wait.until(ExpectedConditions.elementToBeClickable(this.slider_values_4)).click();
        Thread.sleep(1000);
        this.wait.until(ExpectedConditions.elementToBeClickable(this.slider_values_5)).click();
        Thread.sleep(1000);
        this.wait.until(ExpectedConditions.elementToBeClickable(this.slider_values_6)).click();
        Thread.sleep(1000);
        this.wait.until(ExpectedConditions.elementToBeClickable(this.slider_values_7)).click();
        Thread.sleep(1000);
        this.wait.until(ExpectedConditions.elementToBeClickable(this.slider_values_8)).click();
        Thread.sleep(1000);
        this.wait.until(ExpectedConditions.elementToBeClickable(this.slider_values_9)).click();
        Thread.sleep(1000);
        this.wait.until(ExpectedConditions.elementToBeClickable(this.slider_values_10)).click();
        Thread.sleep(1000);
        this.wait.until(ExpectedConditions.elementToBeClickable(this.slider_values_11)).click();
        Thread.sleep(1000);
        this.wait.until(ExpectedConditions.elementToBeClickable(this.slider_values_12)).click();
        Thread.sleep(1000);
        this.wait.until(ExpectedConditions.elementToBeClickable(this.slider_values_13)).click();
        Thread.sleep(1000);
        this.wait.until(ExpectedConditions.elementToBeClickable(this.slider_values_14)).click();
        Thread.sleep(1000);
        this.wait.until(ExpectedConditions.elementToBeClickable(this.slider_values_15)).click();
        Thread.sleep(1000);
        this.wait.until(ExpectedConditions.elementToBeClickable(this.slider_values_16)).click();
        Thread.sleep(1000);
        this.wait.until(ExpectedConditions.elementToBeClickable(this.slider_values_17)).click();
        Thread.sleep(1000);
        this.wait.until(ExpectedConditions.elementToBeClickable(this.slider_values_18)).click();
        Thread.sleep(1000);
        this.wait.until(ExpectedConditions.elementToBeClickable(this.slider_values_19)).click();
        Thread.sleep(1000);
        this.wait.until(ExpectedConditions.elementToBeClickable(this.slider_values_20)).click();
        Thread.sleep(1000);
        this.wait.until(ExpectedConditions.elementToBeClickable(this.slider_values_2a)).click();
        boolean r = this.wait.until(ExpectedConditions.elementToBeClickable(this.slider_values_2a)).isDisplayed();
        return r;
    }

    public boolean swipeToOffer(String offerName, String direction) {
        boolean flag = false;
        System.out.println("Swipe to the offer :: " + offerName);
        flag = scrollForText(driver.findElement(offerElement), offerName, direction);
        System.out.println("Veified, is the offer :: " + offerName + " :: visible :: " + flag);
        return flag;
    }

    public boolean swipeToOfferAmount(String amount, String direction) {
        boolean flag = false;
        System.out.println("Swipe to the offer amount :: " + amount);
        flag = scrollForText(driver.findElement(offerAmount), amount, direction);
        System.out.println("Veified, is the offer amount:: " + amount + " :: visible :: " + flag);
        return flag;
    }
}
