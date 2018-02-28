package com.vp.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import com.vp.utils.BaseUtils;

public class SRPageObjects extends BaseUtils{
	
	WebDriver driver;
	@FindBy(how = How.CLASS_NAME, using = "link_button")
	WebElement BookVillaBtns; 
	
	java.util.List<WebElement> BooVillaLst;

//	@FindBy(how = How.PARTIAL_LINK_TEXT, using = "Book villa & flights")
//	WebElement BookVillaAndFlightsBtn; 
	
//	@FindBy(how = How.CLASS_NAME, using = "link_button")
//	WebElement BookVillaOnlyBtn; 
	@FindBy(how = How.CLASS_NAME, using = "ancvillaimg ancViewVilla")
	WebElement ViewVillaBtn; 
	@FindBy(how=How.ID,using = "btnSearch")
	WebElement Search;

	public SRPageObjects(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this.driver);
	}

		
	public void verifySRPageOpened()
	{
		String ExpTitle = "Your search found";
		String ActTitle = driver.getTitle();
		
		try
		{
			if(ActTitle.contains(ExpTitle))
			{
				logWriter("PASS : \"Search Results\" Page Opened.");
			}
		}
		catch(Exception e)
		{
			logWriter("FAIL : Could Not Open \"Search Results\" Page."+e.getMessage());

		}		
		
	}	
	
	public int verifyNumofVillas()
	{
		String Title = driver.getTitle();
		String[] ArrTitle = Title.split(" ");
		int NumofVillas = 0;
		try
		{
			NumofVillas = Integer.parseInt(ArrTitle[3]);
			logWriter("PASS : "+NumofVillas+" Villas found in Search Results page.");
		}
		catch(Exception e)
		{
			logWriter("FAIL : Could not fetch Num of Villas from Search Results page."+e.getMessage());	
		}
		return NumofVillas;

	}
	
	//Test to see in winmerge
	
	public void clickBookVillaAndFlights()
	{		
		try 
		{
			BooVillaLst = driver.findElements(By.className("link_button"));
			for(WebElement PKBtn : BooVillaLst)
			{
				if(PKBtn.getAttribute("value").contains("Book villa & flights"))
				{
					PKBtn.click();
					logWriter("PASS : Clicked \"Book Villa & Flights\" Button.");
					break;
				}
			}
			
		}
		catch(Exception e)
		{
			logWriter("FAIL : Could Not click \"Book Villa & Flights\" Button."+e.getMessage());
		}		
	}
	public void clickBookVillaOnly()
	{		
		try
		{
			BooVillaLst = driver.findElements(By.className("link_button"));

			for (int i=0; i<BooVillaLst.size();i++)
			for(WebElement VOBtn : BooVillaLst)
			{
				if(VOBtn.getAttribute("value").contains("Book villa only"))
				{
					VOBtn.click();
					logWriter("PASS : Clicked \"Book Villa Only\" Button.");
					break;
				}
			}
		}
		catch(Exception e)
		{
			logWriter("FAIL : Could Not click \"Book Villa Only\" Button."+e.getMessage());
		}
	}

	
	
	
	


}
