package com.infimatrix.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage {
    private WebDriver driver;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    public void signUp(String username, String password, String email) {
        driver.findElement(By.id("signupUsername")).sendKeys(username);
        driver.findElement(By.id("signupPassword")).sendKeys(password);
        driver.findElement(By.id("signupEmail")).sendKeys(email);
    }
}