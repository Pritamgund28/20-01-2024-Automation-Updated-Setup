package com.infimatrix.utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
public class ScreenshotUtil {
    public static void captureScreenshot(WebDriver driver, String screenshotName, boolean isFailure) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
            String timestamp = dateFormat.format(new Date());
            String status = isFailure ? "Failure" : "Success";
            String screenshotPath = "C:\\Users\\baji3220\\OneDrive\\Desktop\\gitVP\\one_nest\\src\\main\\java\\com\\infimatrix\\ScreenShots\\image.png";

            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Path destinationPath = Paths.get(screenshotPath, screenshotName + "_" + status + "_" + timestamp + ".png");
            Files.createDirectories(destinationPath.getParent());
            Files.move(screenshotFile.toPath(), destinationPath);
            System.out.println("Screenshot saved: " + destinationPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static String getScreenshotPath(WebDriver driver, String screenshotName, boolean isFailure) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);

        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String status = isFailure ? "Failure" : "Success";

        String screenshotPath = "C:\\Users\\baji3220\\OneDrive\\Desktop\\gitVP\\one_nest\\src\\main\\java\\com\\infimatrix\\ScreenShots";
        String destinationPath = screenshotPath + "\\" + screenshotName + "_" + status + "_" + timestamp + ".png"; // Use backslashes for Windows

        File destination = new File(destinationPath);

        try {
            Files.copy(source.toPath(), destination.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return destinationPath;
    }

    public static void captureScreenshot(WebDriver driver, String methodName) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'captureScreenshot'");
    }
}
