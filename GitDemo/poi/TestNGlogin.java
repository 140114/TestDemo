package poi;

import java.util.concurrent.TimeUnit;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class TestNGlogin {
	WebDriver driver=new ChromeDriver();
	@BeforeClass
	 public void setUp() {
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\driver\\chromedriver.exe");
		 driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);	
	}
	
	 @Test()
	 public void aFastTest() {
		 	driver.get("http://demowebshop.tricentis.com/login");
			driver.findElement(By.name("Email")).sendKeys("test1001@test.com");
			driver.findElement(By.name("Password")).sendKeys("test12");
			driver.findElement(By.className("login-button")).click();
	 }
	 @AfterMethod
	  public void afterMethod() {
		  driver.quit();
	  }
}
