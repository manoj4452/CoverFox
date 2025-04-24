package com.coveFox_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CoverFoxAddressDetailsPage {

	// variable
	@FindBy(className = "mp-input-text")
	private WebElement pincodeField;
	@FindBy(id = "want-expert")
	private WebElement mobileNumberField;
	@FindBy(className = "next-btn")
	private WebElement continueButton;

	// Constructor

	public CoverFoxAddressDetailsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Methods

	public void enterPincodeOnAdressDetailPage(String pincode) {
		Reporter.log("entering Pincode On Adress Detail Page", true);
		pincodeField.sendKeys(pincode);
	}

	public void eneterMobileNumberOnAddressDetailPage(String mobileNumber) {
		Reporter.log("entering mobile number On Adress Detail Page", true);
		mobileNumberField.sendKeys(mobileNumber);
	}

	public void clickOnContinueButton() {
		Reporter.log("clicking On continue button on Address Detail Page", true);
		continueButton.click();
	}

}
