package com.comparethemarket.testscripts;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.comparethemarket.utils.DriverTestCase;
import com.comparethemarket.utils.ReadDataFromExcel;

public class TC_002_GasTest extends DriverTestCase {

	String userName;
	String Password;
	String energyPageURL;
	String postCodeValue= "PE2 6YS";

	@Test
	public void TC_001_GasTestMethod() throws InterruptedException, IOException {

		// getting username and password from properties file
		userName = propertyReader.readApplicationFile("QAUserName");
		Password = propertyReader.readApplicationFile("QAPassword");

		// Login into application
		loginPage.enterIntoApplication(userName, Password);

		boolean signOutLink= loginPage.waitForSignOutLink();
		Assert.assertTrue(signOutLink, "Signout link should be displayed");

		//move to energy page 
		energyPageURL = propertyReader.readApplicationFile("EnergyPageURL");
		energyPage= loginPage.moveToEnergyPage(energyPageURL);
		
		
		//enter the postcode
		energyPage.enterPostCode(postCodeValue);
		
		//click on Find post code button
		energyPage.clickOnFindPostCode();
		
		//click on yes I have my bill button
		energyPage.clickOnYesIHaveMyBillButton();
		
		//select the gas option
		energyPage.clickOnGasIcon();
		
		//select the gas supplier
		energyPage.selectBritishGasSupplier();
		
		//click on Next button at your supplier screen
		energyPage.clickOnNextButtonAtYourSupplierScreen();
		
		//select gas tariff drop down
		energyPage.selectGasTariffDropDown("Temporary Dec 2021");
		
		//select your gas payment method
		energyPage.selectGasMethodDropDown("Monthly Direct Debit");
		
		//click on Yes button at gas main source
		energyPage.clickOnYesGasMainSource();
		
		//enter gas usage
		energyPage.enterGasUsage("100");
		
		//Click on next button at your energy screen
		energyPage.clickOnNextButtonAtYourEnergySection();
		
		//select fixed tarrif icon
		energyPage= energyPage.selectFixedTariff();
		
		//select payment menthod of your energy
		energyPage= energyPage.selectMonthlyPayMethod();
		
		//Enter email address at your details screen
		energyPage= energyPage.enterEmailAddressAtDetailScreen(userName);
		
		//select email radio button
		energyPage= energyPage.selectEmailRadioButton();
		
		//select confirm button
		energyPage= energyPage.clickOnConfirmButton();
		
		//click on on Go To Price button
		energyPage= energyPage.clickOnGoToPriceButton();
		
		
		//click on continue button at popup
		energyPage= energyPage.clickOnContinueToResultButton();
		
		
		//select I do not know radio button
		energyPage= energyPage.clickOnIDontKnowButton();
		
		//click on update result button
		energyPage= energyPage.clickOnUpdateResultButtonButton();
		
		//Verify that summary section is displayed at Your result screen 
		boolean summary=energyPage.summaryIsDisplayed();
		Assert.assertTrue(summary, "Summary section should be displayed");
		
		//click on firt more Details button
		energyPage= energyPage.clickOnMoreDetailButton();
		
		
		//Verify that more detail popup 'switch now button is displayed 
		boolean switchNow =energyPage.switchNowButtonIsDisplayed();
		Assert.assertTrue(switchNow, "Switch now button should be displayed");
		
		//close the popup
		energyPage= energyPage.closeSwitchNowPopup();
		
		//Logout from application
		loginPage.clickOnAccountIcon();
		loginPage.clickOnSignOutLink();

	}

}
