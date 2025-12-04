package com.DemoWebShop_TestScripts;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.DemoWebShop_GenericUtility.base_Test;
import com.DemoWebShop_POM.AddNewAddress_HomePage;
import com.DemoWebShop_POM.Address_Page;

public class Tc_001_verify_user_Is_Able_To_Add_Addresss_or_Not_Test extends base_Test
{

	@Test
	public void addAddress () throws EncryptedDocumentException, IOException, InterruptedException
	{
		System.out.println("*****************************");
		webDriverUtility.javaScriptScrollIntoView(driver, homePage.getAddressesButton());
		homePage.getAddressesButton().click();
		
		Address_Page addressPage = new Address_Page(driver);
		addressPage.getAddNewButton().click();
		
		AddNewAddress_HomePage addNewAddressPage = new AddNewAddress_HomePage(driver);
				
		addNewAddressPage.getFirstNameTextField().sendKeys(fileutility.readDataFromExcelFile("Sheet1", 1, 0));
		addNewAddressPage.getLastNameTextField().sendKeys(fileutility.readDataFromExcelFile("Sheet1", 1, 1));
		addNewAddressPage.getAddressEmail().sendKeys(fileutility.readDataFromExcelFile("Sheet1", 1, 2));
		
		webDriverUtility.selectByVisibleText(addNewAddressPage.getCountryDropdown(),
				fileutility.readDataFromExcelFile("sheet1", 1, 3));
		
		addNewAddressPage.getCityAddress().sendKeys(fileutility.readDataFromExcelFile("Sheet1", 1, 4));
		addNewAddressPage.getAddress_address1().sendKeys(fileutility.readDataFromExcelFile("Sheet1", 1, 5));
		addNewAddressPage.getZipPostalCode().sendKeys(fileutility.readDataFromExcelFile("Sheet1", 1, 6));
		addNewAddressPage.getPhoneNumber_Address().sendKeys(fileutility.readDataFromExcelFile("Sheet1", 1, 7));
		
		addNewAddressPage.getSaveButton().click();
		
		Thread.sleep(3000);
		webDriverUtility.webPageScreenShot(driver);
	}
	
}