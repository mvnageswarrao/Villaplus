package com.vp.tests;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.vp.objects.FlightsPageObjects;
//import com.vp.objects.GroupDetailsPageObjects;
import com.vp.objects.SRPageObjects;
import com.vp.utils.BaseUtils;

public class FlightPageTests extends BaseUtils{

	SRPageObjects SRPage;
	FlightsPageObjects FlightsPage;
	
	@Test(priority=4,groups= {"VOBooking","PKBooking"})
	public void VerifyFlightspage() throws IOException, InterruptedException
	{
		FlightsPage = PageFactory.initElements(driver, FlightsPageObjects.class);
		SRPage = PageFactory.initElements(driver, SRPageObjects.class);

		FlightsPage.verifyFlightsPageOpened();
		//FlightsPage.verifyVillaDetails();
		//FlightsPage.clickBackToSRPageBtn();	
		//SRPage.verifySRPageOpened();
		FlightsPage.clickContinueBtnFromFlights();
		
	}
}
