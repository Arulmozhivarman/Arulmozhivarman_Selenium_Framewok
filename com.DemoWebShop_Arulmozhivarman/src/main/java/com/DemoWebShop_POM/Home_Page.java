package com.DemoWebShop_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_Page {
	
	public Home_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[text() = 'Log out']")
	private WebElement logoutButton;
	
	@FindBy(xpath = "//a[text()='Addresses']")
	private WebElement addressesButton;

	public WebElement getLogoutButton() {
		return logoutButton;
	}

	public WebElement getAddressesButton() {
		return addressesButton;
	}
}
