package hms.testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import hms.commonutility.Acitivitycapture;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Testbase {

	public static WebDriver driver;
	public static Properties prop;
	public static Acitivitycapture actvit;
	public static EventFiringWebDriver eve;
	
	public Testbase() 
	{
		prop=new Properties();
		
		FileInputStream ipconfig;
		try {
			
			ipconfig = new FileInputStream("./src/main/java/hms/config/appconfig.properties");
			prop.load(ipconfig);
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	}
	
	public static void initilization()
	{
		String br=prop.getProperty("BROWSER");
		if(br.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			if(prop.getProperty("HEADLESS").equals("true"))
			{
				ChromeOptions opt=new ChromeOptions();
				opt.addArguments("--headless");
				driver=new ChromeDriver(opt);
			}else
			{
				
				driver=new ChromeDriver();
			}
		}
		else if(br.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}else if(br.equals("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}else
		{
			System.out.println("Plz check your browsername");
		}
		
		//Eventlisteners script
		 actvit=new Acitivitycapture();
		 eve=new EventFiringWebDriver(driver);
		 eve.register(actvit);
		 driver=eve;
		
		//basic methods
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(90));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("URL"));
		
		
		
		
	}
	
	public static void waitforelement(WebElement el)
	{
		WebDriverWait wt=new WebDriverWait(driver, Duration.ofSeconds(40));
		wt.until(ExpectedConditions.visibilityOf(el));
	}
	
	
	
	
	
	
	
	
}
