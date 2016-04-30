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

public class UIcheck {

	WebDriver driver = new FirefoxDriver();
	@BeforeTest
	public void urlTitle() throws InterruptedException{

		driver.get("http://app-ezsearch.rhcloud.com/home.jsp");
		driver.manage().window().maximize();

		String pagetitle = driver.getTitle();
		String url = driver.getCurrentUrl();
		Assert.assertEquals(url, "http://app-ezsearch.rhcloud.com/home.jsp");
		Assert.assertEquals(pagetitle, "EzSearch");
	}

	@Test
	public void checkLinks(){

		WebElement homeBtn = driver.findElement(By.xpath(".//*[@id='menu-0']/div/div/div/div[3]/nav/div/ul/li[1]/a"));
	    WebElement aboutBtn = driver.findElement(By.xpath(".//*[@id='menu-0']/div/div/div/div[3]/nav/div/ul/li[2]/a"));
	    WebElement contactBtn = driver.findElement(By.xpath(".//*[@id='menu-0']/div/div/div/div[3]/nav/div/ul/li[3]/a"));

	    Assert.assertEquals(true, homeBtn.isDisplayed());
	    System.out.println("Home link is displayed on Homepage");
	    Assert.assertEquals(true, aboutBtn.isDisplayed());
	    System.out.println("About link is displayed on Homepage");
	    Assert.assertEquals(true, contactBtn.isDisplayed());
	    System.out.println("Contact link is displayed on Homepage");
	 }

	@Test
	public void aboutLink(){
		WebElement aboutBtn = driver.findElement(By.xpath(".//*[@id='menu-0']/div/div/div/div[3]/nav/div/ul/li[2]/a"));
		aboutBtn.click();
		String url = driver.getCurrentUrl();
		Assert.assertEquals(url, "http://app-ezsearch.rhcloud.com/about.jsp");
		System.out.println("Redirected to About Page");


	}

	@Test
	public void contactLink(){
		WebElement contactBtn = driver.findElement(By.xpath(".//*[@id='menu-0']/div/div/div/div[3]/nav/div/ul/li[3]/a"));
		contactBtn.click();
		String url = driver.getCurrentUrl();
		Assert.assertEquals(url, "http://app-ezsearch.rhcloud.com/contact.jsp");
		System.out.println("Redirected to Contact Page");
	}



	@Test
	public void textFields() throws InterruptedException{

		driver.findElement(By.name("searchterm")).sendKeys("pizza");
		driver.findElement(By.name("location")).sendKeys("sunnyvale");
		driver.findElement(By.name("limit")).sendKeys("5");
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='form1-3']/div[2]/div/div/div/div/form/div[4]/button")).click();

		Thread.sleep(3000);
	}

	@Test
	public void searchResults(){
		WebElement homeBtn = driver.findElement(By.xpath(".//*[@id='menu-0']/div/div/div/div[3]/nav/div/ul/li[1]/a"));
	    WebElement aboutBtn = driver.findElement(By.xpath(".//*[@id='menu-0']/div/div/div/div[3]/nav/div/ul/li[2]/a"));
	    WebElement contactBtn = driver.findElement(By.xpath(".//*[@id='menu-0']/div/div/div/div[3]/nav/div/ul/li[3]/a"));

	    Assert.assertEquals(true, homeBtn.isDisplayed());
	    System.out.println("Home link is displayed on Search Results Page");
	    Assert.assertEquals(true, aboutBtn.isDisplayed());
	    System.out.println("About link is displayed on Search Results Page");
	    Assert.assertEquals(true, contactBtn.isDisplayed());
	    System.out.println("Contact link is displayed on Search Results Page");
	}

	@AfterClass
	public void closeBrowser(){
		driver.close();
	}

}
