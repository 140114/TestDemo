package poi;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class keywordDriven {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		FileInputStream fi = new FileInputStream(System.getProperty("user.dir")+"\\src\\properties\\keyDriven.properties");
		Properties p = new Properties();
		p.load(fi);

		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\driver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get(p.getProperty("url"));
		driver.findElement(By.id(p.getProperty("un"))).sendKeys(p.getProperty("keyun"));
		driver.findElement(By.id(p.getProperty("pwd"))).sendKeys(p.getProperty("keypwd"));
		driver.findElement(By.className(p.getProperty("login"))).click();
		
		
		
		//driver.findElement(By.className(p.getProperty("login"))).click();
		
		String filePath;
		System.out.println("Enter the file path in this format -C:\\abhishek\\test.png");
		
		
		  // for getting file path from user where screenshot needs to be copied
		Scanner sc = new Scanner(System.in);
		filePath = sc.next();
		
		// for taking screenshot
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(filePath));
		
		System.out.println(driver.getTitle());
		
		driver.close();
		
	}

}
