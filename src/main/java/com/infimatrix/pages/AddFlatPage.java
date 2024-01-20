package com.infimatrix.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class AddFlatPage {
    private WebDriver driver;

    public AddFlatPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToAddFlat() {
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div[3]/div/div/div/div[1]/div[2]/a")).click();
    }
public void fillflatDetails(String memberName, String flatNo, String Wing, String parking ) {
        driver.findElement(By.id("id_societymember")).click();
        driver.findElement(By.id("id_societymember")).sendKeys(memberName);
        driver.findElement(By.id("id_flatno")).sendKeys(flatNo);
        driver.findElement(By.id("id_wing")).sendKeys(Wing);
driver.findElement(By.xpath("/html/body/div/div/div[2]/div[3]/form/div/div[1]/div/div/div[4]/span[1]/span[1]/span/span")   ).click();       
 driver.findElement(By.xpath("/html/body/div/div/div[2]/div[3]/form/div/div[1]/div/div/div[4]/span[1]/span[1]/span/span")).sendKeys(parking);
        
    }
    
    
    public void saveflatDetails() {
        driver.findElement(By.xpath("//*[@id=\"submitbutton\"]")).click();
    }

}


    


