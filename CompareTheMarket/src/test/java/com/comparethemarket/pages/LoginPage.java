package com.comparethemarket.pages;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.comparethemarket.utils.DriverHelper;

public class LoginPage extends DriverHelper {

	@FindBy(id = "Market_HomePage_GlobalHeader_SignIn")
	private WebElement signInLink;

	@FindBy(id = "emailAddress")
	private WebElement emailAddress;

	@FindBy(id = "password")
	private WebElement password;

	@FindBy(id = "signin-button-submit")
	private WebElement signInButton;

	@FindBy(id = "signout-button")
	private WebElement signOutLink;
	
	@FindBy(id = "your-account-icon")
	private WebElement accountIcon;
	
	
	
	public LoginPage clickOnSignOutLink() {
		signOutLink.click();
		return PageFactory.initElements(getWebDriver(), LoginPage.class);
	}
	
	public LoginPage clickOnAccountIcon() {
		accountIcon.click();
		return PageFactory.initElements(getWebDriver(), LoginPage.class);
	}
	

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public LoginPage clickOnSignInLink() {
		signInLink.click();
		return PageFactory.initElements(getWebDriver(), LoginPage.class);
	}

	public LoginPage enterUserName(String username) {
		emailAddress.clear();
		emailAddress.sendKeys(username);
		return PageFactory.initElements(getWebDriver(), LoginPage.class);
	}

	public LoginPage enterPassword(String pass) {
		password.clear();
		password.sendKeys(pass);
		return PageFactory.initElements(getWebDriver(), LoginPage.class);
	}

	public LoginPage clickOnLoginButton() {
		signInButton.click();
		return PageFactory.initElements(getWebDriver(), LoginPage.class);
	}

	public LoginPage enterIntoApplication(String userName, String password) {
		clickOnSignInLink();
		enterUserName(userName);
		enterPassword(password);
		clickOnLoginButton();
		return PageFactory.initElements(getWebDriver(), LoginPage.class);
	}

	public boolean waitForSignOutLink() {
		boolean result = WaitUntilWebElementIsVisible(signOutLink);
		return result;

	}
	
	
	public EnergyPage moveToEnergyPage(String energyPageURL) {
		getWebDriver().navigate().to(energyPageURL);
		return PageFactory.initElements(getWebDriver(), EnergyPage.class);
	}

	/*
	 * public LoginPage clickOnLogoutButton() throws InterruptedException {
	 * companySiteLogo.click(); LogoutLink.click(); yesButtonAtLogout.click();
	 * WaitForElementPresent1(loginBox, 30); return
	 * PageFactory.initElements(getWebDriver(), LoginPage.class); }
	 */

}
