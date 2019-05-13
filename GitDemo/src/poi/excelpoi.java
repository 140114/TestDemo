package poi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class excelpoi {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\driver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://demowebshop.tricentis.com/login");
		driver.findElement(By.name("Email")).sendKeys("test1001@test.com");
		driver.findElement(By.name("Password")).sendKeys("test12");
		driver.findElement(By.className("login-button")).click();
		
	}

}
																