package com.coverFox_test;

import static org.testng.Assert.fail;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.coveFox_POM.CoverFoxAddressDetailsPage;
import com.coveFox_POM.CoverFoxHealthPlanPage;
import com.coveFox_POM.CoverFoxHomePage;
import com.coveFox_POM.CoverFoxMemberDetailsPage;
import com.coveFox_POM.CoverFoxResultPage;
import com.coverFox_Base.Base;
import com.coverFox_Utility.Utility;


public class CoverFoxTestUsingTestNG extends Base{

	public static Logger logger;
	CoverFoxHomePage coverFoxHomePage;
	CoverFoxMemberDetailsPage coverFoxMemberDetailsPage;
	CoverFoxAddressDetailsPage coverFoxAddressDetailsPage;
	CoverFoxHealthPlanPage coverFoxHealthPlanPage;
	CoverFoxResultPage coverFoxResultPage;

	@BeforeClass
	public void launchBrowser() throws EncryptedDocumentException, IOException {
		

		logger= Logger.getLogger("Morning_Batch_CoverFox");
		  PropertyConfigurator.configure("log4j.properties");
		  logger.info("Welcome to CoverFox Testing");

		openBrowser();
		logger.info("Launching Browser");
		coverFoxHomePage = new CoverFoxHomePage(driver);
		coverFoxMemberDetailsPage = new CoverFoxMemberDetailsPage(driver);
		coverFoxAddressDetailsPage = new CoverFoxAddressDetailsPage(driver);
		coverFoxHealthPlanPage = new CoverFoxHealthPlanPage(driver);
		coverFoxResultPage = new CoverFoxResultPage(driver);

	}

	@BeforeMethod

	public void coverFoxPreconditions() throws InterruptedException, EncryptedDocumentException, IOException {

		coverFoxHomePage.clickOnGender();
		logger.info("Clicking on Gender");
		coverFoxHealthPlanPage.clickOnNextButtonOnHealthPlanPage();
		logger.info("clicking On Next Button On Health Plan Page");
		coverFoxMemberDetailsPage.handleAgeDropDown(Utility.readDataFromExcel("Sheet6", 0, 0));
		logger.info("Handling age drop down");
		coverFoxMemberDetailsPage.clickOnNextButtonOnMemberDetailPage();
		logger.info("clicking On Next Button On Member Detail Page");
		coverFoxAddressDetailsPage.enterPincodeOnAdressDetailPage(Utility.readDataFromExcel("Sheet6", 0, 1));
		logger.info("Enter Pincode On Adress Detail Page");
		coverFoxAddressDetailsPage.eneterMobileNumberOnAddressDetailPage(Utility.readDataFromExcel("Sheet6", 0, 2));
		logger.info("Eneter Mobile Number On Address Detail Page");
		coverFoxAddressDetailsPage.clickOnContinueButton();
		logger.info("Clicking On Continue Button");
		Thread.sleep(4000);

	}

	@Test
	public void validateCoverFoxPlan() throws IOException {

		//Assert.fail();
		int planNumberFromText = coverFoxResultPage.getPlanNumberfromText();
		int planNumberFromCards = coverFoxResultPage.getPlanNumberFromPlanCards();
		logger.info("Validating CoverFox Plan");
		Assert.assertEquals(planNumberFromText, planNumberFromCards, "TC is failed, numbers are not matching");
		Reporter.log("Plan Number is Matching , TC is passed", true);
		Reporter.log("First change done by psp", true);
		Reporter.log("Second change is done by psp", true);
		Reporter.log("Third change is done by psp", true);
		
		
	}

	@AfterClass
	public void closeBrowser ()
	{
		logger.info("closing Browser");
		closeBrowserWindow();
	}

}
