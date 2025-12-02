package com.DemoWebShop_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewAddress_HomePage {
	public AddNewAddress_HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "Address_FirstName")
	private WebElement firstNameTextField;
	
	@FindBy(id = "Address_LastName")
	private WebElement lastNameTextField;
	
	@FindBy(id = "Address_Email")
	private WebElement addressEmail;
	
	@FindBy(id = "Address_CountryId")
	private WebElement countryDropdown;

	@FindBy(id = "Address_City")
	private WebElement cityAddress;


	@FindBy(id = "Address_Address1")
	private WebElement address_address1;


	@FindBy(id = "Address_ZipPostalCode")
	private WebElement zipPostalCode;
	
	@FindBy(id = "Address_PhoneNumber")
	private WebElement phoneNumber_Address;
	
	
	@FindBy(xpath = "(//input[@type='submit'])[2]")
	private WebElement saveButton;
	
	

	public WebElement getSaveButton() {
		return saveButton;
	}

	public WebElement getFirstNameTextField() {
		return firstNameTextField;
	}

	public WebElement getLastNameTextField() {
		return lastNameTextField;
	}

	public WebElement getAddressEmail() {
		return addressEmail;
	}

	public WebElement getCountryDropdown() {
		return countryDropdown;
	}

	public WebElement getCityAddress() {
		return cityAddress;
	}

	public WebElement getAddress_address1() {
		return address_address1;
	}

	public WebElement getZipPostalCode() {
		return zipPostalCode;
	}

	public WebElement getPhoneNumber_Address() {
		return phoneNumber_Address;
	}
	
	


}
