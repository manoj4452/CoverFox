package com.coveFox_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CoverFoxHealthPlanPage {

	// variables---> webElement

	@FindBy(xpath = "//div[text()=' Next ']")
	private WebElement nextButton;

	// constructor

	public CoverFoxHealthPlanPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// methods

	public void clickOnNextButtonOnHealthPlanPage() {
		Reporter.log("Clicking on Next button of Health Plan Page", true);
		nextButton.click();
	}

}
