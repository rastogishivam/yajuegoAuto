package com.org.yajuego.base;

import com.org.yajuego.utils.FileUtils;
import org.testng.ITestContext;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;

public class BaseTest {
    public static boolean isProdEnv = false;


    public static boolean getEnv() {
        return isProdEnv;
    }


    @BeforeTest(alwaysRun = true)
    public void init(ITestContext context) throws MalformedURLException, InterruptedException {
        FileUtils.initializeProp();
        isProdEnv = Boolean.parseBoolean(context.getCurrentXmlTest().getParameter("isProdEnv"));
        System.out.println("Environment :: " + isProdEnv);
    }
}