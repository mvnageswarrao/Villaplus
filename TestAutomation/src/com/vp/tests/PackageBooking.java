package com.vp.tests;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.vp.objects.ExtrasPageObjects;
import com.vp.objects.FlightsPageObjects;
import com.vp.objects.GroupDetailPageObjects;
import com.vp.objects.HomePageObjects;
import com.vp.objects.SRPageObjects;
import com.vp.utils.BaseUtils;

public class PackageBooking extends BaseUtils
{
	HomePageObjects homepage;
	SRPageObjects SRPage;
	FlightsPageObjects FlightsPage;
	GroupDetailPageObjects GDPage;
	ExtrasPageObjects ExtrasPage;
	
	String DesttoSelect;
	String DatetoSelect;
	String browserType;
	String BookingType;
	
	
	HomePageTests HM = new HomePageTests();
	SRPageTests SR = new SRPageTests();
	FlightPageTests FT = new FlightPageTests();
	GroupDetailsPageTests GD = new GroupDetailsPageTests();
	ExtrasPageTests Ex = new ExtrasPageTests();
	  
	@Parameters({ "browserType", "appURL", "AdultsToSelect","ChildToSelect", "InfantsToSelect","SeasonEndDate","EmailID","PostCode"})	
	@Test(priority = 2)
	public void PackageBookingVerification(String browserType, String appURL, String AdultsToSelect, String ChildToSelect, String InfantsToSelect, String EndDate,String EmailID, String PostCode) throws ClassNotFoundException, IOException, SQLException, ParseException, InterruptedException
	{
		String BookingType = "PK";
		//driver = BaseUtils.initBrowser(browserType,appURL);
		homepage = PageFactory.initElements(driver, HomePageObjects.class);
		SRPage = PageFactory.initElements(driver, SRPageObjects.class);
		FlightsPage = PageFactory.initElements(driver, FlightsPageObjects.class);
		ExtrasPage = PageFactory.initElements(driver, ExtrasPageObjects.class);
		
		HM.verifySearchBtnFunctionality(browserType, appURL, AdultsToSelect, ChildToSelect, InfantsToSelect, EndDate);
		SR.verifySearchResultspage(BookingType);
		FT.VerifyFlightspage(BookingType);
		GD.verifyContinuebtnFunctionality(EmailID,PostCode);
		Ex.VerifyExtrasPage(BookingType);		
		
		
	}
	
	

}
