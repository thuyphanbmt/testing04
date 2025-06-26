package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
    private static ExtentReports extent;

    public static ExtentReports createInstance() {
        String reportPath = "./reports/ExtentReport.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);
        reporter.config().setDocumentTitle("Automation Test Report");
        reporter.config().setReportName("Test Results");
        reporter.config().setTheme(com.aventstack.extentreports.reporter.configuration.Theme.STANDARD);
        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "thuyphan");
        extent.setSystemInfo("Environment", "Production");
        return extent;
    }
}
