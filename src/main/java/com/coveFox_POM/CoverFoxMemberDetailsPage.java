package com.coveFox_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

public class CoverFoxMemberDetailsPage {

	// Variables

	@FindBy(id = "Age-You")
	private WebElement ageDropDown;
	@FindBy(className = "next-btn")
	private WebElement nextButtonOnMemeberDetailsPage;

	// Constructor

	public CoverFoxMemberDetailsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Methods

	public void handleAgeDropDown(String age) {
		Reporter.log("handeling age dropdown", true);
		Select s = new Select(ageDropDown);
		s.selectByValue(age + "y");
	}

	public void clickOnNextButtonOnMemberDetailPage() {
		Reporter.log("Clicking on next button on member details page", true);
		nextButtonOnMemeberDetailsPage.click();
	}

}
