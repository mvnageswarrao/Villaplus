package com.vp.tests;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.vp.utils.BaseUtils;
import com.vp.utils.GetFromDB;
import com.vp.objects.HomePageObjects;
import com.vp.objects.SRPageObjects;

public class HomePageTests extends BaseUtils{
	
	HomePageObjects homepage;
	SRPageObjects SRPage;
	GetFromDB getfromdb = new GetFromDB();
	
    String sqlQuery = null;
    ResultSet rs = null;
	String DesttoSelect;
	String DatetoSelect;
	
	int NumofVillas; 
	String centerCode;

	@Parameters({"browserType", "appURL","AdultsToSelect","ChildToSelect", "InfantsToSelect","SeasonEndDate"})
	@Test(priority=1)
	public void verifySearchBtnFunctionality(String browserType, String appURL, String AdultsToSelect, String ChildToSelect, String InfantsToSelect, String EndDate) throws IOException, ClassNotFoundException, SQLException, ParseException, InterruptedException
	{
		//driver = BaseUtils.initBrowser(browserType,appURL);
		homepage = PageFactory.initElements(driver, HomePageObjects.class);
		SRPage = PageFactory.initElements(driver, SRPageObjects.class);
		do
		{
			logWriter("########## START ########## Booking : on " + appURL + " " + java.time.LocalDate.now().toString() + "##########");
			homepage.verifyHomePageOpened();
			DesttoSelect = getfromdb.getSelectableDest();
			homepage.openDestDropDown();
			homepage.selectDest(DesttoSelect);
			centerCode = getfromdb.getCenterCode(DesttoSelect);
			DatetoSelect = getfromdb.getSelectableDate(centerCode,EndDate);
			homepage.clickDateBox();
			homepage.selectMonth(DatetoSelect);
			homepage.selectDate(DatetoSelect);
			homepage.selectDuration();
			homepage.selectAdults(AdultsToSelect);
			homepage.selectChild(ChildToSelect);
			homepage.selectInfants(InfantsToSelect);
			homepage.SelectAirport();
			homepage.ClickSearchBtn();			
			SRPage.verifySRPageOpened();
			NumofVillas = SRPage.verifyNumofVillas();
		}while (NumofVillas==0);
	}
	public void veifyMenuOptions()
	{
		
	}
	public void verifyBanners()
	{
		
	}
	public void verifyHeaderOptions()
	{
		
	}
	public void verifyFooterOptions()
	{
		
	}
	public void verifyBodyOptions()
	{
		
	}

}
