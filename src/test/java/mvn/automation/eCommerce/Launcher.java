package mvn.automation.eCommerce;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

public class Launcher {

	WebDriver driver;

	public void openBrowser() {

		// System property for Chrome driver
		System.setProperty("webdriver.chrome.driver", "src/main/java/resources/chromedriver");

		// Instantiate a ChromeDriver class
		driver = new ChromeDriver();
		return;
	}

	public void openStore() throws Throwable {

		// redirect on specific website
		driver.navigate().to("http://automationpractice.com/");
		driver.manage().window().maximize();
	}

	public void closeBrowser() {

		driver.close();
	}

}
