package com.infimatrix.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // public String getWelcomeMessage() {
    //     return driver.findElement(By.xpath("//*[@id=\"kt_app_header_menu\"]/div/span/span[1]")).getText();
    // }
    public void navigateToDashboard() {
        driver.findElement(By.xpath("//*[@id=\"#kt_app_sidebar_menu\"]/div[1]/span/a")).click();
    }
    public void navigateToMemberList() {
        driver.findElement(By.xpath("//*[@id=\"#kt_app_sidebar_menu\"]/div[2]/span/a")).click();
    }
    public void navigateToParking() {
        driver.findElement(By.xpath("//*[@id=\"#kt_app_sidebar_menu\"]/div[3]/span/a")).click();
    }
    public void navigateToHouseConfig() {
        driver.findElement(By.xpath("//*[@id=\"#kt_app_sidebar_menu\"]/div[4]/span/a")).click();
    }
    public void navigateToMaintenanceBill() {
        driver.findElement(By.xpath("//*[@id=\"#kt_app_sidebar_menu\"]/div[5]/span/a")).click();
    }
    public void navigateToNotice() {
        driver.findElement(By.xpath("//*[@id=\"#kt_app_sidebar_menu\"]/div[6]/span/a")).click();
    }
    
}