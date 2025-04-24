package com.coveFox_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CoverFoxHomePage {

	// 1. Variables--> webElements
	// driver.findElement(By.xpath);

	@FindBy(xpath = "//div[text()='Male']")
	private WebElement gender;

	// 2.Constructor

	public CoverFoxHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// 3. Methods

	public void clickOnGender() {
		Reporter.log("Clicking on Gender", true);
		gender.click();
	}

}
