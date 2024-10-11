package org.ref_app_common_methods;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.UUID;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class Utility_Common_Methods {

    //to take screenshot of failed test cases
    public static String takeScreenshotmethod(IOSDriver driver, String mytestname) throws IOException, InterruptedException {

        Thread.sleep(5000);
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        LocalDateTime lt = LocalDateTime.now();
        String s=(System.getProperty("user.dir")+"/src/test/resources/screenshots/" + mytestname + lt + ".png");
        File dest = new File(s);
        FileHandler.copy(src, dest);
        return s;

    }

    //To Scroll
    public static void scrollIntoView(AndroidDriver driver, WebElement element) {
        JavascriptExecutor js = driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    //to take screenshot of single element
    public static String element_screenshot(AppiumDriver driver, WebElement ele){
File screenshotLocation=null;
try {
    File src_file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    BufferedImage fullImg = ImageIO.read(src_file);
    Point point= ele.getLocation();
    int width = ele.getSize().getWidth();
    int height = ele.getSize().getHeight();
    BufferedImage ele_screenshot = fullImg.getSubimage(point.getX(), point.getY(), width, height);
    ImageIO.write(ele_screenshot,"png",src_file);
    String path="screenshot/"+ UUID.randomUUID()+""+".png";
    screenshotLocation=new File(System.getProperty("user.dir")+"/"+path);
    FileUtils.copyFile(src_file, screenshotLocation);
    System.out.println(screenshotLocation.toString());


} catch (IOException e) {
    e.printStackTrace();
}
        return screenshotLocation.toString();
    }

    //wait
    public static void implicit_wait(AndroidDriver driver, int time) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
    }

    //fetch data from excel sheet
    public static String readData_Excel(int row, int cell) throws IOException {
        FileInputStream myfile = new FileInputStream("program_excelsheet.xlsx");// update excel sheet path
        Sheet mysheet = WorkbookFactory.create(myfile).getSheet("....");// update sheet path name
        String data = mysheet.getRow(row).getCell(cell).getStringCellValue();
        return data;
    }

    public static void swipeScreen(AppiumDriver driver) {
        TouchAction action = new TouchAction((PerformsTouchActions) driver);
        int startX = (int) (driver.manage().window().getSize().width * 0.8);
        int endX = (int) (driver.manage().window().getSize().width * 0.2);
        int startY = driver.manage().window().getSize().height / 2;

        action.press(PointOption.point(startX, startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(endX, startY))
                .release()
                .perform();
    }

//    public static String OTT_ConfiguePropertyFileData(String key) throws IOException, InterruptedException {
//        Properties prop = new Properties();
//        Thread.sleep(1000);
//        FileInputStream file = new FileInputStream(System.getProperty(System.getProperty("user.dir") + "\\OTT_Configue.properties"));
//        prop.load(file);
//        Thread.sleep(1000);
//        String value = prop.getProperty(key);
//        return value;
//    }

}
