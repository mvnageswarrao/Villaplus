package com.vp.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WaitForControl extends BaseUtils{
	
	public WaitForControl()
	{
		
	}
	public WaitForControl(WebElement ele)
	{
		
		//	public void XWait(WebElement element, java.lang.reflect.Method method)
//		public void XWait(WebElement element)
//		{
////			String testcasename = method.getName();
////			method.getDeclaringClass();
//			//100 milli second is equal to 1 second
//			WebDriverWait wait = new WebDriverWait(driver, 10);
//			long elaspsedTime = 0;
//			try
//			{
//				long lStartTime = new Date().getTime();
	//
//			wait.until(ExpectedConditions.elementToBeClickable(element));
//			new FluentWait<WebElement>(element).withTimeout(30,TimeUnit.SECONDS).pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
//			long lEndTime = new Date().getTime();
	//
//			elaspsedTime = lEndTime - lStartTime;
	//
//			}
//			catch(Exception e)
//			{
////				throw new InterruptedException(e.getMessage());
//			}
//			System.out.println("Waiting for Control"+element.toString()+"Took "+ elaspsedTime +" Milli Seconds");
//		}
		
	}
	public WaitForControl(WebDriver driver)
	{
		
	}
	


}
