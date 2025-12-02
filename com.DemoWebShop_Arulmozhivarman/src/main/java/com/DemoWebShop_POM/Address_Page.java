package com.DemoWebShop_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Address_Page {
	
	public Address_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@value='Add new']")
	private WebElement addNewButton;
	
	@FindBy(xpath = "//input[@value='Delete']")
	private WebElement deleteButton;
	
	public WebElement getAddNewButton() {
		return addNewButton;
	}





	public WebElement getDeleteButton() {
		return deleteButton;
	}
	
	

}
