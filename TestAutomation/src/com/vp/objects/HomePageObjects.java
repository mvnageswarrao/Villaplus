package com.vp.objects;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.vp.utils.BaseUtils;

public class HomePageObjects extends BaseUtils{
	
WebDriver driver = null;
Random ran = new Random();
	
	@FindBy(id = "ddDestinations")
	WebElement DestDropdown; 
	@FindBy(how=How.ID,using="DTPicker")
	WebElement Datebox;
	@FindBy(how=How.CLASS_NAME,using = "ui-datepicker-month")
	WebElement MonthBox;
	@FindBy(how=How.CLASS_NAME,using = "ui-datepicker-calendar")
	WebElement Calender;
	@FindBy(how=How.CLASS_NAME,using = "enabled")
	WebElement DateToSelect;
	@FindBy(how=How.ID,using = "ddDuration")
	WebElement Duration;
	@FindBy(how=How.ID,using = "ddAdults")
	WebElement Adults;
	@FindBy(how=How.ID,using = "ddChildren")
	WebElement Child;
	@FindBy(how=How.ID,using = "ddInfants")
	WebElement Infants;
	@FindBy(how=How.ID,using = "ddAirports")
	WebElement Airport;
	@FindBy(how=How.ID,using = "btnSearch")
	WebElement Search;
		
