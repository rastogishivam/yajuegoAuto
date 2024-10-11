package org.ref_app_pom;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.ref_app_common_methods.Utility_for_OTP;


import java.time.Duration;

public class OTP_page {

   // private final By otp1 = AppiumBy.xpath("(//div[@id=\"otpEntryHolder\"])[1]/input");
    private final By otp1 = AppiumBy.xpath("//XCUIElementTypeOther[@name=\"OTPScreen\"]/XCUIElementTypeOther[4]/XCUIElementTypeTextField[1]");

    //private final By otp2 = AppiumBy.xpath("(//div[@id=\"otpEntryHolder\"])[2]/input");
    private final By otp2 = AppiumBy.xpath("//XCUIElementTypeOther[@name=\"OTPScreen\"]/XCUIElementTypeOther[4]/XCUIElementTypeTextField[2]");

    //private final By otp3 = AppiumBy.xpath("(//div[@id=\"otpEntryHolder\"])[3]/input");
    private final By otp3 = AppiumBy.xpath("//XCUIElementTypeOther[@name=\"OTPScreen\"]/XCUIElementTypeOther[4]/XCUIElementTypeTextField[3]");

    //private final By otp4 = AppiumBy.xpath("(//div[@id=\"otpEntryHolder\"])[4]/input");
    private final By otp4 = AppiumBy.xpath("//XCUIElementTypeOther[@name=\"OTPScreen\"]/XCUIElementTypeOther[4]/XCUIElementTypeTextField[4]");

    //private final By otp5 = AppiumBy.xpath("(//div[@id=\"otpEntryHolder\"])[5]/input");
    private final By otp5 = AppiumBy.xpath("//XCUIElementTypeOther[@name=\"OTPScreen\"]/XCUIElementTypeOther[4]/XCUIElementTypeTextField[5]");

   // private final By otp6 = AppiumBy.xpath("(//div[@id=\"otpEntryHolder\"])[6]/input");
    private final By otp6 = AppiumBy.xpath("//XCUIElementTypeOther[@name=\"OTPScreen\"]/XCUIElementTypeOther[4]/XCUIElementTypeTextField[6]");

