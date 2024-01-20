package com.infimatrix.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {
    protected WebDriver driver;

    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "F:\\geckodriver-v0.33.0-win64\\geckodriver.exe");
        driver = new FirefoxDriver();
    }
    

    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}