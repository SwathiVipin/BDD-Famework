package wiproassignment.gillette.Util;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;



public class TestBase {

	
	static WebDriver driver;
	static Properties prop;
	
	
	public TestBase() throws Exception{
		prop = new Properties();
		FileInputStream fis = new FileInputStream(".//src/main/java/wiproassignment/gillette/config/config.properties");
	
		prop.load(fis);
	}
	
	
	public static void  driverIntialization(){
		String browserName = prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome")){
				//System.getProperty("webdriver.chrome.driver",".//Resources/Drivers/chromedriver.exe");
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			}else if(browserName.equalsIgnoreCase("firefox")){
				//System.getProperty("webdriver.firefox.driver", ".//Resources/Drivers/geckodriver.exe");
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}else{
				//System.getProperty("webdriver.ie.driver",".//Resources/Drivers/IEDriverServer.exe");
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
			}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.pageLoadTimeout,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.implicitWait, TimeUnit.SECONDS);
	}	
}
