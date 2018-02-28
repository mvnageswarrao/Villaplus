package com.vp.objects;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.vp.utils.BaseUtils;

public class GroupDetailPageObjects extends BaseUtils {

	
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
	 @FindBy(xpath = "//input[starts-with(@id,'Email_')]")
	 List <WebElement> EmailList;
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

	public GroupDetailPageObjects(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this.driver);
	}
	
	public void insertAddress1(String Address) {
		try {
			Address1.sendKeys(Address);
			logWriter("PASS :");
		}
		catch(Exception e ) {
			
			logWriter("FAIL :" +e.getMessage());
		}
	}
	
	public void insertAddress2(String Address) {
		try {
			Address2.sendKeys(Address);
			logWriter("PASS :");
		}
		catch(Exception e ) {
			
			logWriter("FAIL :" +e.getMessage());
		}
	}
	
	public void insertAddress3(String Address) {
		try {
			Address3.sendKeys(Address);
			logWriter("PASS :");
		}
		catch(Exception e ) {
			
			logWriter("FAIL :" +e.getMessage());
		}
	}
	
	public void insertAddress4(String Address) {
		try {
			Address4.sendKeys(Address);
			logWriter("PASS :");
		}
		catch(Exception e ) {
			
			logWriter("FAIL :" +e.getMessage());
		}
	}

	public void insertNonUKCode() {
		try {
			NonUKPostCode.sendKeys("ash7357t979");
			logWriter("PASS :");
		}
		catch(Exception e) {
			logWriter("FAIL :"+e.getMessage());
		}
	}
	//Function for Click on I Agree button When we continue from Group Details page
	public void ClickbtnIAgree() {
		
		try {
		
			driver.findElement(By.id("BtnOk")).click();
			logWriter("PASS : Click on I Agree Button");
		}
		catch(Exception e) {
			
			logWriter("FAIL :" +e.getMessage());
		}
	}
	//Function for to select the Address Using Postal code
	public void SelectAddressFromLookUp() {
		try {
			
			List<WebElement> SelectAddList=driver.findElements(By.name("optAddressSelection"));
			int index=RandomGenerator(SelectAddList.size()-1);
			SelectAddList.get(index).click();
			ClickbtnConfirmAddLookUp();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
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
					logWriter("PASS :  Adding Manual Address ");
			}
			
			catch(Exception e) {
					logWriter("FAIL :" + e.getMessage());
					System.out.println(e.getMessage());
			}
	}
	
	
	
	public void SelectTitleDropdown() {
		
		try {

			for (WebElement w: TitleList) {
				w.click();
				logWriter("PASS : \\ Title is Clickable" );
				try {
					 Select seltitle=new Select(w);
					 List<WebElement> DropdownList =seltitle.getOptions();
					 int Count=DropdownList.size();
					 int index=RandomGenerator(Count-2);
					 seltitle.selectByIndex(1);
					 logWriter("PASS : \\ Title is Selected" );
		        }
			
			catch(Exception e) {
				
				logWriter("FAIL : " + e.getMessage());
			}
		   }
		}
		catch(Exception e) {
			logWriter("FAIL : " + e.getMessage());
		}
	}
	public static int RandomGenerator(int Limit) {
		 Random randomGenerator = new Random();
		 int randomInt = randomGenerator.nextInt(Limit);
		 return randomInt;
	}
	
	public void insertFname() {
		
		try {
			int i=0;
			for(WebElement w: FnameList) {
				if(i==0) {
					w.sendKeys("test");
				}
				else {
					w.sendKeys("abcd");
				}
				i++;
				logWriter("PASS : Adding First Name " );
			}
		}
		
		catch(Exception e) {
			logWriter("FAIL : Adding First Name " + e.getMessage());
			
		}
	}
	
	public void insertLname() {
			
			try {
				int i=0;
				for(WebElement w: LnameList) {
					if(i==0) {
						w.sendKeys("test");
					}
					else {
						w.sendKeys("abcd");
					}
					i++;
					logWriter("PASS : Adding Last Name " );
				}
			}
			
			catch(Exception e) {
				logWriter("FAIL : " + e.getMessage());
				
			}
		}
	
	public void insertEmail(String EmailId) {
		
		try {
			for(WebElement w: EmailList) {
				w.sendKeys(EmailId);
				logWriter("PASS : Adding EmailId ");
			}
			
		 }
		
		catch(Exception e) {
			logWriter("FAIL : Adding EmailId" + e.getMessage());
			
		}
	}
   
	public void insertConEmail(String EmailId) {
		
		try {
				ConEmailList.sendKeys(EmailId);
				logWriter("PASS : Adding Confirm EmailId ");
			 }
		
		catch(Exception e) {
			logWriter("FAIL : Adding Confirm EmailId" + e.getMessage());
			
		}
	}
	
	public void SelectAgeGroup() {
		
		
		try {
			for(WebElement w:AgeGrouptList) {
				Select selAgeGroup=new Select(w);
				w.click();
				List<WebElement> AgeGroupList=selAgeGroup.getOptions();
				int Count=AgeGroupList.size();
				int index=RandomGenerator(Count-1);
				selAgeGroup.selectByIndex(index);
				logWriter("PASS : Adding Age" );
			}
		}
		catch(Exception e) {
			
			logWriter("FAIL : " + e.getMessage());
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
				logWriter("PASS: ");
			}
		}
		
		catch(Exception e) {
			logWriter("FAIL : " + e.getMessage());
			
		}
	}
	
	public void insetPostCode(String PostCode) {
		
		try {
			PostCodeLookup.sendKeys(PostCode);
		}
		
		catch(Exception e) {
			logWriter("FAIL : " + e.getMessage());
		}
	}
	public void SelectAboutUsDropdown() {
		
		try {
		for(WebElement w:ReferralSourceList) {			
			 Select seltitle=new Select(w);
			 w.click();
			 List<WebElement> DropdownList =seltitle.getOptions();
			 int Count=DropdownList.size();
			 int index=RandomGenerator(Count-1);
			 seltitle.selectByIndex(index);
		}
		}
		catch(Exception e) {
			logWriter("FAIL : "+ e.getMessage());
			System.out.println(e.getMessage());
		}
	}

	
	public void insertDayPhoneCode(String Code) {
		try {
			
			DayPhoneNoCode.sendKeys(Code);
			logWriter("PASS : Adding a Day Phone no Code " );
		}	
		
		catch(Exception e) {
			logWriter("FAIL :" + e.getMessage());
		}		
	}
	
	public void insertDayPhoneNo(String DayNo ) {
		try {
			DayPhoneNO.sendKeys(DayNo);
		}
		catch(Exception e){
			
			
		}
	}
	
	public void insertMobileNo(String No) {
	
		try {
			
			MobileNo.sendKeys(No);
		}
		catch(Exception e) {
			
		}
	}
	public void ClickDropdownCountry() {
		
		try {
			CountryDropdown.click();			
		}
		catch(Exception e) {
			
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
				
				logWriter("PASS : \"Group Detail\" page Title is "+ ActTitle);
			}
			
			else {
				
				logWriter("FAIL : \"Group Detail\" Page Title is " + ActTitle);
				
			}
		}
		catch(Exception e) {
			logWriter("FAIL : " + e.getMessage());
		}
	}
	
	
	// Function to Verify the URL of the Group Detail page 
	 public void verifyURLGrpDetailPage() {
		
		String ExpURL="https://www.villaplus.com/booking/group-details";
		String ActURL=driver.getCurrentUrl();
		
        try {
			
			if(ExpURL == ActURL) {
				
				logWriter("PASS : \"Group Detail\" Page URL .");
			}
			
			else {
				
				logWriter("FAIL : \"Group Detail\" Page URL.");
			  }
		   }
	     catch(Exception e) {
	    	 logWriter("FAIL : \"Group Detail\" Page URL." + e.getMessage());
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
			 logWriter("FAIL : \"Group Detail\" Page URL." + e.getMessage());
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
			 logWriter("FAIL :" +e.getMessage());
			 
		 }
	 }
	 public void DeSelectchkBoxNewsLetter() {
		 
		 try {
			 
			 for(WebElement w:ChkBoxList) {
				 if(w.isSelected()) {
				   w.click();
				   logWriter("PASS : Succesfully Deselecting the News Letter checkbox");
			    }
		    }
		 }
		 catch(Exception e){
			 System.out.println(e.getMessage());
			 logWriter("FAIL :"+e.getMessage());
		 }
		 
	 }
	 
	// Function To Click the continue button on Group Detail page
	 public void ClickbtnContinue() {
		focusElement(driver, Continue); 
		//waitForEle(Continue, 30);
		 try {
			 Continue.click();
		 }
		// @FindBy(how = How.ID, using = "btnsub")
		 catch(Exception e) {
			 System.out.println(e.getMessage());
		 }
	 }
	 
	 
	 //Function to Click the Back button of Group Detail page
	 public void ClickbtnBack() {
		 
		// Back=driver.findElement(By.id("btngrback"));
		 Back.click();
		 
	 }
	
	 //Function to Click The Look up Address
	 public void ClickbtnLookUpAddresss() {
		 lookUp.click();
	 }
	 
	 	
	}
	
	

