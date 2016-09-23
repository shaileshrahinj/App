package amazon;
import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeSuite;

import amazon.ExcelReader;
import amazon.Constant;

public class StartApp {
	 private static AndroidDriver driver;
	 @BeforeSuite
			public static void Essential() throws MalformedURLException, InterruptedException {
				try {
				File classpathRoot = new File(System.getProperty("user.dir"));
				File appDir = new File(classpathRoot, "/Apps/Amazon/");
				File app = new File(appDir, "in.amazon.mShop.android.shopping-1.apk");
			
				DesiredCapabilities capabilities = new DesiredCapabilities();
				capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
				capabilities.setCapability("deviceName", "HTC ONE_M8");
				capabilities.setCapability("platformVersion", "4.4.2");
				capabilities.setCapability("platformName", "Android");
				capabilities.setCapability("app", app.getAbsolutePath());
				capabilities.setCapability("appPackage", "in.amazon.mShop.android.shopping");
				capabilities.setCapability("appActivity", "com.amazon.mShop.home.HomeActivity");
	 
				driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
				driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
				//click on skip sign in
				//driver.findElementByName("Skip sign in").click();
				
				} catch (Exception e) {
					throw (e);
				}
	 }
	 
	 @Test
	 public static void login() throws Exception{
		 ExcelReader obj =new ExcelReader();
			obj.setExcelFile(Constant.Path_TestData,"Sheet1");
			//Cell.setCellType(Cell.CELL_TYPE_STRING);
			String susername = ExcelReader.getCellData(1,1);
			System.out.println(susername);
			 		String spassword =ExcelReader.getCellData(1,2);
			 		System.out.println(spassword);
			 		
			 //Finding the menu
			 		driver.findElementById("in.amazon.mShop.android.shopping:id/action_bar_burger_icon").click();
			 		//clicking on sign in
			 		driver.findElementById("in.amazon.mShop.android.shopping:id/action_bar_home_logo").click();
			 		//Indentify the uname field
			 		driver.findElement(By.xpath("//android.view.View[@content-desc='Email (phone for mobile accounts)']")).sendKeys("susername");
			 		driver.findElement(By.xpath("//android.view.View[@content-desc='Amazon password']")).sendKeys("spassword");
			 	//WebElement epassword = driver.findElementByName("Email (phone for mobile accounts)");
			  //epassword.sendKeys("susername");
		 		
	 }
	 
}














































				
				
				
				
				
				/*
			//Click on shop by category
				driver.findElement(By.id("in.amazon.mShop.android.shopping:id/web_home_shop_by_department_label")).click();
				
				//Click on Menu button using By.ClassName to display the menu list.
				driver.findElement(By.className("android.widget.ImageView")).click();
				
				driver.swipe(0, 608, 0,990,3000);
				driver.swipe(0, 990, 0,1100,3000);
				driver.findElement(By.name("Hello. Sign In")).click();


driver.findElementByName("Sign inHello. Link").click();

driver.findElementByName("Sign inHello. Link").click();
				
				//5.Click on Home link using By.Name to navigate back to the Home Screen.
				driver.findElement(By.name("Home")).click();
				driver.swipe(75, 500, 75, 0, (int) 0.8);
				//Click on Menu button using By.ClassName to display the menu list.
				driver.findElement(By.className("android.widget.ImageView")).click();
				
				driver.swipe(75, 500, 75, 0, 2);
				JavascriptExecutor js = (JavascriptExecutor) driver;
				HashMap<String, String> scrollObject = new HashMap<String, String>();
				scrollObject.put("direction", "down");
				js.executeScript("mobile: scroll", scrollObject);
				//6) Click on the SIgn In link using By.Name to Log In in to the application.
				driver.swipe(1211, 626, 0,0,100);
				//driver.findElement(By.name("Hello. Sign In")).click();
				
				
				//7) Enter text in the UserName field using By.xpath & Sibling strategy
				
				Thread.sleep(3000);
				driver.quit();
	 
		}
	 
	}


*/