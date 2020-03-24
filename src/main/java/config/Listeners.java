package config;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;


public class Listeners extends TestListenerAdapter {

    public ExtentHtmlReporter htmlReporter;
    public ExtentReports extent;
    public ExtentTest test;

    public void onStart(ITestContext testContext) {
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "myOut.html");
        htmlReporter.config().setDocumentTitle("Auto Report");
        htmlReporter.config().setReportName("Rest Api Test");
        htmlReporter.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Host Name", "localhost");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("user", "admin");

    }

    public void onTestSuccess(ITestResult tr) {
        test = extent.createTest(tr.getName());
        test.log(Status.PASS, "Test passed" + tr.getName());
    }

    public void onTestFailure(ITestResult fr) {
        test = extent.createTest(fr.getName());
        test.log(Status.FAIL, "Test Case Failed" + fr.getName());
        test.log(Status.FAIL, "Test case error" + fr.getThrowable());
    }

    public void onTestSkipped(ITestResult rr) {
        test = extent.createTest(rr.getName());
        test.log(Status.SKIP, "test skipped" + rr.getName());
    }

    public void onFinish(ITestContext fi) {
        extent.flush();
    }


}

