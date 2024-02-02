package configurations;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import PagesForSwag.LoginPageee;
import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseClassForSwag {
	
	
	
	 configr cr = new configr() ;
	 public  String BaseURL=cr.getURL();
	 public String Username=cr.getName();
	 public String Passw=cr.getpass();
	 public String Broswer=cr.getbroswer();
	 public static WebDriver driver;

	      public static Logger logger;
	      @Parameters("Broswer")
           @BeforeTest	
    	   public void broswerintilize(String Broswer) {
	    	  logger=Logger.getLogger("SwagLabs");
	    	  PropertyConfigurator.configure("Log4j.Properties");
    	   
			if(Broswer.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
			}
			else if(Broswer.equals("edge")) {
				WebDriverManager.edgedriver().setup();
				driver= new EdgeDriver();
			}
			//driver.get("https://www.saucedemo.com/");
			driver.get(BaseURL);
			logger.info("URL is Opened");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    	   }
	 @BeforeTest
	 public LoginPageee broswer_initil() throws FileNotFoundException, InterruptedException {
//		    WebDriverManager.firefoxdriver().setup();
//      		driver= new FirefoxDriver();
//			driver.get(BaseURL);
//			driver.manage().window().maximize();
//			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			LoginPageee lp=new LoginPageee(driver);
			//lp.loginPage("Uname", "Pass");
      		//lp.loginPage("standard_user", "secret_sauce");
			return lp;
			
			
		}
		@AfterTest
		public void TearDown() {
			driver.close();
		}
		
		
		public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {
			
			TakesScreenshot ts = (TakesScreenshot)driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			File file = new File (System.getProperty("user.dir")+"//Screenshots//"+testCaseName+".png");
			FileUtils.copyFile(source, file);
			return System.getProperty("user.dir")+"//Screenshots//" + testCaseName+ ".png";


	}
}



