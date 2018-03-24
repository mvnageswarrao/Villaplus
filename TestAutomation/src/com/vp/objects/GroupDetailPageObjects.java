package com.vp.objects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.vp.utils.BaseUtils;

public class GroupDetailPageObjects extends BaseUtils {
	GroupDetailPageObjects GD;
	public String[] Insurance;
	List<String> Insurance1 = new ArrayList <String>();
	@FindBy(how=How.ID,using = "btngrpack")
	 WebElement Back;	
	 @FindBy(id="btnsub")
	 WebElement Continue;
	 @FindBy(how=How.ID,using ="anchrPostCode")
	 WebElement lookUp; 
	 @FindBy(how=How.XPATH, using="//select[starts-with(@id,'Title_')]")
	 List<WebElement> TitleList; 
	 @FindBy(how=How.XPATH, using="//input[contains(@id,'FName_')]")
	 List <WebElement> FnameList;
	 @FindBy(xpath = "//input[contains(@id,'LName_')]")
	 List <WebElement> LnameList;
	 @FindBy(id="Email_0")
	 WebElement EmailAddress;
	 @FindBy(xpath = "//input[starts-with(@id,'ConEmail_')]")
	 WebElement ConEmailList;
	 @FindBy(xpath = "//input[starts-with(@id,'chkEnews_')]")
	 List <WebElement> ChkBoxList;	
	 @FindBy(xpath = "//input[contains(@id,'chkArptAsst_')]")
	 List <WebElement> ChkArptAsstList;
	 @FindBy(xpath = "//input[contains(@id,'chkVillaAsst_')]")
	 List <WebElement> ChkVillaAsstList;
	 @FindBy(xpath = "//select[contains(@id,'__Insurance')]")
	 List <WebElement> InsuranceList;
	 @FindBy(xpath = "//select[contains(@id,'_ReferralSource')]")
	 List <WebElement> ReferralSourceList; 
	 @FindBy(xpath = "//select[contains(@id,'__AgeGroup')]")
	 List <WebElement> AgeGrouptList;
	 @FindBy(xpath = "//select[contains(@id,'__Nationality')]")
	 List <WebElement>NationalityList;
	 
	 @FindBy(id="txtSelUKPostCode")
	 WebElement PostCodeLookup;
	 @FindBy(id="countrydropdown")
	 WebElement CountryDropdown;	 
	 @FindBy(id="txtAddr1")
	 WebElement Address1;
	 @FindBy(id="txtAddr2")
	 WebElement Address2;
	 @FindBy(id="txtAddr3")
	 WebElement Address3;
	 @FindBy(id="txtAddr4")
	 WebElement Address4;
	 @FindBy(id="txtNonUkPostCode")
	 WebElement NonUKPostCode; 
	 @FindBy(id="txtTelDayAC")
	 WebElement DayPhoneNoCode;
	 @FindBy(id="txtTelDay")
	 WebElement DayPhoneNO;
	 @FindBy(id="txtTelEvenAC")
	 WebElement EvenPhoneNoCode;
	 @FindBy(id="txtTelEven")
	 WebElement EvenPhoneNo;
	 @FindBy(id="txtTelMobileUK")
	 WebElement MobileNo;
	 String Country;
	 @FindBy(id="TtlPrize")
	 WebElement TotalPrize;

