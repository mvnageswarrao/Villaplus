package com.vp.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseUtils {

	public static WebDriver driver = null;
	public static String path = System.getProperty("user.dir");
	
	public static WebDriver initBrowser(String browserType, String appURL) throws IOException{
	
	if(browserType.equalsIgnoreCase("chrome")) 
	{
		try
		{initChromeDriver(appURL);}
		catch(Exception e)
		{System.out.println(e.getMessage());}
	}	
	else if(browserType.equalsIgnoreCase("firefox"))
	{
		try
		{initFirefoxDriver(appURL);}
		catch(Exception e)
		{System.out.println(e.getMessage());}
	}	
	else if(browserType.equalsIgnoreCase("edge"))
	{
		try
		{initEdgeDriver(appURL);}
		catch(Exception e)
		{System.out.println(e.getMessage());}
	}	
	else if(browserType.equalsIgnoreCase("ie"))
	{
		try
		{initIEDriver(appURL);}
		catch(Exception e)
		{System.out.println(e.getMessage());}	
	}
	else if(browserType.equalsIgnoreCase("browserstack"))
	{
		try
		{initBrowserStack(appURL);}
		catch(Exception e)
		{System.out.println(e.getMessage());}	
	}
	
	return driver;
}
	
	@SuppressWarnings("deprecation")
	private static WebDriver initChromeDriver(String appURL) {
		System.out.println("Launching google chrome..");
		System.setProperty("webdriver.chrome.driver", path + "\\BrowserDrivers\\chromedriver.exe");
		DesiredCapabilities ChromeCapabilities = DesiredCapabilities.chrome();
		driver = new ChromeDriver(ChromeCapabilities);
		ChromeCapabilities.setCapability("marionette", true);
		driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.navigate().to(appURL);
		
		return driver;
	}
		@SuppressWarnings("deprecation")
	private static WebDriver initFirefoxDriver(String appURL) {
		System.out.println("Launching Firefox browser..");
		System.setProperty("webdriver.gecko.driver", path + "\\BrowserDrivers\\geckodriver.exe");
		DesiredCapabilities FFCapabilities = DesiredCapabilities.firefox();
		FFCapabilities.setCapability("marionette", true);
		driver = new FirefoxDriver(FFCapabilities);	
		driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.navigate().to(appURL);
	
		return driver;
	}
		@SuppressWarnings("deprecation")
	private static WebDriver initProxyDriver() {
		System.out.println("Launching Proxy..");
		String PROXY = "http://172.16.0.3:4701";
		//http://172.16.0.3:4701/api/authenticate/?BookingReference:103003E&CustomerLastName:test 
		org.openqa.selenium.Proxy proxy = new org.openqa.selenium.Proxy();
		proxy.setHttpProxy(PROXY)
		.setFtpProxy(PROXY)
		.setSslProxy(PROXY);
		
		DesiredCapabilities ProxyCapabilities = new DesiredCapabilities();
		ProxyCapabilities.setCapability(CapabilityType.PROXY,proxy);
		driver = new FirefoxDriver(ProxyCapabilities);	
		driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
		return driver;
	}

		@SuppressWarnings("deprecation")
	private static WebDriver initEdgeDriver(String appURL) {
		System.out.println("Launching Edge browser..");
		System.setProperty("webdriver.ie.driver", path + "\\BrowserDrivers\\MicrosoftWebDriver.exe");
		//System.setProperty("webdriver.edge.driver", "C:\\Veera-Backup\\Selinium\\Selenium Jars\\EdgeDriver64\\MicrosoftWebDriver.exe");
		DesiredCapabilities EdgeCapabilities = DesiredCapabilities.edge();
		driver = new EdgeDriver(EdgeCapabilities);
		EdgeCapabilities.setCapability("marionette", true);
		driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.navigate().to(appURL);
	
		return driver;
	}
	@SuppressWarnings("deprecation")
	private static WebDriver initIEDriver(String appURL) {
		System.out.println("Launching IE browser..");
		System.setProperty("webdriver.edge.driver", path + "\\BrowserDrivers\\IEDriverServer.exe");
		//System.setProperty("webdriver.ie.driver", "C:\\Veera-Backup\\Selinium\\Selenium Jars\\IEdriverserverWin64\\IEDriverServer.exe");
		DesiredCapabilities IEcapabilities = DesiredCapabilities.internetExplorer();
		driver = new InternetExplorerDriver(IEcapabilities);
		IEcapabilities.setCapability("marionette", true);
		IEcapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
		driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.navigate().to(appURL);
	
		return driver;
	}
	private static WebDriver initBrowserStack(String appURL) throws MalformedURLException
	{
			final String USERNAME = "krishna294";
			final String AUTOMATE_KEY = "fE7R8c82ypx7qAMiofqg";
			final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

			DesiredCapabilities caps = new DesiredCapabilities();
		    caps.setCapability("browserName", "iPhone");
		    caps.setCapability("device", "iPhone 6");
		    caps.setCapability("realMobile", "true");
		    caps.setCapability("os_version", "10.3");

		    WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
//	    	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		    driver.get(appURL);
		    
		    return driver;
		
	}
//	@AfterSuite
	//Test cleanup
//	private void TeardownBrowser(ITestResult result)
//    {
//		BaseUtils.driver.quit();
//		if(result.getStatus()==ITestResult.FAILURE)
//		{
//			String screenshot_path=BaseUtils.captureScreenShot(driver, result.getName());
//			String image= logger.addScreenCapture(screenshot_path);
//			logger.log(LogStatus.FAIL, result.getName(), image);
//			BaseUtils.driver.quit();
//		}
//		report.endTest(logger);
//		report.flush();
//		driver.get(System.getProperty(("user.dir")+"\\AutomationLogs\\MyReports\\Report.html"));
//    }
	protected void logWriter(String status)
	{
		String logfileName = "";
		
		StackTraceElement[] elements = Thread.currentThread().getStackTrace();
		logfileName = elements[2].getClassName();
		int index = logfileName.lastIndexOf('.');
		logfileName = logfileName.substring(index+1);
		if(logfileName.contains("Objects"))
		{
			logfileName = logfileName.replace("Objects", "");
		}
		if(logfileName.contains("Tests"))
		{
			logfileName = logfileName.replace("Tests", "");
		}

	  logfileName = logfileName+"_"+java.time.LocalDate.now();
	  
	  String path = System.getProperty("user.dir")+"\\AutomationLogs\\";

	  File f = null;
			  try {
				  
				  if (status.contains("PASS"))
		            {
		                f = new File(path + logfileName + "_PASS.txt");
		                
		                if (!f.exists()) {
		                    f.createNewFile();
		                }
		                FileWriter fw = new FileWriter(f, true);
		                BufferedWriter bw = new BufferedWriter(fw);
		                bw.append(status);
		                bw.append(System.lineSeparator());
			            bw.close();
		            }
				  else if (status.contains("FAIL"))
		            {
		                f = new File(path + logfileName + "_FAIL.txt");
		                if (!f.exists()) {
		                    f.createNewFile();
		                }
		                FileWriter fw = new FileWriter(f, true);
		                BufferedWriter bw = new BufferedWriter(fw);
		                bw.append(status);
		                bw.append(System.lineSeparator());
			            bw.close();
		            }
				  else if (status.contains("INFO"))
		            {
		                f = new File(path + logfileName + "_PASS.txt");
		                if (!f.exists()) {
		                    f.createNewFile();
		                }
		                FileWriter fw = new FileWriter(f, true);
		                BufferedWriter bw = new BufferedWriter(fw);
		                bw.append(status);
		                bw.append(System.lineSeparator());
			            bw.close();
		            }
				  else
				  {
					  	f = new File(path + logfileName + "_PASS.txt");
					  	if (!f.exists()) {
		                    f.createNewFile();
		                }
		                FileWriter fw = new FileWriter(f, true);
		                BufferedWriter bw = new BufferedWriter(fw);
		                bw.append(status);
		                bw.append(System.lineSeparator());
			            bw.close();
			            
			            f = new File(path + logfileName + "_FAIL.txt");
			            if (!f.exists()) {
		                    f.createNewFile();
		                }
		                fw = new FileWriter(f, true);
		                bw = new BufferedWriter(fw);
		                bw.append(status);
		                bw.append(System.lineSeparator());
			            bw.close();				  
				  }		  
				  
		        } 
			  	catch (IOException e)
			  	{
		            System.err.println("Problem writing to the file "+f+"_"+e.getMessage());
		        }
	}
	public static void focusElement(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver; 

		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);

		try 
		{
			Thread.sleep(1000);
		} 
		catch (InterruptedException e) 
		{
			System.out.println(e.getMessage());
		} 

			js.executeScript("arguments[0].setAttribute('style','border: solid 2px white');", element); 
	}
	
	public static String captureScreenShot(WebDriver driver, String ScreenShotName)
	{
		try
		{
			TakesScreenshot ss = (TakesScreenshot)driver;
			File source = ss.getScreenshotAs(OutputType.FILE);
			String dest = path+"\\AutomationLogs\\ScreenShots\\"+ScreenShotName+".jpg";
			File destination = new File(dest);
			org.apache.maven.artifact.ant.shaded.FileUtils.copyFile(source, destination);
			return dest;
		}
		catch(Exception e)
		{
			return e.getMessage();
		}
				
	}
	public void waitForEle(WebElement ele, int timeout) 
	{
		WebDriverWait wait = new WebDriverWait(driver, timeout);

		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}

}
