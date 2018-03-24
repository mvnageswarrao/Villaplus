package com.vp.tests;

import java.io.IOException;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.vp.objects.GroupDetailPageObjects;
import com.vp.utils.BaseUtils;

public class GroupDetailsPageTests extends BaseUtils {

	GroupDetailPageObjects groupDetails;

	@Test(priority=6)
	@Parameters({"EmailID","PostCode"})
	
   public void verifyContinuebtnFunctionality(String EmailID, String PostCode) throws IOException, ClassNotFoundException, SQLException, InterruptedException {
		
		groupDetails = PageFactory.initElements(driver, GroupDetailPageObjects.class);
		
		groupDetails.verifyGroupDetailPageTitle();
		groupDetails.SelectTitleDropdown();
		groupDetails.insertFname();
		groupDetails.insertLname();
		groupDetails.insertEmail(EmailID);
		groupDetails.insertConEmail(EmailID);
		groupDetails.insetPostCode(PostCode);
		groupDetails.ClickbtnLookUpAddresss();
		groupDetails.SelectAddressFromLookUp();
		groupDetails.SelectAgeGroup();
		groupDetails.insertDayPhoneCode("425245");
		groupDetails.insertDayPhoneNo("425245");
		groupDetails.insertMobileNo();		
		groupDetails.ClickbtnContinue();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		groupDetails.ClickbtnIAgree();
		
			
		
	}

	
	
	
	 //  Script for to Verify "Confirm Address" button functionality from "Address Look -up"
	 
	 
	@Test(priority = 5)
	@Parameters({"PostCode"})
	public void VerifyConAddbtnFunctionality(String PostCode){
		groupDetails = PageFactory.initElements(driver, GroupDetailPageObjects.class);
		
		groupDetails.insetPostCode(PostCode);
		groupDetails.ClickbtnLookUpAddresss();
		groupDetails.SelectAddressFromLookUp();
	
	}
	
	/*
	 *  Script for Verify the "Look -up Address" functionality with blank Postcode.
	*/
	
	@Test(priority = 4)
	public void LookupfuncBlankPostCode() {
		groupDetails = PageFactory.initElements(driver, GroupDetailPageObjects.class);
		
		groupDetails.ClickbtnLookUpAddresss();
		WebElement ErrorMsg=driver.findElement(By.id("errMsgSelUkPostCode"));
		String errorStr=ErrorMsg.getText();
		if(errorStr.equals("Please enter Postcode for lookup.")) {
			logWriter("PASS: Look -up Address functionality with blank Postcode");
			System.out.println("Pass :");
		}
		else {
			logWriter("FAIL: Look -up Address functionality with blank Postcode");
			System.out.println("Fail :");
		}
		
	}
	
	
	// Function for to check the total holiday cost & total cost at the summary section.
	@Test(priority=5)
	public void ChkTotalPrizeGDPage() {
		String TotalPrizeSummary=groupDetails.TotalPrizeSummary();
		String TotalCost=groupDetails.TotalCost();
		if(TotalPrizeSummary.equals(TotalCost)) {
			logWriter("PASS: Price per person displayed in Summary section and Total Holiday Cost section is identical on GD Page");
		    System.out.println("PASS :");
		}
		
		else {
			System.out.println("FAIL :");
			logWriter("FAIL: Price per person displayed in Summary section and Total Holiday Cost section is not identical on GD Page");
		
		}
		
	}
	
}	
	

