package com.vp.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import com.vp.utils.BaseUtils;

public class ExtrasPageObjects extends BaseUtils{
	
	WebDriver driver;
	@FindBy(how = How.ID, using = "btnextraback")
	WebElement BackBtntoGrpDetailsPage; 
	@FindBy(how = How.LINK_TEXT, using = "Continue")
	WebElement ContinueBtnFromExtras;
	@FindBy(how = How.LINK_TEXT, using = "I Agree")
	WebElement IAgreeBtnFromExtras; 
	
	
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
				
				logWriter("PASS : \"Extras\" page Title is "+ ActTitle);
			}
			
			else {
				
				logWriter("FAIL : \"Extras\" Page Title is " + ActTitle);
			
			}
		}
		catch(Exception e) {
			logWriter("FAIL : " + e.getMessage());
		}
	}
	
	public void clickBackToGRPDetailsPageBtn(){
		
		try 
		{
			BackBtntoGrpDetailsPage.click();
			logWriter("PASS : Clicked \"Back\" Button From \"Extras\" Page.");
			
		}
		catch(Exception e)
		{
			logWriter("FAIL : Could not click \"Back\" Button From \"Extras\" Page."+e.getMessage());
		}		
	}
	
	public void clickContinueBtnFromExtras(){
		
		try
		{
			ContinueBtnFromExtras.click();
			logWriter("PASS : Clicked \"Continue\" Button From \"Extras\" page.");
		}
		catch (Exception e) 
		{
		logWriter("FAIL : Could Not Click \"Continue\" Button From \"Extras\" page."+e.getMessage());
		}
	}
	
	public void clickIAgreeBtnFromExtras(){
		
		try
		{
			IAgreeBtnFromExtras.click();
			logWriter("PASS : Clicked \"I Agree\" Button From \"Extras\" page.");
		}
		catch (Exception e) 
		{
		logWriter("FAIL : Could Not Click \"I Agree\" Button From \"Extras\" page."+e.getMessage());
		}
	}

}