	public GroupDetailPageObjects(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this.driver);
	}
	
	
	
	public void insertAddress1(String Address)
		{
			try {
				Address1.sendKeys(Address);
				Reporter.log("PASS :");
			}
			catch(Exception e )
			{
			
				Reporter.log("FAIL :" +e.getMessage());
			}
	}
	
	
	public void insertAddress2(String Address) 
		{
			try 
			{
				Address2.sendKeys(Address);
				Reporter.log("PASS :");
			}
			catch(Exception e ) 
			{
			
				Reporter.log("FAIL :" +e.getMessage());
			}
	}
	
	

	public void insertAddress3(String Address) 
	{
		try 
		{
			Address3.sendKeys(Address);
			Reporter.log("PASS :");
		}
		catch(Exception e ) {
			
			Reporter.log("FAIL :" +e.getMessage());
		}
	}
	
	public void insertAddress4(String Address) {
		try {
			Address4.sendKeys(Address);
			Reporter.log("PASS :");
		}
		catch(Exception e ) {
			
			Reporter.log("FAIL :" +e.getMessage());
		}
	}

	public void insertNonUKCode() {
		try {
			NonUKPostCode.sendKeys("ash7357t979");
			Reporter.log("PASS :");
		}
		catch(Exception e) {
			Reporter.log("FAIL :"+e.getMessage());
		}
	}
	//Function for Click on I Agree button When we continue from Group Details page
	public void ClickbtnIAgree() {
		
		try {
		
			driver.findElement(By.id("BtnOk")).click();
			Reporter.log("PASS : Click on I Agree Button from Insurance pop-up");
		}
		catch(Exception e) {
			
			Reporter.log("FAIL : Could not click on \"I Agree\" button  from Insurance pop-up" +e.getMessage());
		}
	}
	//Function for to select the Address Using Postal code
	public void SelectAddressFromLookUp() {
		try 
		{
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				List<WebElement> SelectAddList=driver.findElements(By.name("optAddressSelection"));
				int index=RandomGenerator(SelectAddList.size()-1);
				SelectAddList.get(index).click();
				ClickbtnConfirmAddLookUp();
				Reporter.log("PASS :\\ Address is selected from Look Up Address pop-up" );				
		}
	
		catch(Exception e)
		{
			Reporter.log("FAIL :\\ Address is not selected form Address Look Up pop-up " +e.getMessage());
		}
	}
	
	public boolean isLookUpAddressErrPopup() {
		 
		    try 
		    {	   
		    	  driver.switchTo().activeElement();
		    	  Thread.sleep(5000);
		    	  driver.findElement(By.id("btnPostCode"));                   
		          return true;  	             

		    }    
		    catch (NoSuchElementException | InterruptedException e) 
		    { 
		        return false; 
		    }   
		}   
		
	
	
	public void insertPostCode(String PostCode) {
		try {
			
			PostCodeLookup.sendKeys(PostCode);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			
		}
	}
	
	public static void ClickbtnConfirmAddLookUp() {
		try {
			driver.findElement(By.id("btnPostCodeConfirm")).click();
		}
		
		catch(Exception e) {
			System.out.println(e.getMessage());
			
		}
	}
	public void insertEmailAdrressManually() {
		
		WebElement HouseName_No=driver.findElement(By.id("txtProperty")); 
		WebElement Street=driver.findElement(By.id("txtStreet_0"));
		WebElement Town_City=driver.findElement(By.id("txtTown"));
		WebElement Country=driver.findElement(By.id("txtCounty"));
		WebElement UKPostCode=driver.findElement(By.id("txtUKPostCode"));
			try {
					HouseName_No.sendKeys("7855");
					Street.sendKeys("fvfbbg");
					Town_City.sendKeys("kfhvhjh");
					Country.sendKeys("UK");
					UKPostCode.sendKeys("al3 4bh");
					Reporter.log("PASS :  Adding Manual Address ");
			}
			
			catch(Exception e) {
					Reporter.log("FAIL :" + e.getMessage());
				
			}
	}
	
	public void Title() {
		for(WebElement w : TitleList) {
			w.click();
			Select Sel= new Select(w);
			List<WebElement> DropdownList1 =Sel.getOptions();
			int Count=DropdownList1.size();
			 int index=RandomGenerator(Count-2);
			 Sel.selectByIndex(index);
			
		}
		
	}
	
	public void SelectTitleDropdown() {
		
		try {            
			for (WebElement Title: TitleList)
			{
				focusElement(driver,Title);
				Title.click();
				Reporter.log("PASS : \\ Title is Clickable" );
					 Select seltitle=new Select(Title);
					 List<WebElement> DropdownList =seltitle.getOptions();
					 int Count=DropdownList.size();
					 int index=RandomGenerator(Count-2);
					 seltitle.selectByIndex(index);
		   }
			Reporter.log("PASS : \\ Title of all pax is Selected" );
		}
		catch(Exception e) {
			Reporter.log("FAIL : Title of all pax is not Selected " + e.getMessage());
		}
	}
	
