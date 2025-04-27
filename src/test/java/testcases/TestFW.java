package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import utilities.ReadXLSData;

public class TestFW extends BaseTest{
	
	@Test(dataProviderClass=ReadXLSData.class,dataProvider="testingdata")
	public static void LoginTest(String username, String password) throws InterruptedException
	{
		driver.findElement(By.linkText(loc.getProperty("signin_link"))).click();
		//System.out.println("passed");
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//      wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login_id")));
		Thread.sleep(3000);
		driver.findElement(By.id(loc.getProperty("email_field"))).sendKeys(username);
		//System.out.println("passed");
		driver.findElement(By.xpath(loc.getProperty("next_button"))).click();
		Thread.sleep(3000);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='password']")));
		driver.findElement(By.xpath(loc.getProperty("pwd_field"))).sendKeys(password);
		Thread.sleep(3000);
		driver.findElement(By.xpath(loc.getProperty("login_next_button"))).click();
		Thread.sleep(8000);
		
	}
	
//Data driven way
//	@DataProvider(name="testdata")
//	public Object[][] tData()
//	{
//		return new Object[][] {
//			{"s.amasha0604@gmail.com","Amasha10203040"},
//			{"s.amasha@gmail.com","Amasha40"},
//			{"s.amasha060@gmail.com","Amasha102040"},
//			{"s.amash604@gmail.com","Amasha3040"}
//		};
//	}
}
