package com.vp.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.vp.utils.BaseUtils;

public class FlightsPageObjects extends BaseUtils {
	
	WebDriver driver;
	@FindBy(how = How.CLASS_NAME, using = "current")
	WebElement Flightstab; 
	@FindBy(how = How.CLASS_NAME, using = "bg-white villa-info")
	WebElement VillaDetailsSection; 
	@FindBy(how = How.ID, using = "btnContinueToSearchResult")
	WebElement BackBtntoSRPage; 
	@FindBy(how = How.ID, using = "btnContinueFlights")
	WebElement ContinueBtnFromFlights; 	
		
	public FlightsPageObjects(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this.driver);
	}
	public void verifyFlightsPageOpened()
	{
		String ExpTitle = "Villa Plus | Flights ";
		String ActTitle = driver.getTitle();
		try {
			
			if(ExpTitle.contains(ActTitle))
			{
				Reporter.log("PASS : \"Flights\" Page Opened.");
			}
		}
		catch(Exception e)
		{
			Reporter.log("FAIL : Could Not Open \"Flights\" Page."+e.getMessage());
		}

	}
	public void verifyVillaDetails()
	{
		String ActTxt = VillaDetailsSection.getText();
		String ExpTxt = "Some Text";
		
		try 
		{	
			if(ActTxt.contains(ExpTxt))
			{
				Reporter.log("PASS : \"Villa Details\" text is matched.");
			}
		}
		catch(Exception e)
		{
			Reporter.log("FAIL : \"Villa Details\" text is not matched."+e.getMessage());
		}
		
	}
	public void clickBackToSRPageBtn()
	{
		try 
		{
			BackBtntoSRPage.click();
			Reporter.log("PASS : Clicked \"Back\" Button From \"Flights\" Page.");
			
		}
		catch(Exception e)
		{
			Reporter.log("FAIL : Could not click \"Back\" Button From \"Flights\" Page."+e.getMessage());
		}		
	}
	public void clickContinueBtnFromFlights()
	{
		try
		{
			ContinueBtnFromFlights.click();
			Reporter.log("PASS : Clicked \"Continue\" Button From \"Flights\" page.");
		}
		catch (Exception e) 
		{
		Reporter.log("FAIL : Could Not Click \"Continue\" Button From \"Flights\" page."+e.getMessage());
		}
	}
}
