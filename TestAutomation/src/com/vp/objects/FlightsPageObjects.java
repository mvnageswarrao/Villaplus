package com.vp.objects;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import com.vp.utils.BaseUtils;

public class FlightsPageObjects extends BaseUtils 
{	
	WebDriver driver;
	//WebDriverWait wait = new WebDriverWait(driver,40);
	Random ran = new Random();
	@FindBy(how = How.CLASS_NAME, using = "current")
	WebElement Flightstab; 
	@FindBy(how = How.CLASS_NAME, using = "bg-white villa-info")
	WebElement VillaDetailsSection; 
	@FindBy(how = How.ID, using = "btnContinueToSearchResult")
	WebElement BackBtntoSRPage; 
	@FindBy(how = How.LINK_TEXT, using = "Continue")
	WebElement ContinueBtnFromFlights; 		
	@FindBy(how=How.LINK_TEXT, using = "Edit")
	WebElement EditFlightButton;
	@FindBy(how=How.ID, using = "ddDepAirport")
	WebElement airportList;
	@FindBy(how=How.CSS, using = ".icon-sort")
	WebElement sortOptions;
	@FindBy(how=How.CSS, using = ".slider-range .ui-corner-all:nth-child(3)")
	WebElement rightSlideerOutbound;
	@FindBy(how=How.CSS, using = ".slider-range .ui-corner-all:nth-child(2)")
	WebElement leftSlideerOutbound;	
	@FindBy(how=How.XPATH, using = "//div[@id='depAirportlist']//label")			
	List<WebElement> ListUKDeptAirportChkBoxes;		
	@FindBy(how=How.XPATH, using = "//div[@id='arrAirportlist']//label")			
	List<WebElement> ListUKArrAirportChkBoxes;		
	@FindBy(how=How.XPATH, using = "//div[@class='section-toggle airline']//label")			
	List<WebElement> ListAirlinesChkBoxes;	
	@FindBy(how=How.XPATH, using = "//div[6]/div[@class='bg-white']/div[@class='section-toggle']/div[@class='checkbox']")			
	List<WebElement> ListFlightPaymentChkBoxes;
	@FindBy(how=How.XPATH, using = "//div[@class='result']/div[@class='checkbox']")
	List<WebElement> ListFlightsCheckboxes;
	@FindBy(how=How.ID, using = "clearAll2")
	WebElement btnClearAll;
	@FindBy(how=How.LINK_TEXT, using = "Continue")
	WebElement btnContinueEditFlight;
	@FindBy(how=How.LINK_TEXT, using = "Add more flights")
	WebElement btnAddMoreFlights;
	@FindBy(how=How.ID, using= "ddFlightCount")
	WebElement flightAdd;
	@FindBy(how=How.XPATH, using = "//div[@id='add-flight']//h2[@class='bg-bluefade']")
	WebElement titleAddMoreFlights;
	@FindBy(how=How.LINK_TEXT, using = "Continue")
	WebElement btnContinueAddMoreFlights;
	@FindBy(how=How.XPATH, using = "//div[@id='edit-flight']//h2[@class='bg-bluefade']")
	WebElement titleEditFlightspopup;
	@FindBy(how=How.LINK_TEXT, using ="Add flights")
	WebElement btnAddFlights;
	@FindBy(how=How.ID, using = "ddCHDepAirport")
	WebElement selectDeptAirport;
	@FindBy(how=How.ID, using = "btnIncludeFlight")
	WebElement clickContinueBtns;
	@FindBy(how=How.LINK_TEXT, using = "Continue")
	WebElement btnContinueEditFlightConvert;
	@FindBy(how=How.LINK_TEXT, using = "Yes")
	WebElement btnYesClick;
	
	
	//Click on the Yes Button from the opened popup
	public void clickYesBtnCheckInBagsPopup()
	{
		driver.switchTo().activeElement();
		Boolean yesbtn = btnYesClick.isEnabled();
		System.out.println(yesbtn.toString());
		if(btnYesClick.isEnabled())
		{
			btnYesClick.click();
			Reporter.log("PASS : Clicked on the Yes button from the Check-In Bags popup.");
		}
		else
		{
			Reporter.log("INFO : No Check In Bags popup is displayed.");
		}
	}
	
	
	//Click on Continue button from Converted Booking
		public void clickContinueButtonForConvertedBooking()
		{
			try
			{
				driver.switchTo().activeElement();
				//driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
				waitForEle(btnContinueEditFlightConvert, 120);
				Thread.sleep(5000);
				focusElement(driver, btnContinueEditFlightConvert);
				btnContinueEditFlightConvert.click();
				Reporter.log("PASS : Clicked on the Continue button from the Converted Booking");
			}
			catch(Exception ex)
			{
				Reporter.log("FAIL : Not Clicked on the Continue button from the Converted Booking");
				Reporter.log(ex.getMessage().toString());
			}
		}
	
	
	//Click on Continue button from Choose Departure Airport
	public void clickContinueButton()
	{
		try
		{
			driver.switchTo().activeElement();
			//driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
			 waitForEle(clickContinueBtns, 120);
			focusElement(driver, clickContinueBtns);
			clickContinueBtns.click();
			Reporter.log("PASS : Clicked on the Continue button from the Choose Departure AIrport popup");
		}
		catch(Exception ex)
		{
			Reporter.log("FAIL : Not clicked on the Continue button from the Choose Departure AIrport popup");
			Reporter.log(ex.getMessage().toString());
		}
	}
	
