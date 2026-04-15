package listeners;

import base.BaseTest;
import com.aventstack.extentreports.*;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utilities.ExtentManager;
import utilities.ScreenshotUtil;

public class TestListener implements ITestListener {

    ExtentReports extent = ExtentManager.getInstance();

    // ThreadLocal for parallel execution
    public static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest extentTest = extent.createTest(result.getName());
        test.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.get().pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        test.get().fail(result.getThrowable());

        // Handle screenshot only if driver exists (UI test)
        try {
            String path = ScreenshotUtil.captureScreenshot(
                    BaseTest.getDriver(),
                    result.getName()
            );
            test.get().addScreenCaptureFromPath(path);
        } catch (Exception e) {
            test.get().info("Screenshot not available (API Test)");
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }

    // Getter method (VERY IMPORTANT)
    public static ExtentTest getTest() {
        return test.get();
    }
}