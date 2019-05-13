package poi;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class dynamicScreenshot {

	public static void main(String[] args) throws IOException, Exception {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\driver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://demowebshop.tricentis.com/login");
		driver.manage().window().maximize();
		
		
		
				
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, new File("C:\\abhishek\\"+AddTime()+"test.png"));
		
	//	System.out.println(driver.getTitle());
		
		driver.close();

	}

	public static String AddTime() {
		return new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss").format(new Date());
	}
	
}
