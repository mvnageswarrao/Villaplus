package com.vp.tests;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.vp.utils.BaseUtils;
import com.vp.utils.GetFromDB;
import com.vp.objects.SRPageObjects;

public class SRPageTests extends BaseUtils{
	SRPageObjects SRPage;
    String sqlQuery = null;
    ResultSet rs = null;
    GetFromDB getfromdb;

	@Test(priority=2)
	@Parameters({"BookingType"})
	public void verifySearchResultspage(String BookingType) throws IOException, ClassNotFoundException, SQLException
	{
		SRPage = PageFactory.initElements(driver, SRPageObjects.class);
		if(BookingType == "PK")
		{
			SRPage.clickBookVillaAndFlights();
		}
		else if(BookingType == "VO")
		{
			SRPage.clickBookVillaOnly();
		}
		else if(BookingType == "Conv")
		{
			SRPage.clickBookVillaOnly();
		}
	}
	
}
