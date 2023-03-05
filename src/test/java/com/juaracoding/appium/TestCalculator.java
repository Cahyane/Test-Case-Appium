package com.juaracoding.appium;
import static org.testng.Assert.assertEquals;
import java.net.MalformedURLException;
import java.net.URL;

import com.juaracoding.appium.pages.Calculator;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
public class TestCalculator {
    private static AndroidDriver<MobileElement> driver;
    private Calculator calculator;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "Pixel_2_API_30");
        capabilities.setCapability("udid", "emulator-5554");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("Appium : platformVersion", "11.0");
        capabilities.setCapability("Appium : appPackage", "com.android.calculator");
        capabilities.setCapability("Appium : appActivity", "com.android.calculator2.Calculator");

        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @BeforeMethod
    public void pageObject() {
        calculator = new Calculator(driver);
    }

    @Test (priority = 1)
    public void testAdd() {
        calculator.calcAdd();
        System.out.println("Hasil = "+calculator.getTxtResult());
        assertEquals(calculator.getTxtResult(), "3");
    }

    @Test (priority = 3)
    public void testMultiple() {
        calculator.calcMultiple();
        System.out.println("Hasil = "+calculator.getTxtResult());
        assertEquals(calculator.getTxtResult(), "12");
    }

    @AfterClass
    public void closeApp() {
        driver.quit();
    }
}
