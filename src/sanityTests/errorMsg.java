package sanityTests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.google.common.base.Verify;


public class errorMsg {

	WebDriver driver = new FirefoxDriver();
	@BeforeTest
	public void sanityCheck() throws InterruptedException{


		driver.get("http://app-ezsearch.rhcloud.com/home.jsp");
		driver.manage().window().maximize();

		}

	@Test
	public void errors(){
	}

	public void closeBrowser(){
		driver.close();
	}

}
