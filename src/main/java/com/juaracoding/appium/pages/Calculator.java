package com.juaracoding.appium.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;



public class Calculator {

        private AndroidDriver<MobileElement> driver;

        By btnSatu = By.id("com.android.calculator2:id/digit_1");
        By btnDua = By.id("com.android.calculator2:id/digit_2");
        By btnTambah = By.id("com.android.calculator2:id/op_add");
        By btnSamaDengan = By.id("com.android.calculator2:id/eq");
    By reset = By.id("com.google.android.calculator:id/eq");
    By btnTiga = By.id("com.android.calculator2:id/digit_3");
    By btnKali = By.id("com.google.android.calculator:id/op_mul");
    By btnEmpat = By.id("com.android.calculator2:id/digit_4");
    By hasil = By.id("com.android.calculator2:id/result");



        public Calculator(AndroidDriver<MobileElement> driver) {
            this.driver = driver;
        }

        public void calcAdd() {
            this.driver.findElement(this.btnSatu).click();
            this.driver.findElement(this.btnTambah).click();
            this.driver.findElement(this.btnDua).click();
            this.driver.findElement(this.btnSamaDengan).click();
        }

     public String calcMultiple() {
            this.driver.findElement(this.reset).click();
            this.driver.findElement(this.btnTiga).click();
            this.driver.findElement(this.btnKali).click();
            this.driver.findElement(this.btnEmpat).click();
            this.driver.findElement(this.btnSamaDengan).click();
            return null; }


    public String getTxtResult() { return ((MobileElement)this.driver.findElement(this.hasil)).getText(); }
}



