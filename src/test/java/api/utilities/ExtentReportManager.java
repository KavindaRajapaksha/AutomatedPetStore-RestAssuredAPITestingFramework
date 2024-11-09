package api.utilities;

import java.text.SimpleDateFormat;

import java.util.Date;  
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener {
	public ExtentSparkReporter sparkReporter;
    public ExtentReports extent;
    public ExtentTest test;

    String repName;

    public void onStart(ITestContext testContext) {
        // Generating timestamp for unique report name
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        repName = "Test-Report-" + timeStamp + ".html";
        
        // Setting up SparkReporter with the report location
        sparkReporter = new ExtentSparkReporter(".\\reports\\" + repName);
        
        // Configuring report title, name, and theme
        sparkReporter.config().setDocumentTitle("RestAssuredAutomationProject");
        sparkReporter.config().setReportName("Pet Store Users API");
        sparkReporter.config().setTheme(Theme.DARK); // Set theme to DARK

        // Attaching SparkReporter to ExtentReports
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        
        // Adding system information to the report
        extent.setSystemInfo("Application", "Pet Store Users API");
        extent.setSystemInfo("Operating System", System.getProperty("os.name"));
        extent.setSystemInfo("User Name", System.getProperty("user.name"));
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("user", "Kavinda Rajapaksha");
    }
    public void onTestSuccess(ITestResult result) {
        // Create test entry in report
        test = extent.createTest(result.getName());
        test.assignCategory(result.getMethod().getGroups());
        
        // Log test node and status
        test.createNode(result.getName());
        test.log(Status.PASS, "Test Passed");
    }

    public void onTestFailure(ITestResult result) {
        // Create test entry in report
        test = extent.createTest(result.getName());
        test.assignCategory(result.getMethod().getGroups());
        
        // Log test node and failure details
        test.createNode(result.getName());
        test.log(Status.FAIL, "Test Failed");
        test.log(Status.FAIL, result.getThrowable().getMessage());
    }

    public void onTestSkipped(ITestResult result) {
        // Create test entry in report
        test = extent.createTest(result.getName());
        test.assignCategory(result.getMethod().getGroups());
        
        // Log test node and skip details
        test.createNode(result.getName());
        test.log(Status.SKIP, "Test Skipped");
        test.log(Status.SKIP, result.getThrowable().getMessage());
    }

    public void onFinish(ITestContext testContext) {
        // Flush the report to save the results
        extent.flush();
    }
}
