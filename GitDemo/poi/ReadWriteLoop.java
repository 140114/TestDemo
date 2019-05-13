
  
  package poi;
	
  import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

  import org.apache.poi.xssf.usermodel.XSSFSheet;
  import org.apache.poi.xssf.usermodel.XSSFWorkbook;
  import org.openqa.selenium.By;
  import org.openqa.selenium.WebDriver;
  import org.openqa.selenium.chrome.ChromeDriver;
  import org.testng.annotations.AfterMethod;
  import org.testng.annotations.AfterTest;
  import org.testng.annotations.BeforeMethod;
  import org.testng.annotations.BeforeTest;
  import org.testng.annotations.Test;

public class ReadWriteLoop { 
  	 		
  		 WebDriver driver;
  		 
  		 FileInputStream FRead;
  		 FileOutputStream FWrite;
  		 
  		 XSSFWorkbook wb;
  		 XSSFSheet sh;
  		 
  		 String d1, d2;
  		 
  		 String login;
  		 String pwd;
  		 String wbmsg;
  		 String xlmsg;
  		 String pass="Test is Passed";
  		 String fail="Test is Failed";
  		 	 
  		 int rowval;
  		 int rowcount;
  		 
  	  @Test
  	  public void ReadWriteExcel() throws InterruptedException, IOException{
  		 
  		  
  		  for(rowval=1;rowval<rowcount;rowval++)
  		  {
  			  login= sh.getRow(rowval).getCell(0).getStringCellValue();
  	  		  pwd= sh.getRow(rowval).getCell(1).getStringCellValue();
  	  		  xlmsg =sh.getRow(rowval).getCell(2).getStringCellValue(); ;
  			  
  		    driver.get("http://demowebshop.tricentis.com/");
  		  
  			Thread.sleep(2000);
  			driver.findElement(By.linkText("Log in")).click();
  			Thread.sleep(2000);
  			driver.findElement(By.name("Email")).sendKeys(login);
  			Thread.sleep(2000);
  			driver.findElement(By.name("Password")).sendKeys(pwd);
  			driver.findElement(By.className("login-button")).click();
  			wbmsg= driver.findElement(By.cssSelector("a.account")).getText();
  			System.out.println(wbmsg);
  			System.out.println("");
  			System.out.println("");
  			System.out.println("Login id used is "+login);
  			System.out.println("Password used is "+pwd);
  			System.out.println("The user name is "+wbmsg);
  			
  			
  		  driver.findElement(By.linkText("Log out")).click();
  		  Thread.sleep(2000);
  		  
  		//  FWrite= new FileOutputStream(System.getProperty("user.dir")+"\\src\\file\\ReadWrite.xlsx");
  		  FWrite= new FileOutputStream(System.getProperty("user.dir")+"\\src\\file\\NewReadWrite.xlsx");
  		  sh.getRow(rowval).createCell(3).setCellValue(wbmsg);
  		  
  		  if(wbmsg.equals(xlmsg))
  		  {
  			  System.out.println(pass);
  			  sh.getRow(rowval).createCell(4).setCellValue(pass);
  		  }
  		  else
  		  {
  			  System.out.println(fail);
  			  sh.getRow(rowval).createCell(4).setCellValue(fail);
  		  }
  		  wb.write(FWrite);
  			
  		  }
  			
  	  }
  	  @BeforeTest
  	  public void beforeTest() throws Exception{
  		  System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\driver\\chromedriver.exe");
  			 driver=new ChromeDriver();
  			
  			/*File*/	FRead= new FileInputStream(System.getProperty("user.dir")+"\\src\\file\\ReadWrite.xlsx");
  			
  			
  			 
  			 /*XSSFWorkbook*/		wb = new XSSFWorkbook(FRead);
  			 /*XSSFSheet*/			sh = wb.getSheetAt(0);
  			 /*String*/				d1= sh.getRow(0).getCell(0).getStringCellValue();
  			 /*String*/				d2= sh.getRow(0).getCell(1).getStringCellValue();
  				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);	
  				rowcount = sh.getPhysicalNumberOfRows();
  				
  		  
  	  }
  	  @BeforeMethod
  	  public void beforeMethod() {
  		 // login= sh.getRow(1).getCell(0).getStringCellValue();
  		//  pwd= sh.getRow(1).getCell(1).getStringCellValue();
  		 // xlmsg =sh.getRow(1).getCell(2).getStringCellValue(); ;
  	  }

  	  @AfterMethod
  /*	  public void afterMethod()throws Exception {
  		  driver.findElement(By.linkText("Log out")).click();
  		  Thread.sleep(2000);
  		  
  		//  FWrite= new FileOutputStream(System.getProperty("user.dir")+"\\src\\file\\ReadWrite.xlsx");
  		  FWrite= new FileOutputStream(System.getProperty("user.dir")+"\\src\\file\\NewReadWrite.xlsx");
  		  sh.getRow(rowval).createCell(3).setCellValue(wbmsg);
  		  
  		  if(wbmsg.equals(xlmsg))
  		  {
  			  System.out.println(pass);
  			  sh.getRow(rowval).createCell(4).setCellValue(pass);
  		  }
  		  else
  		  {
  			  System.out.println(fail);
  			  sh.getRow(rowval).createCell(4).setCellValue(fail);
  		  }
  		  wb.write(FWrite);
  		   }*/
  	 

  	  @AfterTest
  	  public void afterTest() throws Exception{
  		  Thread.sleep(2000);
  		  driver.close();
  		  wb.close();
  	  }
  	  
  	  
  	  
  	  
  	}
