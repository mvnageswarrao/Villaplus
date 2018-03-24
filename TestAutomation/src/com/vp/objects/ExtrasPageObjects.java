package com.vp.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.vp.utils.BaseUtils;

public class ExtrasPageObjects extends BaseUtils{
	
	WebDriver driver;
	@FindBy(how = How.ID, using = "btnextraback")
	WebElement BackBtntoGrpDetailsPage; 
	@FindBy(how = How.LINK_TEXT, using = "Continue")
	WebElement ContinueBtnFromExtras;
	@FindBy(how = How.LINK_TEXT, using = "I Agree")
	WebElement IAgreeBtnFromExtras; 
	@FindBy(how = How.ID,using="CustInfoDetailsPopUp")
	WebElement FlightInfoPopup;
	@FindBy(how = How.ID,using="InsBtnNo")
	WebElement LaterBtn;
	@FindBy(how = How.ID,using="InsBtnOk")
	WebElement SaveBtn;
	
	
	public ExtrasPageObjects(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this.driver);
	}
	
	public void verifyExtrasPageOpened() {
		
		String ExpTitle ="Villa Plus | Extras";
		String ActTitle=driver.getTitle();
		try {
			
			if(ExpTitle == ActTitle) {
				
				Reporter.log("PASS : \"Extras\" page Title is "+ ActTitle);
			}
			
			else {
				
				Reporter.log("FAIL : \"Extras\" Page Title is " + ActTitle);
			
			}
		}
		catch(Exception e) {
			Reporter.log("FAIL : " + e.getMessage());
		}
	}
	
	public void clickBackToGRPDetailsPageBtn(){
		
		try 
		{
			BackBtntoGrpDetailsPage.click();
			Reporter.log("PASS : Clicked \"Back\" Button From \"Extras\" Page.");
			
		}
		catch(Exception e)
		{
			Reporter.log("FAIL : Could not click \"Back\" Button From \"Extras\" Page."+e.getMessage());
		}		
	}
	
	public void clickContinueBtnFromExtras(){
		
		try
		{
			ContinueBtnFromExtras.click();
			Reporter.log("PASS : Clicked \"Continue\" Button From \"Extras\" page.");
		}
		catch (Exception e) 
		{
		Reporter.log("FAIL : Could Not Click \"Continue\" Button From \"Extras\" page."+e.getMessage());
		}
	}

	public void clickIAgreeBtnFromExtras(){
		
		try
		{
			IAgreeBtnFromExtras.click();
			Reporter.log("PASS : Clicked \"I Agree\" Button From \"Extras\" page.");
		}
		catch (Exception e) 
		{
		Reporter.log("FAIL : Could Not Click \"I Agree\" Button From \"Extras\" page."+e.getMessage());
		}
	}

	public void clickLaterBtn()
	{
		driver.switchTo().activeElement();
		focusElement(driver, LaterBtn);
		try
		{
			LaterBtn.click();
			Reporter.log("PASS : Clicked \"Later\" Button From \"Flight Info\" Popup.");
		}
		catch (Exception e) 
		{
			Reporter.log("FAIL : Could Not Click \"Later\" Button From \"Flight Info\" Popup."+e.getMessage());
		}
	}
		
		public void clickSaveBtn()
		{
			driver.switchTo().activeElement();
			try
			{
				SaveBtn.click();
				Reporter.log("PASS : Clicked \"Save\" Button From \"Flight Info\" Popup.");
			}
			catch (Exception e) 
			{
			Reporter.log("FAIL : Could Not Click \"Save\" Button From \"Flight Info\" Popup."+e.getMessage());
			}
		
		}
	
}
