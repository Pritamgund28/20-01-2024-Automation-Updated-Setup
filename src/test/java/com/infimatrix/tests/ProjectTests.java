package com.infimatrix.tests;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.infimatrix.pages.AddFlatPage;
import com.infimatrix.pages.BaseTest;
import com.infimatrix.pages.HomePage;
import com.infimatrix.pages.LoginPage;
import com.infimatrix.pages.MaintenenceBillPage;
import com.infimatrix.pages.MemberListPage;
import com.infimatrix.pages.ParkingPage;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.concurrent.TimeUnit;
    public class ProjectTests extends BaseTest {
    private static final String BASE_URL = "https://onenest.infimatrix.in/";
    private LoginPage loginPage;
    // private SignUpPage signUpPage;
    private HomePage homePage;
    private MemberListPage memberListPage;
    private ParkingPage parkingPage;
    private AddFlatPage addFlatPage;
    private MaintenenceBillPage maintenaceBillPage;

    @Before
    public void setUpTest() {
        setUp();
        driver.get(BASE_URL);
        loginPage = new LoginPage(driver);
        
        homePage = new HomePage(driver);
        parkingPage = new ParkingPage(driver);
        memberListPage = new MemberListPage(driver);
        // 2.create object of new page with local variable
        addFlatPage = new AddFlatPage(driver);
        maintenaceBillPage = new MaintenenceBillPage(driver);


        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void tearDownTest() {
        tearDown();
    }

    @Test
    @Ignore
    public void testLogin() {
        loginPage.login("sjadhav@infimatrix.com", "1234");

    }
    @Test
    // @Ignore
    public void testAddMember() {
    loginPage.login("sjadhav@infimatrix.com", "1234");
    homePage.navigateToMemberList();
    memberListPage.navigateToAddMember();

    String firstName = "Akshay";
    String lastName = "Gund"; 
    String email = "agund80@infimatrix.com";
    String contactNumber = "1234512345";
    String whatsappNumber = "9876543212";

    memberListPage.fillMemberDetails(firstName, lastName, email, contactNumber, whatsappNumber);
    boolean isValidFirstName = firstName.matches("[a-zA-Z]+");
    boolean isValidLastName = lastName.matches("[a-zA-Z]+");
    boolean isValidEmail = email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$");
    boolean isValidContactNumber = contactNumber.matches("^[1-9]\\d{9}$");
    boolean isValidWhatsAppNumber = whatsappNumber.matches("^[1-9]\\d{9}$");

    assertTrue("First name should contain only letters", isValidFirstName);
    assertTrue("Last name should contain only letters", isValidLastName);
    assertTrue("Email should be in a valid format", isValidEmail);
    assertTrue("Contact number should be a 10-digit number", isValidContactNumber);
    assertTrue("WhatsApp number should be a 10-digit number", isValidWhatsAppNumber);

    memberListPage.saveMemberDetails();

    WebElement errorElement = driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[1]/div[2]/a"));
    boolean isErrorMessageDisplayed = errorElement.isDisplayed();

    if (isErrorMessageDisplayed || !isValidFirstName || !isValidLastName || !isValidEmail || !isValidContactNumber || !isValidWhatsAppNumber) {
        System.out.println("Test Failed");
    } else {
        System.out.println("Test Passed");
    }
}
    
   @Test
    @Ignore
    public void testParking() {
        loginPage.login("sjadhav@infimatrix.com", "1234");
        homePage.navigateToParking();
        parkingPage.navigateToAddParking();

        String memberName = "Pooja lakde";
        String fastTagID ="1202121212121212";
        String vehicleType ="Two Wheeler";
        String vehicleNo="MH45TY6767";
        String vehicleColor="Black";
        String parkingNo="M-01";
        String parkingType="Open parking";

        parkingPage.fillParkingDetails(memberName, fastTagID , vehicleType ,vehicleNo ,vehicleColor ,parkingNo,parkingType);
       
        assertEquals("member Name should contain only letters", true, memberName.matches("[a-zA-Z]+"));
        assertTrue("fastTagID should be a 16-digit number", fastTagID.matches("^[1-15]\\d{15}$"));
        assertEquals("vehicleColor should contain only letters", true, vehicleColor.matches("[a-zA-Z]+"));
        parkingPage.saveParkingDetails();


    }
    @Test
    @Ignore
    public void testAddFlat() {
        loginPage.login("sjadhav@infimatrix.com", "1234");
        homePage.navigateToHouseConfig();
        addFlatPage.navigateToAddFlat();
        String memberName="Hrutik Dumal";
        String flatNo="606";
        String Wing="W-11";
        String parking="H-01";

        addFlatPage.fillflatDetails(memberName, flatNo, Wing,parking);
        assertEquals("member Name should contain only letters", true, memberName.matches("[a-zA-Z]+"));
        assertTrue("flatNo should be a 2-6digit number", flatNo.matches("^[0-5]\\d{5}$"));
        addFlatPage.saveflatDetails();
        
    }
    @Test
    @Ignore
    public void testMaintenaceBill() throws InterruptedException {
        loginPage.login("sjadhav@infimatrix.com", "1234");
        homePage.navigateToMaintenanceBill();
        maintenaceBillPage.navigateToAddMaintenanceBill();
    
        String memberName = "Hrutik Dumal";
        String flatNo = "606";
        String maintenenceCharges = "200";
        String amountDue = "200";
        String billDate = "2023-12-07";
        String dueDate = "2023-12-07";
        String billPeriod = "Monthly";
        String billNo = "123456789098";
        Thread.sleep(2000);
        String transactionId = "898989765432";
        Thread.sleep(2000);
        String billPaid = "No";
        Thread.sleep(2000);
    
        maintenaceBillPage.fillMaintenenceDetail(memberName, flatNo, maintenenceCharges, amountDue, billDate, dueDate, billPeriod, billNo, transactionId, billPaid);
    
    assertTrue("maintenenceCharges should be a 12digit number", maintenenceCharges.matches("^[0-2]\\d{2}$"));
    assertTrue("amountDue should be a 3digit number", amountDue.matches("^[0-2]\\d{2}$"));
     assertTrue("billNo should be a 12digit number", billNo.matches("^[0-11]\\d{11}$"));
     assertTrue("transactionId should be a 12digit number", transactionId.matches("^[0-11]\\d{11}$"));

     maintenaceBillPage.saveMaintenenceBillDetails();
     WebElement successElement = driver.findElement(By.xpath("//*[@id=\"kt_app_toolbar_container\"]/div/h1"));
boolean isLoginSuccessful = successElement.isDisplayed();

    }

}

        
        
        