// Function for Random generator 	
	
	public static int RandomGenerator(int Limit) {
		 Random randomGenerator = new Random();
		 int randomInt = randomGenerator.nextInt(Limit);
		 return randomInt;
	}
//function for inserting the all pax first Name
	
	public void insertFname() {
		
        try
        {
        	  char forename = 'A';
              for(WebElement FnameBox : FnameList)
              {
                    
                    if(FnameBox.getAttribute("id").contains("FName_") )
                    {
                          FnameBox.sendKeys("Test First Name "+ forename);
                          forename++;
                    }
              }
              Reporter.log("PASS : Entered First Names for All Pax.");
        }
        catch (Exception e) 
        {
              Reporter.log("FAIL : Could Not enter Pax First Names."+e.getMessage());

			
		}
	}
	
//Function for inserting the all pax last Name 	
	
	public void insertLname() {
			
		try
        {
			  char forename = 'A';
              for(WebElement LnameBox : LnameList)
              {
                    
                    if(LnameBox.getAttribute("id").contains("LName_") )
                    {
                          LnameBox.sendKeys("Test Last Name "+ forename);
                          forename++;
                    }
              }
              Reporter.log("PASS : Entered Land Names for All Pax.");
        }
        catch (Exception e) 
        {
              Reporter.log("FAIL : Could Not enter Pax Last Names."+e.getMessage());

			
		}
	}
	
// function for Insert Email Address on GD page	
	public void insertEmail(String EmailId) {
		
		try {
			 	EmailAddress.sendKeys(EmailId);
				Reporter.log("PASS : Adding EmailId ");
			}
				
		
		catch(Exception e) {
			Reporter.log("FAIL : Could not entered EmailId " + e.getMessage());
			
		}
	}
   
	public void insertConEmail(String EmailId)
		{
		
			try 
			{
			
				ConEmailList.sendKeys(EmailId);
				Reporter.log("PASS : Adding Confirm EmailId ");
			}
	
		catch(Exception e)
			{
				Reporter.log("FAIL : could not Add Confirm EmailId" + e.getMessage());
			
		}
	}
	
