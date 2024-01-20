package com.infimatrix.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class ParkingPage {
    private WebDriver driver;

    public ParkingPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToAddParking() {
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div[3]/div/div/div/div[1]/div[2]/a")).click();
    }
public void fillParkingDetails(String memberName, String fastTagID, String vehicleType, String vehicleNo, String vehicleColor, String parkingNo, String parkingType) {
        driver.findElement(By.id("id_societymember")).click();
        driver.findElement(By.id("id_societymember")).sendKeys(memberName);
        driver.findElement(By.id("id_fast_tagID")).sendKeys(fastTagID);
        driver.findElement(By.id("id_vehicle_type")).sendKeys(vehicleType);
        driver.findElement(By.id("id_vehicle_no")).sendKeys(vehicleNo);
        driver.findElement(By.id("id_vehicle_color")).sendKeys(vehicleColor);
        driver.findElement(By.id("id_parking_no")).sendKeys(parkingNo);
        driver.findElement(By.id("id_parking_type")).click();
        driver.findElement(By.id("id_parking_type")).sendKeys(parkingType);
    }
    
    
    public void saveParkingDetails() {
        driver.findElement(By.id("submitbutton")).click();
    }

}


    


