package WrapperClasses;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager {
    private static ExtentReports extent;
    private static ExtentSparkReporter sparkReporter;
    private static ExtentTest test;

    // Method to initialize the report
    public static void initReport(String reportFilePath) {
        sparkReporter = new ExtentSparkReporter(reportFilePath);
        sparkReporter.config().setDocumentTitle("Automation Report");
        sparkReporter.config().setReportName("Functional Testing");
        sparkReporter.config().setTheme(Theme.STANDARD);

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
    }

    // Method to start logging test cases
    public static void startTest(String testName) {
        test = extent.createTest(testName);
    }

    // Method to log test pass
    public static void logPass(String details) {
        test.pass(details);
    }

    // Method to log test failure
    public static void logFail(String details) {
        test.fail(details);
    }

    // Method to log test information
    public static void logInfo(String details) {
        test.info(details);
    }

    // Method to flush and save the report
    public static void closeReport() {
        if (extent != null) {
            extent.flush();
        }
    }
}
