package com.infimatrix.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String username, String password) {
        driver.findElement(By.xpath("//*[@id=\"kt_body\"]/div/div[1]/div[2]/a")).click();
        driver.findElement(By.id("id_username")).sendKeys(username);
        driver.findElement(By.id("id_password")).sendKeys(password);
        driver.findElement(By.xpath("//*[@id=\"kt_app_root\"]/div/div[1]/div/div[2]/form/div/div[5]/button/span[1]")).click();
    }
}