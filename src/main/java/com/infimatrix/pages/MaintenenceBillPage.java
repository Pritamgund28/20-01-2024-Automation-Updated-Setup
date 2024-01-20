package com.infimatrix.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class MaintenenceBillPage {
    private WebDriver driver;

    public MaintenenceBillPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToAddMaintenanceBill() {
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div[3]/div/div/div/div[1]/div[2]/a")).click();
    }
public void fillMaintenenceDetail(String memberName, String flatNo, String maintenenceCharges, String amountDue , String billDate, String dueDate , String billPeriod, String billNo, String transactionId, String billPaid) throws InterruptedException {
        driver.findElement(By.id("id_societymember")).click();
        driver.findElement(By.id("id_societymember")).sendKeys(memberName);
        driver.findElement(By.id("id_flatno")).click();;
        driver.findElement(By.id("id_flatno")).sendKeys(flatNo);
        driver.findElement(By.id("id_maintenance_charges")).sendKeys(maintenenceCharges);
        driver.findElement(By.id("id_amount_due")).sendKeys(amountDue);
        driver.findElement(By.id("id_bill_date")).click();
        driver.findElement(By.id("id_bill_date")).sendKeys("2023-12-07");
        driver.findElement(By.id("id_due_date")).click();
        driver.findElement(By.id("id_due_date")).sendKeys("2023-12-07");
        driver.findElement(By.id("id_bill_period")).sendKeys(billPeriod);
        driver.findElement(By.id("id_bill_no")).sendKeys(billNo);
        driver.findElement(By.id("id_transactionID")).sendKeys(transactionId);
        driver.findElement(By.id("id_bill_paid")).click();
        driver.findElement(By.id("id_bill_paid")).sendKeys(billPaid);
        Thread.sleep(2000);
    }
        public void saveMaintenenceBillDetails() {
driver.findElement(By.xpath("//*[@id=\"submitbutton\"]")).click();
WebElement successElement = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div[1]"));
boolean isLoginSuccessful = successElement.isDisplayed();
        }
        
}