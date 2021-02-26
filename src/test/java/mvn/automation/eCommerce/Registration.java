package mvn.automation.eCommerce;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class Registration extends Base {

	@Test
	public void Signup_in_Website() throws Throwable {

		driver = drivercall();
		test = extent.createTest("Check Registration Functionality");

		// Click on Sign in
		driver.findElement(By.linkText("Sign in")).click();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		test.log(Status.INFO, "URL : " + (prop.getProperty("URL")));
		// Enter email address
		driver.findElement(By.cssSelector("[name='email_create']")).sendKeys("dominicautomationtest@gmail.com");

		// Click on "Create an account"
		driver.findElement(By.xpath("//button[@name=\"SubmitCreate\"]")).click();
		Thread.sleep(3000);
		// Select Title

		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//*[@id=\"account-creation_form\"]/div[1]/div[1]/div[1]/label")));
		driver.findElement(By.xpath("//*[@id=\"account-creation_form\"]/div[1]/div[1]/div[1]/label")).click();
		driver.findElement(By.name("customer_firstname")).sendKeys("Dominic");
		driver.findElement(By.name("customer_lastname")).sendKeys("Tarang");
		driver.findElement(By.id("passwd")).sendKeys("Dom@123");

		// Enter your address
		driver.findElement(By.id("firstname")).sendKeys("Test User");
		driver.findElement(By.id("lastname")).sendKeys("Vsoft");
		driver.findElement(By.id("company")).sendKeys("Vsoft");
		driver.findElement(By.id("address1")).sendKeys("Test 81/1,2nd cross");
		driver.findElement(By.id("city")).sendKeys("XYZ");

		// Select State
		WebElement statedropdown = driver.findElement(By.name("id_state"));
		Select oSelect = new Select(statedropdown);
		oSelect.selectByValue("4");

		driver.findElement(By.name("postcode")).sendKeys("51838");

		// Select Country
		WebElement countrydropDown = driver.findElement(By.name("id_country"));
		Select oSelectC = new Select(countrydropDown);
		oSelectC.selectByVisibleText("United States");

		// Enter Mobile Number
		driver.findElement(By.id("phone_mobile")).sendKeys("234567890");
		driver.findElement(By.xpath("//input[@name=\"alias\"]")).clear();
		driver.findElement(By.xpath("//input[@name=\"alias\"]")).sendKeys("Office");
		driver.findElement(By.name("submitAccount")).click();
		String userText = driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).getText();

		// Validate that user has created
		if (userText.contains("Dominic Tarang")) {
			System.out.println("User Verified,Test case Passed");
		} else {
			System.out.println("User Verification Failed,Test case Failed");
		}
		
		test.log(Status.PASS, "Home Page Redirection Successful");

	}
}
