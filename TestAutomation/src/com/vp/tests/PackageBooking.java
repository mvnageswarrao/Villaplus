package com.vp.tests;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import org.openqa.selenium.support.PageFactory;
import com.vp.objects.FlightsPageObjects;
import com.vp.objects.HomePageObjects;
import com.vp.objects.SRPageObjects;
import com.vp.utils.BaseUtils;

public class PackageBooking extends BaseUtils
{
	HomePageObjects homepage;
	SRPageObjects SRPage;
	FlightsPageObjects FlightsPage;
	
	String DesttoSelect;
	String DatetoSelect;
	String browserType;
	
	
	HomePageTests HM = new HomePageTests();
	SRPageTests SR = new SRPageTests();
	FlightPageTests Ft = new FlightPageTests();
	  
//	@Parameters({ "browserType", "appURL", "AdultsToSelect","ChildToSelect", "InfantsToSelect","SeasonEndDate"})	
//	@Test(priority = 0)
	public void PKBooking(String browserType, String appURL, String AdultsToSelect, String ChildToSelect, String InfantsToSelect, String EndDate) throws ClassNotFoundException, IOException, SQLException, ParseException, InterruptedException
	{
		driver = BaseUtils.initBrowser(browserType,appURL);
		homepage = PageFactory.initElements(driver, HomePageObjects.class);
		SRPage = PageFactory.initElements(driver, SRPageObjects.class);
		FlightsPage = PageFactory.initElements(driver, FlightsPageObjects.class);
		
		HM.verifySearchBtnFunctionality(browserType, appURL, AdultsToSelect, ChildToSelect, InfantsToSelect, EndDate);
		SR.verifySearchResultspage();
		Ft.VerifyFlightspage();
		
		
	}
	
	

}
