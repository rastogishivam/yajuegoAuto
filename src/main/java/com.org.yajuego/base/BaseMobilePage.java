package com.org.yajuego.base;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.ref_app_base.Ref_App_Launch_Close;

import java.time.Duration;
import java.util.Arrays;

public class BaseMobilePage {

    public WebDriverWait wait;

    public static boolean scroll(WebElement relatedElement, String direction) {
        try {
            System.out.println("Scrolling to the : {}" + direction);
            Rectangle value = null;
            value = relatedElement.getRect();
            Dimension size = Ref_App_Launch_Close.getDriver().manage().window().getSize();
            int startX = 0, endX = 0, startY = 0, endY = 0;
            switch (direction.toLowerCase()) {
                case "up":
                    startX = endX = value.getX() + value.getWidth() - 1;
                    startY = value.getY() + value.getHeight() + 60;
                    endY = (int) (size.height * 0.8);
                    break;
                case "down":
                    startX = endX = value.getX() + value.getWidth() - 1;
                    startY = (int) (size.height * 0.5);
                    endY = value.getY() + value.getHeight() + 40;
                    break;
                case "left":
                    startX = (int) (size.width * 0.2);
                    endX = (int) (size.width * 0.8);
                    startY = endY = value.getY() + value.getHeight() - 5;
                    break;
                case "right":
                    startX = (int) (size.width * 0.8);
                    endX = value.getX() + value.getWidth() + 30;
                    startY = endY = value.getY() + value.getHeight() - 5;
                    break;
            }
            System.out.println("Swiping to " + startX + ":" + startY + ":" + endX + ":" + endY);
            swipe(startX, startY, endX, endY);
        } catch (Exception e) {
            System.out.println("Scroll failed : {}" + e.getMessage());
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static void swipe(int fromX, int fromY, int toX, int toY) {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1);
        swipe.addAction(finger.createPointerMove(Duration.ofSeconds(0), PointerInput.Origin.viewport(), fromX, fromY));
        swipe.addAction(finger.createPointerDown(0));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(700), PointerInput.Origin.viewport(), toX, toY));
        swipe.addAction(finger.createPointerUp(0));
        Ref_App_Launch_Close.getDriver().perform(Arrays.asList(swipe));
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
        }
    }

    public boolean isTextVisible(String expected, int TimeOutinSeconds) {
        try {
            Thread.sleep(2000);
            String attribute = "label";
            return wait.withTimeout(Duration.ofSeconds(TimeOutinSeconds)).
                    until(ExpectedConditions.visibilityOfElementLocated(
                            By.xpath("//*[contains(translate(@" + attribute + ", 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'),\""
                                    + expected.toLowerCase() + "\")]"))) != null;

        } catch (Exception e) {
            return false;
        }
    }

    public boolean scrollForText(WebElement element, String text, String direction) {
        try {
            for (int i = 0; i < 10; i++) {
                if (isTextVisible(text, 5)) {
                    return true;
                }
                scroll(element, direction);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }

}
