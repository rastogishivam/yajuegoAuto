package org.ref_app_pom;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.TimeoutException;

import java.time.Duration;

public class Login_Page {

    //private final By login_button = AppiumBy.xpath("//div[@id=\"all_login_content\"]/div[5]");
    private final By login_button = AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Iniciar sesión\"]");

    //private final By username=AppiumBy.xpath("//div[@id=\"user_id\"]/input");
    private final By username=AppiumBy.xpath("(//XCUIElementTypeStaticText[@name=\"Tu sesión será vinculada con la TV para continuar la apuesta.\"]/parent::*/following-sibling::XCUIElementTypeTextField)");

    //private final By password=AppiumBy.xpath("//input[@id=\"password\"]");
    private final By password=AppiumBy.xpath("(//XCUIElementTypeStaticText[@name=\"Tu sesión será vinculada con la TV para continuar la apuesta.\"]/parent::*/following-sibling::XCUIElementTypeSecureTextField)");

    //private final By try_again=AppiumBy.xpath("//div[@id=\"tryAgainButtonHolder\"]/div/div");
    private final By login_button_text = AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Tu sesión será vinculada con la TV para continuar la apuesta.\"]");

    private final By try_again=AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Volver a intentar\"]");

   // private final By error_message_page=AppiumBy.xpath("//div[@id=\"errorTitle\"]");
    private final By error_message_page=AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Ha ocurrido un error con la cuenta.\"]");

   // private final By login_success_page=AppiumBy.xpath("(//div[@id=\"tappp_text_id\"])[9]");
    private final By login_success_page=AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"CONFIRMA\"]");


    private final IOSDriver driver;
    private final WebDriverWait wait;

    //Constructor for initialization of webelements
    public Login_Page(final IOSDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    //Methods to perform operation on web elements
    public boolean login_button_disable_before_entering_username_password() throws InterruptedException {
        WebElement loginButton = this.wait.until(ExpectedConditions.visibilityOfElementLocated(this.login_button));
        return !loginButton.isEnabled();
    }

    public boolean login_button_after_entering_username_password() throws InterruptedException {
        this.wait.until(ExpectedConditions.elementToBeClickable(this.username)).sendKeys("9099999342");
        this.wait.until(ExpectedConditions.elementToBeClickable(this.password)).sendKeys("1234rewq");
        Thread.sleep(1000);
        driver.findElement(login_button_text).click();
        WebElement login_button=this.wait.until(ExpectedConditions.elementToBeClickable(this.login_button));
        boolean result = login_button.isEnabled();
        return result;
    }

    public String wrong_login_credential() throws InterruptedException {
        this.wait.until(ExpectedConditions.elementToBeClickable(this.username)).clear();
        Thread.sleep(500);
        this.wait.until(ExpectedConditions.elementToBeClickable(this.password)).clear();
        Thread.sleep(500);
        this.wait.until(ExpectedConditions.elementToBeClickable(this.username)).sendKeys("8079999342");
        Thread.sleep(500);
        this.wait.until(ExpectedConditions.elementToBeClickable(this.password)).sendKeys("1234rewq");
        Thread.sleep(500);
        driver.findElement(login_button_text).click();
        WebElement login_button=this.wait.until(ExpectedConditions.elementToBeClickable(this.login_button));
        login_button.click();
        String result="Landing on error page";
        return result;
    }

    public boolean incorrect_login_credential() throws InterruptedException  {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // Initialize WebDriverWait with Duration
            WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(username));
            usernameField.clear();
            usernameField.sendKeys("8099979349"); // incorrect username
            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(password));
            passwordField.clear();
            passwordField.sendKeys("1234rwq"); // incorrect password
            WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(login_button));
            loginButton.click();
            System.out.println("Login button clicked");

            // Check if error message element is present
            boolean errorElementPresent = false;
            try {
                // Wait for the error message to be visible
                wait.until(ExpectedConditions.visibilityOfElementLocated(error_message_page));
                errorElementPresent = true;
            } catch (TimeoutException e) {
                // Error message element was not found within the timeout period
                errorElementPresent = false;
            }

            if (errorElementPresent) {
                System.out.println("Error element detected");
                // Click "Try Again" button if error is present
                WebElement tryAgainButton = null;
                try {
                    tryAgainButton = wait.until(ExpectedConditions.elementToBeClickable(try_again));
                    tryAgainButton.click();
                    System.out.println("Clicked 'Try Again' button");

                    //check if the screen returns to the login page
                    WebElement loginButtonAfterError = wait.until(ExpectedConditions.elementToBeClickable(login_button));
                    System.out.println("Returned to login page after error");
                } catch (TimeoutException e) {
                    // "Try Again" button not found or could not click, so verify other means
                    System.out.println("Error: Could not interact with 'Try Again' button or did not return to login page");
                    return false;
                }

                return true; // Error message was present and handled correctly
            } else {
                // If no error message is detected, the login might be successful unexpectedly
                System.out.println("Unexpected login behavior: Error message not detected");
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean correct_login_credential() throws InterruptedException {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // Initialize WebDriverWait with Duration
            WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(username));
            usernameField.clear();
            usernameField.sendKeys("9099999340");
            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(password));
            passwordField.clear();
            passwordField.sendKeys("1234rewq");
            WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(login_button));
            loginButton.click();
            System.out.println("Login button clicked");

            // Verify if we need to check for error
            boolean errorElementPresent = false;
            try {
                // Check if error message element is present
                wait.until(ExpectedConditions.visibilityOfElementLocated(error_message_page));
                errorElementPresent = true;
            } catch (TimeoutException e) {
                // Error message element was not found, which is expected if login is successful
                errorElementPresent = false;
            }

            if (errorElementPresent) {
                System.out.println("Error element detected");

                // Click "Try Again" button if error is present
                WebElement tryAgainButton = wait.until(ExpectedConditions.elementToBeClickable(try_again));
                tryAgainButton.click();
                System.out.println("Clicked 'Try Again' button");

                // Wait and retry login
                WebElement loginButtonRetry = wait.until(ExpectedConditions.elementToBeClickable(login_button));
                loginButtonRetry.click();
                System.out.println("Retried login button");

                // Check login success after retry
                boolean success = wait.until(ExpectedConditions.visibilityOfElementLocated(login_success_page)) != null;
                System.out.println("Login success after retry: " + success);
                return success;
            }

            // Check login success on initial attempt
            boolean success = wait.until(ExpectedConditions.visibilityOfElementLocated(login_success_page)) != null;
            System.out.println("Login success on initial attempt: " + success);
            return success;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
