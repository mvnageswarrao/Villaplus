package com.vp.tests;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.vp.utils.BaseUtils;
import com.vp.utils.GetFromDB;
import com.vp.objects.SRPageObjects;

public class SRPageTests extends BaseUtils{
	SRPageObjects SRPage;
    String sqlQuery = null;
    ResultSet rs = null;
    GetFromDB getfromdb;

	@Test(priority=2,groups= {"PKBooking","VOBooking"})
	public void verifySearchResultspage() throws IOException, ClassNotFoundException, SQLException
	{
		SRPage = PageFactory.initElements(driver, SRPageObjects.class);
	}
	@Test(priority=3,groups= {"PKBooking"})
	public void openPKSummaryPage()
	{
		SRPage.clickBookVillaAndFlights();
	}
	@Test(priority=3,groups= {"VOBooking"})
	public void openVOSummaryPage()
	{
		SRPage.clickBookVillaOnly();
	}
	

}
