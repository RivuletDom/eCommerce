package mvn.automation.eCommerce;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class productSearch extends Base {

	WebDriver driver;
	WebDriverWait wait;

	@Test
	public void search() throws Throwable {

		driver = drivercall();

		test = extent.createTest("Check Product Search Functionality");

		Actions actions = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		WebElement womenTab = driver.findElement(By.linkText("WOMEN"));

		test.log(Status.PASS, "WOMEN tab clicked successfully");

		WebElement TshirtTab = driver
				.findElement(By.xpath("//div[@id='block_top_menu']/ul/li[1]/ul/li[1]/ul//a[@title='T-shirts']"));
		actions.moveToElement(womenTab).moveToElement(TshirtTab).click().perform();
		Thread.sleep(2000);

		// Get Product Name
		String ProductName = driver
				.findElement(By.xpath(
						"/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[2]/ul[1]/li[1]/div[1]/div[2]/h5[1]/a[1]"))
				.getText();
		System.out.println(ProductName);

		driver.findElement(By.id("search_query_top")).sendKeys(ProductName);

		test.log(Status.PASS, "Search by Product name successfully -" + ProductName);

		driver.findElement(By.name("submit_search")).click();

		// Get Name of Searched Product
		String SearchResultProductname = driver
				.findElement(By.xpath(
						"/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[2]/ul[1]/li[1]/div[1]/div[2]/h5[1]/a[1]"))
				.getText();

		// Verify that correct Product is displaying after search
		if (ProductName.equalsIgnoreCase(SearchResultProductname)) {
			System.out.println("Results Matched;Test Case Passed");
			test.log(Status.PASS, "Results Matched;Test Case Passed");

		} else {
			System.out.println("Results NotMatched;Test Case Failed");
			test.log(Status.FAIL, "Results NotMatched;Test Case Failed");

		}

	}

}
