package poi;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NewTest {
	 WebDriver driver;
	
	@Test
  public void f() {
	  	
		driver.findElement(By.name("Email")).sendKeys("test1001@test.com");
		driver.findElement(By.name("Password")).sendKeys("test12");
		driver.findElement(By.className("login-button")).click();
  }
  
	 @BeforeMethod
	  public void beforeMethod() {
		 System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\driver\\chromedriver.exe");
		 driver=new ChromeDriver();
		 
			
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);	
			driver.get("http://demowebshop.tricentis.com/login");
	  }
	
  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
