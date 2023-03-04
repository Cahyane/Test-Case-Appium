package com.juaracoding.appium;
import static org.testng.Assert.assertEquals;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
public class TestCalculator {
    AndroidDriver driver;
    @BeforeMethod
    public void setup() throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("deviceName","Pixel_2_API_30");
        dc.setCapability("udid","emulate-5554");
        dc.setCapability("platformName","Android");
        dc.setCapability("platformVersion", "11.0");
        dc.setCapability("appPackage","com.google.android.calculator");
        dc.setCapability("appActivity","com.android.calculator2.Calculator");
        dc.setCapability("noReset","false");
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver(url, dc);
    }
    @Test
    public void cekTambah() {
        MobileElement tombol1 = (MobileElement) driver.findElementByAccessibilityId("com.google.android.calculator:id/digit_1");
        tombol1.click();
        MobileElement tombolPlus = (MobileElement) driver.findElementByAccessibilityId("com.google.android.calculator:id/op_add");
        tombolPlus.click();
        MobileElement tombol2 = (MobileElement) driver.findElementByAccessibilityId("com.google.android.calculator:id/digit_2");
        tombol2.click();
        MobileElement tombolSamaDengan = (MobileElement) driver.findElementByAccessibilityId ("equals");
        tombolSamaDengan.click();
        MobileElement result = (MobileElement) driver.findElementByAccessibilityId ("com.google.android.calculator:id/result_preview");
        result.click();
        MobileElement layar = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_3");
        String actualResult = layar.getText();
        String expectedResult = "3";
        assertEquals(actualResult, expectedResult);
    }
}