package runner;

import com.cucumber.listener.ExtentProperties;
import cucumber.api.CucumberOptions;
import com.cucumber.listener.Reporter;
import cucumber.api.junit.Cucumber;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import java.text.SimpleDateFormat;
import java.util.Date;

@RunWith(Cucumber.class)
@CucumberOptions(format = {"pretty", "html:target/screenshot",
        "json:target/cucumber-report.json",
        "com.cucumber.listener.ExtentCucumberFormatter:"},
        glue = {"definition"},
        features = "./src/test/feature/")
public class Test {


    public static String timestamp;
    public static String reportPath;
    @BeforeClass
    public static void setup() {
        String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
        ExtentProperties extentProperties = ExtentProperties.INSTANCE;
        reportPath = "target/cucumber-reports/TestReport_"+timestamp;
        extentProperties.setReportPath(reportPath+"/RecipeAppTestAutomationReport_"+timestamp+".html");
        System.out.println("Setting report generation Path: "+extentProperties.getReportPath());
    }
    @AfterClass
    public static void writeExtentReport() {
        Reporter.loadXMLConfig("src/test/resources/extent-config.xml");
        Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
        Reporter.setTestRunnerOutput("Sample test runner output message");
    }
}
