package mvn.automation.eCommerce;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Protocol;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Base {

	static WebDriver driver;
	WebDriverWait wait;
	protected Properties prop = new Properties();

	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;

	public int WebDriverWaitTimeout = 300;
	public static boolean AssertEnable = false;

	public WebDriver drivercall() {
		System.setProperty("webdriver.chrome.driver", "src/main/java/resources/chromedriver");

		ChromeOptions options = new ChromeOptions();
		// options.addArguments("headless");
		options.addArguments("disable-gpu");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.navigate().to("http://automationpractice.com/");

		test = extent.createTest("Site Launch");
		test.log(Status.PASS, "Launched success");

		wait = new WebDriverWait(driver, 100);
		wait = new WebDriverWait(driver, WebDriverWaitTimeout);

		return driver;

	}

	@BeforeSuite
	public void before() throws Throwable {

		/*
		 * this method explains to generate extent report into HTML form to initialise
		 * this report, first import dependency into POM.XML file and then initialise
		 * its function to execute report, first of all need to mention testscenario.
		 * 
		 * Test scenario can be added by adding its property as in this project, I have
		 * user "Test" - check line 27 in base.java
		 * 
		 * now, add testscenario into html report like line 43 in base.java and, add its
		 * status testcase likewise added into line 44. you can use status condition
		 * base into IF-ELSE condition.
		 * 
		 */

//		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "\\ExtentReports\\Automation_Report_" + dateFormat.format(new Date()) + ".html");
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/ExtentReports/ecom.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
//		htmlReporter.loadXMLConfig(".resources/extent-config.xml");

		
		// this below set of lines are configuration for html report.
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setJS("js-string");
		htmlReporter.config().setProtocol(Protocol.HTTPS);

		htmlReporter.config().setReportName("Tarang | Automation Report");
		htmlReporter.config().setDocumentTitle("Extent-Automation Report");
		htmlReporter.config().setTheme(Theme.DARK);

		htmlReporter.config().setCSS(
				"body > nav > div > a > img { content:url('http://tarangchokshi.in/assets/img/apple-touch-icon.png') }");
		System.out.println("report being generated");
	}

	@AfterSuite
	public void flush() {
		System.out.println("report generated");

		extent.flush();
		driver.close();
	}

}