/*
 * Function for selecting Age group of all pax
 */
	public void SelectAgeGroup() {
		
		
		try
		{
			    for(WebElement AgeGroup:AgeGrouptList)
			    {
			    	Select selAgeGroup=new Select(AgeGroup);
			    	AgeGroup.click();
			    	List<WebElement> AgeGroupList=selAgeGroup.getOptions();
			    	int Count=AgeGroupList.size();
			    	int index=RandomGenerator(Count-2);
			    	selAgeGroup.selectByIndex(index);
			    
			}
			Reporter.log("PASS : Selecting Age Group for all Pax" );
		}
		catch(Exception e)
		{
			Reporter.log("FAIL : Could not selected Age group for all Pax " + e.getMessage());
		}
		
	}
	
	public void SelectNationality() {
		try {
			
			for(WebElement w: NationalityList) {
				w.click();
				Select selNationality=new Select(w);
				List<WebElement> NationalityList=selNationality.getOptions(); 
				int Count=NationalityList.size();
				int index=RandomGenerator(Count-1);
				selNationality.selectByIndex(index);
				Reporter.log("PASS: ");
			}
		}
		
		catch(Exception e) {
			Reporter.log("FAIL : " + e.getMessage());
			
		}
	}
	
	public void insetPostCode(String PostCode)
		{
		
			try 
			{
				PostCodeLookup.clear();
				PostCodeLookup.sendKeys(PostCode);
				Reporter.log("PASS : Adding post code " );
			}
		
			catch(Exception e)
			{
				Reporter.log("FAIL : Not added post code" + e.getMessage());
			}
	}
	public void SelectAboutUsDropdown() {
		
		try {
		for(WebElement AboutUsDropDowm:ReferralSourceList) {			
			 Select seltitle=new Select(AboutUsDropDowm);
			 AboutUsDropDowm.click();
			 List<WebElement> DropdownList =seltitle.getOptions();
			 int Count=DropdownList.size();
			 int index=RandomGenerator(Count-1);
			 seltitle.selectByIndex(index);
		}
		}
		catch(Exception e) {
			Reporter.log("FAIL : "+ e.getMessage());
			System.out.println(e.getMessage());
		}
	}

	
	public void insertDayPhoneCode(String Code) {
		try
		{
			DayPhoneNoCode.sendKeys(Code);
			Reporter.log("PASS : Adding a Day Phone no Code " );
		}	
		
		catch(Exception e)
		{
			Reporter.log("FAIL : Not Add Day phone no code " + e.getMessage());
		}		
	}
	
	public void insertDayPhoneNo(String DayNo ) {
		try 
		{
			DayPhoneNO.sendKeys(DayNo);
			Reporter.log("PASS : Adding a Day Phone Number" );
		}
		catch(Exception e)
		{
			Reporter.log("FAIL : Not Added a Day Phone Number" + e.getMessage() );
			
		}
	}
	
	public void insertMobileNo() {
	
		try 
		{
			int Positon_first=RandomGenerator(9);
			int Positon_Last=RandomGenerator(9);
			MobileNo.sendKeys(Positon_first + "545454547" + Positon_Last);
			Reporter.log("PASS : Adding Mobile Number" );
		}
		catch(Exception e)
		{
			Reporter.log("FAIL :Not Added Mobile Number" );
		}
	}
	public void ClickDropdownCountry()
		{
		
			try 
			{
				CountryDropdown.click();			
			}
			catch(Exception e)
			{
			
			}
	}
	
	public void selectCountryDropdown() {
		try {	
		int index;
		CountryDropdown.click();
		Select selCountry=new Select(CountryDropdown);
		List<WebElement> CountryDropdownList =selCountry.getOptions();
		int size=CountryDropdownList.size();
		index=RandomGenerator(size-1);
		selCountry.selectByIndex(index);
		//Country=CountryDropdown(index);
	}
		catch(Exception e) {
			
			
		}
	}
	//Function to Check the Group Detail Page load or not 
	public void verifyGroupDetailPageTitle() {
		
		String ExpTitle ="Villa Plus | Group Details";
		String ActTitle=driver.getTitle();
		try {
			
			if(ExpTitle == ActTitle) {
				
				Reporter.log("PASS : \"Group Detail\" page Title is "+ ActTitle);
			}
			
			else {
				
				Reporter.log("FAIL : \"Group Detail\" Page Title is " + ActTitle);
				
			}
		}
		catch(Exception e) {
			Reporter.log("FAIL : Group Details Page is not match " + e.getMessage());
		}
	}
	
	
	// Function to Verify the URL of the Group Detail page 
	 public void verifyURLGrpDetailPage() {
		
		String ExpURL="https://www.villaplus.com/booking/group-details";
		String ActURL=driver.getCurrentUrl();
		
        try {
			
			if(ExpURL == ActURL) {
				
				Reporter.log("PASS : \"Group Detail\" Page URL .");
			}
			
			else {
				
				Reporter.log("FAIL : \"Group Detail\" Page URL.");
			  }
		   }
	     catch(Exception e) {
	    	 Reporter.log("FAIL : \"Group Detail\" Page URL." + e.getMessage());
	     }
    
     }
	 
	 public void SelectChkBoxNewsLetter() {
		 try {
			for(WebElement w:ChkBoxList) {
				//if(! w.isSelected()) {
				w.click();
				}
			//}	 
		 }
		 
		 catch(Exception e) {
			 System.out.println(e.getMessage());
			 Reporter.log("FAIL : \"Group Detail\" Page URL." + e.getMessage());
		 }	 
	 }
	 
	 public void insertInsurance() {
		 try {
			
			 for(WebElement w:InsuranceList) {
				 w.click();
				 Select selInsurance=new Select(w);
				 List<WebElement> InsuranceList=selInsurance.getOptions();
				 int Count=InsuranceList.size();
				 int index=RandomGenerator(Count-1);				
				 selInsurance.selectByIndex(index);
			 }
			 
		 }
		 catch(Exception e) {
			 Reporter.log("FAIL :" +e.getMessage());
			 
		 }
	 }
	 public void DeSelectchkBoxNewsLetter() {
		 
		 try {
			 
			 for(WebElement w:ChkBoxList) {
				 if(w.isSelected()) {
				   w.click();
				   Reporter.log("PASS : Succesfully Deselecting the News Letter checkbox");
			    }
		    }
		 }
		 catch(Exception e){
			 System.out.println(e.getMessage());
			 Reporter.log("FAIL :"+e.getMessage());
		 }
		 
	 }
	 
	// Function To Click the continue button on Group Detail page
	 
		 public void ClickbtnContinue() {
		 		focusElement(driver, Continue);
		 		 try {
		 			 Continue.click();
		 			Reporter.log("PASS : Suceessfully Click on button \"Continue\"");
		 		 }
		 		 catch(Exception e) {
		 			Reporter.log("FAIL : Could not Click on button \"Continue\"");
		 		 }
		 	 } 

	 
	 
	 //Function to Click the Back button of Group Detail page
	 public void ClickbtnBack() {
		 
		// Back=driver.findElement(By.id("btngrback"));
		 Back.click();
		 
	 }
	
	 //Function to Click The Look up Address
	 public void ClickbtnLookUpAddresss() {
		 try 
		 {
		 lookUp.click();
		 Reporter.log("PASS : Suceessfully Click on button \"Look Up Address\"");
		 }
		 catch(Exception e)
		 {
			 Reporter.log ("FAIL : Not Click on button \"Look Up Address\""+ e.getMessage());
		 }
		 
	 }
	 
	 	
	public String TotalPrizeSummary() {
		focusElement(driver,TotalPrize);
		String Pri=TotalPrize.getText();
		Pri=Pri.substring(8);
		return Pri;
			
	}
	
	public String TotalCost() {
		WebElement TotalCost= driver.findElement(By.id("TotalCost"));
		String totalCost = TotalCost.getText();
		return totalCost;
	}
	 
	
	
	public void SelectVillaAssistance() {
		try {
			for(WebElement w : ChkVillaAsstList ) {
				//if(! w.isSelected()) {
				w.click();
				}
			
			Reporter.log("PASS : ");
				
		}
		
		catch(Exception e) {
			 System.out.println(e.getMessage());
			Reporter.log("FAIL : ");
			
		}
	}
	
	public void SummaryPane() {
		
		
		WebElement Sec = driver.findElement(By.className("section"));
		focusElement(driver,Sec);


		WebElement MinusPlusList= driver.findElement(By.className("minus.plus"));
		focusElement(driver,MinusPlusList);
		
		//System.out.println(MinusPlusList.size());
	}
	
	//Function for selecting random insurance
	public void selectInsurance() {
		try {
			for(WebElement InsuranceDropDown: InsuranceList) {
				Select selInsurance=new Select(InsuranceDropDown);
				 List<WebElement> DropdownList =selInsurance.getOptions();
				 int Count=DropdownList.size();
				 int index=RandomGenerator(Count-1);
				 selInsurance.selectByIndex(index);
				 WebElement a= selInsurance.getFirstSelectedOption();
				 String Insurancestr=a.getText().replaceAll("\\s", "");
				 Insurance1.add(Insurancestr);
			}
			 Reporter.log("PASS : \\ Adding Insurance of all pax " );
		}
		catch(Exception e) {
			Reporter.log("FAIL: \\ Not added Insurance of all pax  " );
		}
		
	}
	
	public void insurencepopupHandle() {
		try {
			int OwnInsurance= Collections.frequency(Insurance1, "Own Insurance x £0.00");
			int IndivisualInsurance= Collections.frequency(Insurance1, "Individual Insurance");
			int FamilyInsurance= Collections.frequency(Insurance1, "Own Insurance x £0.00");
			System.out.println(OwnInsurance +" "+ IndivisualInsurance + " " + FamilyInsurance);
		
		}
		
		catch(Exception e) {
			
		}
	}
	//function to check if any pop-up is open or not 
	
	public boolean isAddressLookupPopOpen() 
	{ 
	    try 
	    {	   
	    	  driver.switchTo().activeElement();
	    	  Thread.sleep(5000);
	    	  driver.findElement(By.id("btnPostCodeConfirm"));                   
	          return true;  	             

	    }   // try 
	    catch (NoSuchElementException | InterruptedException e) 
	    { 
	        return false; 
	    }   // catch 
	}   // isAlertPresent()
	
	}
	
	

