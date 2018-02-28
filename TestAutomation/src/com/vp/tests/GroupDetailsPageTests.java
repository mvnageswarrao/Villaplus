package com.vp.tests;

import java.io.IOException;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.vp.objects.GroupDetailPageObjects;
import com.vp.utils.BaseUtils;

public class GroupDetailsPageTests extends BaseUtils {

	GroupDetailPageObjects groupDetails;
	
	@Test(priority=5,groups= {"PKBooking","VOBooking"})
	
   public void verifyContinuebtnFunctionality() throws IOException, ClassNotFoundException, SQLException, InterruptedException {
		
		groupDetails = PageFactory.initElements(driver, GroupDetailPageObjects.class);
		
		groupDetails.verifyGroupDetailPageTitle();
		//groupDetails.ClickbtnContinue();
		
		groupDetails.SelectTitleDropdown();
		groupDetails.insertFname();
		groupDetails.insertLname();
		groupDetails.insertEmail("testautomation@ash-software.com");
		groupDetails.insertConEmail("testautomation@ash-software.com");
		groupDetails.SelectAgeGroup();
		groupDetails.insetPostCode("al3 4bh");
		groupDetails.ClickbtnLookUpAddresss();
		groupDetails.SelectAddressFromLookUp();
		groupDetails.insertDayPhoneCode("425245");
		groupDetails.insertDayPhoneNo("425245");
		groupDetails.insertMobileNo("15454545477");	
		groupDetails.ClickbtnContinue();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		groupDetails.ClickbtnIAgree();
			
	}
	
}
