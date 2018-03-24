package com.vp.tests;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.testng.internal.Utils;

import com.vp.objects.FlightsPageObjects;
//import com.vp.objects.GroupDetailsPageObjects;
import com.vp.objects.SRPageObjects;
import com.vp.utils.BaseUtils;

public class FlightPageTests extends BaseUtils{

	SRPageObjects SRPage;
	FlightsPageObjects FlightsPage;
	
	@Test(priority=3)
	public void VerifyFlightspage(String BookingType) throws IOException, InterruptedException
	{
		FlightsPage = PageFactory.initElements(driver, FlightsPageObjects.class);
		String actPageTitle =  driver.getTitle();		
		if(actPageTitle.equals("Villa Plus | Flights"))
		{
			//Edit Flight Button Functionality
			FlightsPage.clickEditFlightButton();			
			FlightsPage.checkTitleEditFlightsPopup();
			FlightsPage.selectAirport();
			FlightsPage.selectSortoptions();
			FlightsPage.slideOutboundRight();
			FlightsPage.slideOutboundLeft();
			FlightsPage.selectFlightPaymentType();
			FlightsPage.selectCheckboxUKDeptAirport();
			FlightsPage.selectCheckboxUKArrAirport();
			FlightsPage.selectCheckboxAirline();
			FlightsPage.clickClearAllBtn();
			FlightsPage.selectFlight();
			FlightsPage.clickContinuebtn();		
			FlightsPage.clickAddMoreFlights();
			FlightsPage.titleAddMoreFlightsPopup();
			FlightsPage.addFlights();
			FlightsPage.clickContinueAddMOreFlights();
			Thread.sleep(8000);
			FlightsPage.clickContinueBtnFromFlights();
			FlightsPage.clickYesBtnCheckInBagsPopup();				
		}
		else if(actPageTitle.equals("Villa Plus | Villa Only"))
		{
			if(BookingType=="Conv")
			{
				//Converted Booking
				FlightsPage.clickAddFlightsButton();
				FlightsPage.selectDeptAirportConvertedBook();
				FlightsPage.clickContinueButton();				
				Thread.sleep(5000);
				FlightsPage.clickContinueBtnFromFlights();
				FlightsPage.clickYesBtnCheckInBagsPopup();
			}
			else
			{	
				//Villa Only Booking
				FlightsPage.clickContinueBtnFromFlights();				
			}
		}					
	}
}