    //private final By connector_button = AppiumBy.xpath("//div[@id=\"otpSubmitButtonHolder\"]/div");
    private final By connector_button1 = AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Conectar\"]");

    //private final By error_message=AppiumBy.xpath("//div[@id=\"topHolder\"]/div[3]/div");
    private final By Otp_pagetext = AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Si el código expira, se generará otro\"]");

    private final By error_message=AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Verifica el código ingresado\"]");
    private final IOSDriver driver;
    private final WebDriverWait wait;

    public OTP_page(final IOSDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(80));
    }

    public Boolean continue_button_before_entering_otp() {
        //WebElement connect = wait.until(ExpectedConditions.elementToBeClickable(this.connector_button));
        WebElement connect = wait.until(ExpectedConditions.presenceOfElementLocated(this.connector_button1));
        Boolean r1 = connect.isEnabled();
return r1;
    }

    public int otp_length(){
       // String otp=org.ref_app_common_methods.Utility_for_OTP.createUser();
       // int otp_length=otp.length();
        Utility_for_OTP utility = new Utility_for_OTP();
        // Call the createUser method on the instance
        String otp = utility.createUser().trim();
        // Get the length of the OTP
        otp = otp.replaceAll("[\\[\\]]", "");
        System.out.println("Generated OTP: " + otp);
        int otp_length = otp.length();
        System.out.println("Calculated OTP Length: " + otp_length);
        return otp_length;
    }
    public Boolean otp_alphanumeric(){
        //String otp=org.ref_app_common_methods.Utility_for_OTP.createUser();
        Utility_for_OTP utility = new Utility_for_OTP();
        String otp = utility.createUser();
        boolean r = otp.contains("[^A-Za-z0-9]");
        return r;
    }

    public Boolean continue_button_after_entering_correct_otp() throws InterruptedException {
        Utility_for_OTP utility = new Utility_for_OTP();
        String otp = utility.createUser().replaceAll("[\\[\\]]", "").trim(); // Clean OTP
        System.out.println("Generated OTP: " + otp); // Debugging line to print OTP
        if (otp.length() != 6) {
            System.out.println("Error: OTP length is incorrect. Expected length is 6.");
            return false;
        }
        try {
            wait.until(ExpectedConditions.elementToBeClickable(this.otp1)).sendKeys(Character.toString(otp.charAt(0)));
            Thread.sleep(300);
            wait.until(ExpectedConditions.elementToBeClickable(this.otp2)).sendKeys(Character.toString(otp.charAt(1)));
            Thread.sleep(300);
            wait.until(ExpectedConditions.elementToBeClickable(this.otp3)).sendKeys(Character.toString(otp.charAt(2)));
            Thread.sleep(300);
            wait.until(ExpectedConditions.elementToBeClickable(this.otp4)).sendKeys(Character.toString(otp.charAt(3)));
            Thread.sleep(300);
            wait.until(ExpectedConditions.elementToBeClickable(this.otp5)).sendKeys(Character.toString(otp.charAt(4)));
            Thread.sleep(300);
            wait.until(ExpectedConditions.elementToBeClickable(this.otp6)).sendKeys(Character.toString(otp.charAt(5)));
            Thread.sleep(300);
            driver.findElement(Otp_pagetext).click();
            WebElement connectButton = wait.until(ExpectedConditions.elementToBeClickable(this.connector_button1));
            boolean isButtonEnabled = connectButton.isEnabled();
            if (isButtonEnabled) {
                connectButton.click();
            } else {
                System.out.println("Connect button is not enabled after entering OTP.");
            }
            return isButtonEnabled;
        } catch (Exception e) {
            System.out.println("Error during OTP entry or button interaction: " + e.getMessage());
            return false;
        }
    }

    public Boolean tap_continue_button_after_entering_correct_otp() {
        String otp = "29BB58";
        By[] otpFields = {otp1, otp2, otp3, otp4, otp5, otp6};
        for (int i = 0; i < otpFields.length; i++) {
            WebElement otpField = this.wait.until(ExpectedConditions.elementToBeClickable(otpFields[i]));
            otpField.clear();
            otpField.sendKeys(String.valueOf(otp.charAt(i)));
        }
        WebElement connectButton = this.wait.until(ExpectedConditions.elementToBeClickable(this.connector_button1));
        boolean isButtonEnabled = connectButton.isEnabled();
        connectButton.click();
        return isButtonEnabled;
    }

    public Boolean tap_continue_button_after_entering_wrong_otp_error_message() throws InterruptedException {
        this.wait.until(ExpectedConditions.elementToBeClickable(this.otp1)).sendKeys("8");
        this.wait.until(ExpectedConditions.elementToBeClickable(this.otp2)).sendKeys("Y");
        this.wait.until(ExpectedConditions.elementToBeClickable(this.otp3)).sendKeys("J");
        this.wait.until(ExpectedConditions.elementToBeClickable(this.otp4)).sendKeys("P");
        this.wait.until(ExpectedConditions.elementToBeClickable(this.otp5)).sendKeys("7");
        this.wait.until(ExpectedConditions.elementToBeClickable(this.otp6)).sendKeys("9");
        Thread.sleep(2000);
        driver.findElement(Otp_pagetext).click();
        WebElement connect1 = this.wait.until(ExpectedConditions.elementToBeClickable(this.connector_button1));
        connect1.click();
        Thread.sleep(1000);
        boolean s1 = this.wait.until(ExpectedConditions.presenceOfElementLocated(error_message)).isDisplayed();
        return s1;
    }

    public String continue_button_after_entering_wrong_otp_error_message_matching() throws InterruptedException {
        String s1 = this.wait.until(ExpectedConditions.visibilityOfElementLocated(this.error_message)).getText();
        return s1;
    }

    public Boolean special_char_wrong_otp_acceptance() throws InterruptedException {
        this.wait.until(ExpectedConditions.elementToBeClickable(this.otp1)).clear();
        this.wait.until(ExpectedConditions.elementToBeClickable(this.otp1)).sendKeys("@");
        this.wait.until(ExpectedConditions.elementToBeClickable(this.otp2)).clear();
        this.wait.until(ExpectedConditions.elementToBeClickable(this.otp2)).sendKeys("#");
        this.wait.until(ExpectedConditions.elementToBeClickable(this.otp3)).clear();
        this.wait.until(ExpectedConditions.elementToBeClickable(this.otp3)).sendKeys(")");
        this.wait.until(ExpectedConditions.elementToBeClickable(this.otp4)).clear();
        this.wait.until(ExpectedConditions.elementToBeClickable(this.otp4)).sendKeys(":");
        this.wait.until(ExpectedConditions.elementToBeClickable(this.otp5)).clear();
        this.wait.until(ExpectedConditions.elementToBeClickable(this.otp5)).sendKeys("_");
        this.wait.until(ExpectedConditions.elementToBeClickable(this.otp6)).clear();
        this.wait.until(ExpectedConditions.elementToBeClickable(this.otp6)).sendKeys("&");
        WebElement connect1 = this.wait.until(ExpectedConditions.visibilityOfElementLocated(this.connector_button1));
        boolean isEnabled = connect1.isEnabled();
        return isEnabled;
    }

    public Boolean tap_continue_button_after_entering_five_digit_otp() throws InterruptedException {
        this.wait.until(ExpectedConditions.elementToBeClickable(this.otp1)).clear();
        this.wait.until(ExpectedConditions.elementToBeClickable(this.otp1)).sendKeys("8");
        this.wait.until(ExpectedConditions.elementToBeClickable(this.otp2)).clear();
        this.wait.until(ExpectedConditions.elementToBeClickable(this.otp2)).sendKeys("Y");
        this.wait.until(ExpectedConditions.elementToBeClickable(this.otp3)).clear();
        this.wait.until(ExpectedConditions.elementToBeClickable(this.otp3)).sendKeys("J");
        this.wait.until(ExpectedConditions.elementToBeClickable(this.otp4)).clear();
        this.wait.until(ExpectedConditions.elementToBeClickable(this.otp4)).sendKeys("P");
        this.wait.until(ExpectedConditions.elementToBeClickable(this.otp5)).clear();
        this.wait.until(ExpectedConditions.elementToBeClickable(this.otp5)).sendKeys("7");
        WebElement connect1 = this.wait.until(ExpectedConditions.visibilityOfElementLocated(this.connector_button1));
        boolean isDisabled = !connect1.isEnabled(); // Expect the button to be disabled, so return the inverse of isEnabled()
        return isDisabled;
    }


}
