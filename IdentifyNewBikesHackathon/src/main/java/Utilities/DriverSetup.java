package Utilities;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.UnreachableBrowserException;

public class DriverSetup {
	
	static WebDriver driver;
	public static Properties prop;

	
	public static WebDriver getWebDriver() {
		
		try 
		{
			ReadPropertiesFile objReadPropertiesFile = new ReadPropertiesFile();
			prop =objReadPropertiesFile.readProperties();
			String browserName=prop.getProperty("browser");
			//Chrome Browser
			if (browserName.equalsIgnoreCase("Chrome")) {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
				ChromeOptions op = new ChromeOptions();
			    op.addArguments("--disable-notifications");
			    DesiredCapabilities cap=new DesiredCapabilities();
			    cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				driver = new ChromeDriver(op);
			//Firefox Browser
			} else if (browserName.equalsIgnoreCase("Mozila")) {
				System.setProperty("webdriver.gecko.driver",
						System.getProperty("user.dir") + "\\Drivers\\geckodriver.exe");
				driver = new FirefoxDriver();
			} 
			//Opera Browser
			else if(browserName.equalsIgnoreCase("opera"))											
			{
				System.setProperty("webdriver.opera.driver","Drivers\\operadriver.exe");
				//driver=new OperaDriver();
				OperaOptions op = new OperaOptions();
			    op.addArguments("--disable-notifications");
			    driver=new OperaDriver(op);
				//System.out.println("Opera browser opened");
			}
			//Edge Browser------not working ----------opening the browser but not the webpage
			else if(browserName.equalsIgnoreCase("edge"))
			{
				System.setProperty("webdriver.edge.driver","Drivers\\msedgedriver.exe");
				driver = new EdgeDriver();
			}
			else {
				System.out.println("Invalid Input");
			}			
			
		}
		catch(UnreachableBrowserException e)
		{
			System.out.println("Unable to open the browser");
		}	
		catch (NullPointerException e) 
		{
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
//		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(45));
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(45));
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();	
		return driver;
	}
	
}