	//Select Airport for Converted Booking
	public void selectDeptAirportConvertedBook()
	{
		try
		{
			driver.switchTo().activeElement();
			driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
			focusElement(driver, selectDeptAirport);
			Select airports = new Select(selectDeptAirport);
			List<WebElement> airportsList = airports.getOptions();
			int airportCount = airportsList.size();
			int selectAirport = ran.nextInt(airportCount);			
			airports.selectByIndex(selectAirport);
			Reporter.log("PASS : Airport is selected for Converted Booking.");
			WebElement airportName = airports.getFirstSelectedOption();
			Reporter.log("PASS : Selected Airport name is - " + airportName.getText().toString());		
		}
		catch (Exception e)
		{
			Reporter.log("FAIL : Airport is not selected for Converted Booking");
			Reporter.log(e.getMessage().toString());
		}
	}

	//Click on the Add Flights Button
	public void clickAddFlightsButton()
	{
		try
		{			
			waitForEle(btnAddFlights, 120);
			btnAddFlights.click();
			Reporter.log("PASS : Add Flights button is clicked");
		}
		catch (Exception e)
		{
			Reporter.log("FAIL : Add Flights button is not clicked");
			Reporter.log(e.getMessage().toString());
		}
	}
	
	//Check Title of the Edit Flights Pop up
	public void checkTitleEditFlightsPopup()
	{
		try
		{			
			String expTitle = "Edit Flight Details";
			waitForEle(titleEditFlightspopup, 120);
			String actTitle = titleEditFlightspopup.getText().toString();					
			if(expTitle.equals(actTitle))
			{
				Reporter.log("Title of the Edit Flight popup is matched - " + actTitle);
			}
			else
			{
				Reporter.log("FAIL : Title of the Edit Flight popup is not matched" + actTitle);
			}
			
		}
		catch(Exception ex)
		{
			Reporter.log("FAIL : Title of the Edit Flight popup is not found");
			Reporter.log(ex.getMessage().toString());
		}
	}
	
	//Click on the Continue button from Add More Flights pop up.
	public void clickContinueAddMOreFlights()
	{		
		try
		{
			driver.manage().timeouts().implicitlyWait(90,TimeUnit.SECONDS) ;			
			waitForEle(btnContinueAddMoreFlights, 120);
			btnContinueAddMoreFlights.click();
			Reporter.log("PASS : Click on the Continue button from Add More Flights popup");
		}
		catch(Exception ex)
		{
			Reporter.log("FAIL : Not able to click on the Continue button from Add More Flights popup ");
			Reporter.log(ex.getMessage().toString());
		}
	}
	
