package com.vp.tests;

import java.io.IOException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.vp.objects.ExtrasPageObjects;
import com.vp.utils.BaseUtils;

public class ExtrasPageTests extends BaseUtils{
	
	ExtrasPageObjects ExtrasPage;
	
	@Test(priority=6,groups= {"PKBooking","VOBooking"})
	public void VerifyExtrasPage() throws IOException, InterruptedException
	{
		ExtrasPage = PageFactory.initElements(driver, ExtrasPageObjects.class);
		ExtrasPage.verifyExtrasPageOpened();
		ExtrasPage.clickContinueBtnFromExtras();
		ExtrasPage.clickIAgreeBtnFromExtras();
	}

}