	public HomePageObjects(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void openDestDropDown() 
	{
		try
		{
			DestDropdown.click();
			logWriter("PASS : Destinations Dropdown is Opened.");
		}
		catch(Exception e)
		{
			logWriter("FAIL : Could not Open Destinations Dropdown."+e.getMessage());
		}
	}
	public void selectDest(String DesttoSelect) 
	{

		Select DestEle = new Select(DestDropdown);
		java.util.List<WebElement> Dest = DestEle.getOptions();
		
		try
		{
			for(int i = 0; i<=Dest.size();i++)
			{
				if(Dest.get(i).getText().trim().equalsIgnoreCase(DesttoSelect.trim()))
				{
					DestEle.selectByIndex(i);
					break;
				}
			}
			logWriter("PASS : \""+DesttoSelect+"\" Selected from Destinations Dropdown.");
		}
		catch(Exception e)
		{
			logWriter("FAIL : Could not Select \""+DesttoSelect+"\" from Destinations Dropdown."+e.getMessage());
		}
		
	}
	public void clickDateBox()
	{	
		try
		{
			Datebox.click();
			logWriter("PASS : Clicked Date Text box.");
		}
		catch(Exception e)
		{
			logWriter("FAIL : Could Not Clicked Date Text box."+e.getMessage());

		}		
	}
	public void selectMonth(String DateToSelect) throws ParseException
	{
		SimpleDateFormat in = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
	    SimpleDateFormat out = new SimpleDateFormat("MMMM yyyy");
	    Date date = in.parse(DateToSelect);
	    String MonToSelect = out.format(date);
		Select MonthDropdownEle = new Select(MonthBox);
		java.util.List<WebElement> MnthLst = MonthDropdownEle.getOptions();
		try
		{
			for(int i = 0; i<=MnthLst.size();i++)
			{
				if(MnthLst.get(i).getText().trim().equalsIgnoreCase(MonToSelect.trim()))
				{
					MonthDropdownEle.selectByIndex(i);
					break;
				}
			}
			logWriter("PASS : Selected \""+MonToSelect+"\" From Month dropdown.");
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		}
		catch(Exception e)
		{
			logWriter("FAIL : Could Not Select \""+MonToSelect+"\" From Month dropdown."+e.getMessage());
		}
	}
	public void selectDate(String DateToSelect) throws ParseException
	{
	    SimpleDateFormat in = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
	    SimpleDateFormat out = new SimpleDateFormat("dd");

	    Date date = in.parse(DateToSelect);
	    DateToSelect = out.format(date);
	    int Dateint = Integer.parseInt(DateToSelect);
 		java.util.List<WebElement> DateLst = Calender.findElements(By.className("enabled"));
				
		try
		{
			for(WebElement Date : DateLst)
			{
				if(Integer.parseInt(Date.getText())==(Dateint))
				{
					Date.click();
					logWriter("PASS : Selected \""+Dateint+"\" Date From Calender.");
					break;
				}
			}
		}
		catch(Exception e)
		{
			logWriter("FAIL : Could Not Select a Date From Calender."+e.getMessage());

		}	
	}
	public void selectDuration()
	{
		Select DurationSel = new Select(Duration);
		java.util.List<WebElement> DurationLst = DurationSel.getOptions();
		
		Random ran = new Random();
		int index = ran.nextInt(DurationLst.size());
		String DurtoSelect = DurationLst.get(index).getText().trim();

		try
		{
			for(WebElement Dur : DurationLst)
			{
				if(Dur.getText().trim().equalsIgnoreCase(DurtoSelect))
				{
					Dur.click();
					logWriter("PASS : Selected \""+Dur.getText()+"\" From Duration dropdown.");
					break;
				}
			}
		}
		catch(Exception e)
		{
			logWriter("FAIL : Could Not Select \""+DurtoSelect+"\" From Duration dropdown."+e.getMessage());

		}	
		
	}
	public void selectAdults(String AdultsToSelect)
	{
		Select AdultsSel = new Select(Adults);
		try
		{
			AdultsSel.selectByValue(AdultsToSelect);
			logWriter("PASS : Selected \""+AdultsToSelect+"\" Adults.");
		}
		catch(Exception e)
		{
			logWriter("FAIL : Could Not Select \""+AdultsToSelect+"\" From Adults dropdown."+e.getMessage());

		}	
	}
	public void selectChild(String ChildToSelect)
	{
		Select ChildSel = new Select(Child);
		try
		{
			ChildSel.selectByValue(ChildToSelect);
			logWriter("PASS : Selected \""+ChildToSelect+"\" Child.");
		}
		catch(Exception e)
		{
			logWriter("FAIL : Could Not Select \""+ChildToSelect+"\" From Child dropdown."+e.getMessage());
		}	
	}
	public void selectInfants(String InfantsToSelect)
	{
		Select InfantsSel = new Select(Infants);
		try
		{
			InfantsSel.selectByVisibleText(InfantsToSelect);
			logWriter("PASS : Selected \""+InfantsToSelect+"\" Infants.");
		}
		catch(Exception e)
		{
			logWriter("FAIL : Could Not Select \""+InfantsToSelect+"\" From Infants dropdown."+e.getMessage());
		}	
	}
	public void SelectAirport()
	{
		Airport.click();
		Select AirportEle = new Select(Airport);
		java.util.List<WebElement> AirportList = AirportEle.getOptions(); 
			
		String AirportToSelect = AirportList.get(ran.nextInt(AirportList.size())).toString().trim();
		
		try
		{
			for(int i = 0; i<=AirportList.size();i++)
			{
				if(AirportList.get(i).getText().toString().trim().equalsIgnoreCase(AirportToSelect))
				{
					AirportEle.selectByIndex(i);
					break;
				}
			}
			logWriter("PASS : Selected \""+AirportToSelect+"\" From Airports Dropdown.");
		}
		catch(Exception e)
		{
			logWriter("FAIL : Could Not Select \""+AirportToSelect+"\" From Airports dropdown."+e.getMessage());
		}	
		

	}
	public void ClickSearchBtn()
	{
		try
		{
			Search.click();
			logWriter("PASS : Clicked \"Search\" Button from Search Tile.");
		}
		catch(Exception e)
		{
			logWriter("FAIL : Could Not Click \"Search\" Button From Search Tile."+e.getMessage());
		}	

	}
	public void verifyHomePageOpened()
	{
		String ExpTitle = "Villa Holidays 2018 | Villa Plus – Always Adding Extra";
		String ActTitle = driver.getTitle();
		try {
			if(ExpTitle.trim().equalsIgnoreCase(ActTitle.trim()))
			{
				logWriter("PASS : \"Home Page\" is Opened.");
			}
		}
		catch(Exception e)
		{
			logWriter("FAIL : Could Not Open \"Home Page\"."+e.getMessage());
		}
		
	}

}
