package com.DemoWebShop_TestScripts;

import java.io.IOException;

import org.testng.annotations.Test;

import com.DemoWebShop_GenericUtility.base_Test;
import com.DemoWebShop_POM.Address_Page;

public class Tc_001_verify_user_Is_Able_To_delete_Addresss_or_Not_Test extends base_Test {
	
	@Test
	public void addAddress() throws InterruptedException, IOException {
		
		webDriverUtility.javaScriptScrollIntoView(driver, homePage.getAddressesButton());
		homePage.getAddressesButton().click();
		
		Address_Page addressPage = new Address_Page(driver);
		addressPage.getDeleteButton().click();
		
		
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		
		Thread.sleep(2000);
		webDriverUtility.webPageScreenShot(driver);
	}

}
