package listeners;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestListener;
import scripts.BaseTest;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class SimpleListener implements ITestListener {
    public void onTestStart(org.testng.ITestResult result) {
        /* compiled code */ }
    public void onTestSuccess(org.testng.ITestResult result) { /* compiled code
     */ }
    public void onTestFailure(org.testng.ITestResult result) {
        System.out.println("Screenshot captured for test case: " + result.getName());

        Object currentClass = result.getInstance();
        WebDriver driver = ((BaseTest) currentClass).getDriver();

        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            Date date = new Date();
           String filePath = "." + File.separator + "screenshots" + File.separator + result.getName() +"_"+date.getTime()+ ".png";

           // tao thu muc neu thu muc chua ton tai
           File destFile = new File(filePath);
            destFile.getParentFile().mkdirs();
            //mkdirs() tạo thu muc cha screenshots/ neu chua co

            FileHandler.copy(srcFile, destFile);
            System.out.println("Screenshot saved: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //test

    }
    public void onTestSkipped(org.testng.ITestResult result) { /* compiled code */
    }
    public void onTestFailedButWithinSuccessPercentage(org.testng.ITestResult
                                                               result) { /* compiled code */ }
    public void onTestFailedWithTimeout(org.testng.ITestResult result) { /*
compiled code */ }
    public void onStart(org.testng.ITestContext context) { /* compiled code */ }
    public void onFinish(org.testng.ITestContext context) { /* compiled code */ }
}
