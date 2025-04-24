package com.coveFox_POM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CoverFoxResultPage {

	// variable

	@FindBy(xpath = "//div[contains(text(),'matching')] ")
	private WebElement totalPlansResult;

	@FindBy(className = "pcc-main")
	private List<WebElement> planCards;

	// Constructor

	public CoverFoxResultPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Method

	public void validatePlanResultText() throws InterruptedException {
		String result = totalPlansResult.getText();
		String[] result1 = result.split(" ");
		int resultInNumber = Integer.parseInt(result1[0]);

		Thread.sleep(5000);
		int totalPlans = planCards.size();

		if (totalPlans == resultInNumber) {
			System.out.println("TC is pass");
		} else {
			System.out.println("TC is fail");
		}
	}

	public int getPlanNumberfromText() {
		Reporter.log("Getting Plan Number From Text", true);
		String result = totalPlansResult.getText();
		String[] result1 = result.split(" ");
		int planNumber = Integer.parseInt(result1[0]);
		return planNumber;
	}

	public int getPlanNumberFromPlanCards() {
		Reporter.log("Getting Plan Number From Plan Cards", true);
		int planNumberFromCards = planCards.size();
		return planNumberFromCards;
	}

}