	//Check Title of the Add More Flights Pop up
	public void titleAddMoreFlightsPopup()
	{
		try
		{						
			String expTitle = "Add More Flights";
			waitForEle(titleAddMoreFlights, 120); 
			String actTitle = titleAddMoreFlights.getText().toString();
		if(expTitle.equals(actTitle))
		{
			Reporter.log("PASS : Title of the Add More Flights is matched - " + actTitle);
		}
		else
		{
			Reporter.log("FAIL : Title of the Add More Flights is not matched -" + actTitle);
		}
		
		}
		catch (Exception e)
		{
			Reporter.log("FAIL : Title of Add More Flights is not found");
			Reporter.log(e.getMessage().toString());			
		}
	}
	
	//Check Add More flights functionality from Add More Flights Pop up 
	public void addFlights()
	{
		try
		{
			driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS) ;
			focusElement(driver, flightAdd);
			Select flights = new Select(flightAdd);
			List<WebElement> availableFlights = flights.getOptions();
			int addFlightsCount = availableFlights.size();
			int selectFlight = ran.nextInt(addFlightsCount);
			flights.selectByIndex(selectFlight);
			Reporter.log("PASS : Able to add more flights");
			Thread.sleep(4000);	
			flights.selectByIndex(0);
		}
		catch(Exception ex)
		{
			Reporter.log("FAIL : Not able to add more flights");
			Reporter.log(ex.getMessage().toString());
		}
	}
		
	//Click on the Add More Flights button.
	public void clickAddMoreFlights()
	{
		try
		{			
			waitForEle(btnAddMoreFlights, 120);
			btnAddMoreFlights.click();
			Reporter.log("PASS : Click on the Add More Flights button.");			
		}
		catch(Exception ex)
		{
			Reporter.log("FAIL : Not Clicked on the Add More Flights button.");
			Reporter.log(ex.getMessage().toString());			
		}
	}
	
	//Click on the Continue button from Edit Flight POpup.
	public void clickContinuebtn()
	{
		try
		{
			waitForEle(btnContinueEditFlight, 120);
			Thread.sleep(10000);
			btnContinueEditFlight.click();
			Reporter.log("PASS : Clicked on the Continue Button");			
		}
		catch (Exception e)
		{
			Reporter.log("FAIL : Not clicked on the Continue Button");
			Reporter.log(e.getMessage().toString());
		}
	}
	
	//Click on the Clear All button from Edit Flight POpup.
	public void clickClearAllBtn()
	{
		try
		{			
			waitForEle(btnClearAll, 120);
			btnClearAll.click();
			Reporter.log("PASS : Click on the Clear All Button");
		}
		catch (Exception e)
		{
			Reporter.log("FAIL : Not clicked on the Clear All button.");
			Reporter.log(e.getMessage().toString());
		}
	}
	
	
	//Select another Flight from the Other Flight options
	public void selectFlight()
	{
		try
		{
			if(!ListFlightsCheckboxes.isEmpty())
			{
				Thread.sleep(5000);				
				int flightCount = ran.nextInt(ListFlightsCheckboxes.size());				
				ListFlightsCheckboxes.get(flightCount).click();
				Reporter.log("PASS : Another Flight is selected");				
			}
			else
			{
				Reporter.log("PASS : No Flight checkboxes are available for selection");
			}		
		}
		catch(Exception ex)
		{			
				Reporter.log("FAIL : Another Flight is not selected.");
				Reporter.log(ex.getMessage().toString());
		}
	}
	
	
	//Select only one Airline from Airlines Check box	
	public void selectFlightPaymentType()
			{
				try
				{	
					if(!ListFlightPaymentChkBoxes.isEmpty())
					{
						Thread.sleep(5000);						
						int FlightPayCount = ran.nextInt(ListFlightPaymentChkBoxes.size());	
						//WebElement FlightPayCheck = waitForElement(driver, 150, ListFlightPaymentChkBoxes.get(FlightPayCount));
						ListFlightPaymentChkBoxes.get(FlightPayCount).click();
						Reporter.log("PASS : Flight Payment Checkbox is selected");					
					}
					else
					{
						Reporter.log("PASS : Flight Payment checkboxes are not available for selection");
					}
				}
				catch(Exception ex)
				{
						Reporter.log("FAIL : Flight Payment Checkbox is not selected");
						Reporter.log(ex.getMessage().toString());					
				}
			}
		
	
	//Select only one Airline from Airlines Check box	
	public void selectCheckboxAirline()
		{
			try
			{					
				if(!ListAirlinesChkBoxes.isEmpty())
				{
					Thread.sleep(5000);					
					int AirlinesCount = ran.nextInt(ListAirlinesChkBoxes.size());						
					//WebElement airlineNum = waitForElement(driver, 120, ListAirlinesChkBoxes.get(AirlinesCount));	
					ListAirlinesChkBoxes.get(AirlinesCount).click();
					Reporter.log("PASS : Airline Checkbox is selected");											
				}				
				else
				{
					Reporter.log("PASS : Airline checkboxes are not available for selection");
				}				
			}
			catch(Exception ex)
			{
					Reporter.log("FAIL : Airline Checkbox is not selected");
					Reporter.log(ex.getMessage().toString());				
			}
		}
	
	
	//Select only one airport from UK Departure Airport Check box	
	public void selectCheckboxUKArrAirport()
	{
		try
		{
			if(!ListUKArrAirportChkBoxes.isEmpty())
			{
				Thread.sleep(5000);				
				int AirArrCount = ran.nextInt(ListUKArrAirportChkBoxes.size());			
				//WebElement arrivalAirNum = waitForElement(driver, 120, ListUKArrAirportChkBoxes.get(AirArrCount));					
				ListUKArrAirportChkBoxes.get(AirArrCount).click();
				Reporter.log("PASS : UK Arrival Airport Checkbox is selected");	
			}
			else
			{
				Reporter.log("PASS : UK Arrival Aiport checkboxes are not available for selection");
			}
		}
		catch(Exception ex)
		{
				Reporter.log("FAIL : UK Arrival Airport Checkbox is not selected");
				Reporter.log(ex.getMessage().toString());			
		}
	}
		
	
	//Select only one airport from UK Departure Airport Check box	
	public void selectCheckboxUKDeptAirport()
		{
			try
			{
				if(!ListUKDeptAirportChkBoxes.isEmpty())
				{
					Thread.sleep(5000);						
					int AirDepCount = ran.nextInt(ListUKDeptAirportChkBoxes.size());								
					//WebElement DepAirNum = waitForElement(driver, 120, ListUKDeptAirportChkBoxes.get(AirDepCount));						
					ListUKDeptAirportChkBoxes.get(AirDepCount).click();
					Reporter.log("PASS : UK Departure Airport Checkbox is selected");					
				}
				else
				{
					Reporter.log("PASS : UK Departure checkboxes are not available for selection");
				}
			}
			catch(Exception ex)
			{
					Reporter.log("FAIL : UK Departure Airport Checkbox is not selected");
					Reporter.log(ex.getMessage().toString());
				
			}
		}
	
	//Move the slider to the Left
	
	
	public void slideOutboundLeft()


		{
			try
			{
			driver.manage().timeouts().implicitlyWait(90,TimeUnit.SECONDS) ;	
			Actions slider = new Actions(driver);
			Action act = slider.dragAndDropBy(leftSlideerOutbound,0,02).build();
			act.perform();
			Reporter.log("PASS : Performed Slider Movement on the Left");
			driver.manage().timeouts().implicitlyWait(90,TimeUnit.SECONDS) ;
			}
			catch (Exception e)
			{				
				Reporter.log(e.getMessage().toString());
				Reporter.log("FAIL : No Slider Movement");
			}
		}
	
	//Move the slide position to the Right
	
	
	//Move the slider to the right
	public void slideOutboundRight()
	{
		try
		{
		driver.manage().timeouts().implicitlyWait(90,TimeUnit.SECONDS) ;	
		Actions slider = new Actions(driver);
		Action act = slider.dragAndDropBy(rightSlideerOutbound,02, 0).build();
		act.perform();
		Reporter.log("PASS : Performed Slider Movement on the Right");
		}
		catch (Exception e)
		{	
			Reporter.log("FAIL : No Slider Movement");
			Reporter.log(e.getMessage().toString());
		}
	}
	
		
	//Select the Sort By Option
	public void selectSortoptions()
	{
		try
		{
			driver.manage().timeouts().implicitlyWait(90,TimeUnit.SECONDS) ;		
			focusElement(driver, sortOptions);
			sortOptions.click();
			driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS) ;
			WebElement sortOptionsDisplay = driver.findElement(By.xpath("//ul[@id='flightSort']"));
			List<WebElement> SortOptList = sortOptionsDisplay.findElements(By.tagName("li"));		
			int SortOptionCount = SortOptList.size();
			int SortOptClick = ran.nextInt(SortOptionCount);
			SortOptList.get(SortOptClick).click();	
			Reporter.log("PASS : Sort Option is selected" + SortOptList.get(SortOptClick).getText().toString());
		}
		catch(Exception ex)
		{
			
			Reporter.log("FAIL : No Sort Option is selected.");
			Reporter.log(ex.getMessage().toString());
		}
	}
			
	
	
	//Select the Airport from change UK Departure Airport
	public void selectAirport()
	{
		try
		{	
			driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS) ;
			focusElement(driver, airportList);
			Select airports = new Select(airportList);			
			List<WebElement> airportsSize = airports.getOptions();	
			int airportCount = airportsSize.size();
			int airportSelect = ran.nextInt(airportCount);
			airports.selectByIndex(airportSelect);
			Thread.sleep(10000);				
			//WebElement airportName = waitForElement(driver, 120, airports.getFirstSelectedOption());
			String nameAirport = airports.getFirstSelectedOption().getText().toString();
			Reporter.log("PASS : Selected Airport Name is " + nameAirport);
			driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS) ;
		}
		catch(Exception ex)
		{
			Reporter.log(ex.getMessage().toString());
			Reporter.log("FAIL : Airport is not selected");
		}
	}
			
	
	//Click on the Edit Button
	public void clickEditFlightButton()
	{
		try
		{
			EditFlightButton.click();
			driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS) ;
			Reporter.log("PASS : Edit Flight Button is clicked");			
		}
		catch(Exception ex)
		{
			Reporter.log(ex.getMessage().toString());
			Reporter.log("FAIL : Not able to click on the Edit Flight Button.");
		}
	}	
			
	public FlightsPageObjects(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this.driver);
	}
	
	public void verifyFlightsPageOpened()
	{
		String ExpTitle = "Villa Plus | Flights ";
		String ActTitle = driver.getTitle();
		try {
			
			if(ExpTitle.contains(ActTitle))
			{
				Reporter.log("PASS : \"Flights\" Page Opened.");
			}
		}
		catch(Exception e)
		{
			Reporter.log("FAIL : Could Not Open \"Flights\" Page."+e.getMessage());
		}

	}
	
	public void verifyVillaDetails()
	{
		String ActTxt = VillaDetailsSection.getText();
		String ExpTxt = "Some Text";
		
		try 
		{	
			if(ActTxt.contains(ExpTxt))
			{
				Reporter.log("PASS : \"Villa Details\" text is matched.");
			}
		}
		catch(Exception e)
		{
			Reporter.log("FAIL : \"Villa Details\" text is not matched."+e.getMessage());
		}
		
	}
	
	public void clickBackToSRPageBtn()
	{
		try 
		{
			BackBtntoSRPage.click();
			Reporter.log("PASS : Clicked \"Back\" Button From \"Flights\" Page.");
			
		}
		catch(Exception e)
		{
			Reporter.log("FAIL : Could not click \"Back\" Button From \"Flights\" Page."+e.getMessage());
		}		
	}
	
	public void clickContinueBtnFromFlights()
	{
		try
		{
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			focusElement(driver, ContinueBtnFromFlights);
			ContinueBtnFromFlights.click();
			Reporter.log("PASS : Clicked \"Continue\" Button From \"Flights\" page.");
			
		}
		catch (Exception e) 
		{
		Reporter.log("FAIL : Could Not Click \"Continue\" Button From \"Flights\" page."+e.getMessage());
		}
	}
}
