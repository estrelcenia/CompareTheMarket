package com.comparethemarket.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comparethemarket.utils.DriverHelper;

public class EnergyPage extends DriverHelper {

	@FindBy(id = "change-postcode")
	private WebElement changePostCode;

	@FindBy(id = "your-postcode")
	private WebElement postCodeTextField;

	@FindBy(id = "find-postcode")
	private WebElement findPostButton;

	@FindBy(xpath = "//label[@for='have-bill']")
	private WebElement yesIHaveBillButton;

	@FindBy(id = "no-bill-label")
	private WebElement noIdontIHaveBillButton;

	@FindBy(id = "compare-gas-label")
	private WebElement gasIcon;

	@FindBy(id = "compare-electricity-label")
	private WebElement electricityIcon;

	@FindBy(id = "compare-both-label")
	private WebElement gasAndElectricityIcon;

	@FindBy(xpath = "//label[@for='gas-top-six-british-gas']")
	private WebElement britishGasSupplier;

	@FindBy(xpath = "//label[@for='electricity-top-six-british-gas']")
	private WebElement britishGasSupplierForElectricity;

	@FindBy(xpath = "//label[@for='dual-top-six-british-gas']")
	private WebElement britishGasSupplierForElectricityAndGas;

	@FindBy(xpath = "//input[@id='gas-top-six-edf']")
	private WebElement edfGasSupplier;

	@FindBy(id = "goto-your-supplier-details")
	private WebElement nextButtonAtAtYourSupplierPageSection;

	@FindBy(id = "gas-tariff-additional-info")
	private WebElement gasTariffDropDown;

	@FindBy(id = "gas-payment-method-dropdown-link")
	private WebElement gasPaymentMethodDropDown;

	@FindBy(id = "electricity-payment-method-dropdown-link")
	private WebElement electricityPaymentMethodDropDown;

	@FindBy(xpath = "//label[@for='gas-main-heating-yes']")
	private WebElement gasMainSourceYes;

	@FindBy(xpath = "//label[@for='electricity-main-heating-yes']")
	private WebElement electricityMainSourceYes;

	@FindBy(xpath = "//label[@for='gas-main-heating-no']")
	private WebElement gasMainSourceNo;

	@FindBy(xpath = "//label[@for='kwhSpendG']")
	private WebElement gasUsageInKWH;

	@FindBy(xpath = "//label[@for='kwhSpend']")
	private WebElement electricityUsageInKWH;

	@FindBy(xpath = "//input[@id='economy-7-day-usage']")
	private WebElement dayElectricyUsageTextField;

	@FindBy(xpath = "//input[@id='economy-7-night-usage']")
	private WebElement nightElectricyUsageTextField;

	@FindBy(xpath = "//label[@for='poundSpendG']")
	private WebElement gasUsageInPound;

	@FindBy(id = "gas-usage")
	private WebElement gasUsageInTextFieldForKWH;

	@FindBy(id = "electricity-usage")
	private WebElement electricityUsageInTextFieldForKWH;

	@FindBy(id = "gas-spend")
	private WebElement gasSpendInTextFieldForPound;

	@FindBy(id = "usage-dropdown")
	private WebElement gasUsageDropDownForKWH;

	@FindBy(id = "spend-dropdown")
	private WebElement gasSpendDropDownForPound;

	@FindBy(xpath = "//span[@class='date-picker-icon datepicker-gas-icon']")
	private WebElement datePickerIcon;

	@FindBy(id = "goto-your-energy")
	private WebElement nextButtonAtYourEnergySection;

	@FindBy(xpath = "//label[@for='pre-select-fixed']")
	private WebElement fixedTariff;

	@FindBy(xpath = "//label[@for='pre-select-variable']")
	private WebElement variableTariff;

	@FindBy(id = "//label[@for='pre-select-all']")
	private WebElement allTariff;

	@FindBy(xpath = "//label[@for='pre-select-payment-monthly']")
	private WebElement monthlyDebit;

	@FindBy(xpath = "//label[@for='pre-select-payment-quarterly']")
	private WebElement quarterlyDebit;

	@FindBy(id = "pre-select-payment-onbill")
	private WebElement payOnReceiptDebit;

	@FindBy(id = "Email")
	private WebElement emailAddressAtYourDetailsScreen;

	@FindBy(xpath = "//label[@for='marketingPreference']/span/span[@class='confirm-tick-area']")
	private WebElement emailRadioButton;

	@FindBy(id = "terms-label")
	private WebElement confirmButton;

	@FindBy(id = "email-submit")
	private WebElement goToPriceButton;

	@FindBy(id = "cpc-error-handling-primary-button")
	private WebElement continueToResultButton;

	@FindBy(xpath = "//h3[@class='tariffs-for-me-banner-heading']")
	private WebElement summaryHeadingAtResultSection;

	@FindBy(xpath = "(//button[@enquiry-id='enquiryId'])[1]")
	private WebElement moreDetailButton;

	@FindBy(xpath = "//button[contains(text(),'Switch now')]")
	private WebElement switchNowButton;

	@FindBy(xpath = "//button[contains(@class,'close-cross ng-isolate-scope')]")
	private WebElement closeIconAtSwitchNowPopup;

	@FindBy(xpath = "//span[@class='confirm-tick-area']")
	private WebElement iDontKnowRadioButton;

	@FindBy(id = "tariff-end-date-update-results-button")
	private WebElement updateResultButton;

	public EnergyPage clickOnIDontKnowButton() {
		WaitUntilWebElementIsVisible(iDontKnowRadioButton);
		iDontKnowRadioButton.click();
		return PageFactory.initElements(getWebDriver(), EnergyPage.class);
	}

	public EnergyPage clickOnIDontKnowButtonForElectricityAndGas() {
		WebElement el = getWebDriver().findElement(By.xpath("(//span[contains(text(),'I don’t know')])[1]"));
		WaitUntilWebElementIsVisible(el);
		WebElement el2 = getWebDriver().findElement(By.xpath("(//span[contains(text(),'I don’t know')])[2]"));
		el.click();
		el2.click();
		return PageFactory.initElements(getWebDriver(), EnergyPage.class);
	}

	public EnergyPage clickOnUpdateResultButtonButton() {
		updateResultButton.click();
		return PageFactory.initElements(getWebDriver(), EnergyPage.class);
	}

	public EnergyPage(WebDriver driver) {
		super(driver);
	}

	public EnergyPage enterPostCode(String postcode) {
		postCodeTextField.clear();
		postCodeTextField.sendKeys(postcode);
		return PageFactory.initElements(getWebDriver(), EnergyPage.class);
	}

	public EnergyPage clickOnFindPostCode() {
		findPostButton.click();
		WaitUntilWebElementIsVisible(changePostCode);
		return PageFactory.initElements(getWebDriver(), EnergyPage.class);
	}

	public EnergyPage clickOnYesIHaveMyBillButton() {
		yesIHaveBillButton.click();
		return PageFactory.initElements(getWebDriver(), EnergyPage.class);
	}

	public EnergyPage clickOnGasIcon() {
		gasIcon.click();
		return PageFactory.initElements(getWebDriver(), EnergyPage.class);
	}

	public EnergyPage clickOnElectricityIcon() {
		electricityIcon.click();
		return PageFactory.initElements(getWebDriver(), EnergyPage.class);
	}

	public EnergyPage clickOngasAndElectricityIcon() {
		gasAndElectricityIcon.click();
		return PageFactory.initElements(getWebDriver(), EnergyPage.class);
	}

	public EnergyPage selectBritishGasSupplier() {
		britishGasSupplier.click();
		return PageFactory.initElements(getWebDriver(), EnergyPage.class);
	}

	public EnergyPage selectBritishGasSupplierForElectricity() {
		britishGasSupplierForElectricity.click();
		return PageFactory.initElements(getWebDriver(), EnergyPage.class);
	}

	public EnergyPage selectBritishGasSupplierForElectricityAndGas() {
		britishGasSupplierForElectricityAndGas.click();
		return PageFactory.initElements(getWebDriver(), EnergyPage.class);
	}

	public EnergyPage clickOnNextButtonAtYourSupplierScreen() {
		nextButtonAtAtYourSupplierPageSection.click();
		return PageFactory.initElements(getWebDriver(), EnergyPage.class);
	}

	public EnergyPage selectGasTariffDropDown(String tariffType) {
		selectDropDown(gasTariffDropDown, tariffType);
		return PageFactory.initElements(getWebDriver(), EnergyPage.class);
	}

	public EnergyPage clickOnYesEconomy7Meter() {
		getWebDriver().findElement(By.xpath("//label[@for='economy-7-yes']")).click();
		return PageFactory.initElements(getWebDriver(), EnergyPage.class);
	}

	public EnergyPage selectGasMethodDropDown(String gasMethod) {
		selectDropDown(gasPaymentMethodDropDown, gasMethod);
		return PageFactory.initElements(getWebDriver(), EnergyPage.class);
	}

	public EnergyPage selectElectricityMethodDropDown(String gasMethod) {
		selectDropDown(electricityPaymentMethodDropDown, gasMethod);
		return PageFactory.initElements(getWebDriver(), EnergyPage.class);
	}

	public EnergyPage clickOnYesGasMainSource() {
		gasMainSourceYes.click();
		return PageFactory.initElements(getWebDriver(), EnergyPage.class);
	}

	public EnergyPage clickOnYesElectricityMainSource() {
		electricityMainSourceYes.click();
		return PageFactory.initElements(getWebDriver(), EnergyPage.class);
	}

	public EnergyPage enterGasUsage(String gasQuantity) {
		gasUsageInKWH.click();
		gasUsageInTextFieldForKWH.clear();
		gasUsageInTextFieldForKWH.sendKeys(gasQuantity);
		return PageFactory.initElements(getWebDriver(), EnergyPage.class);
	}

	public EnergyPage enterGasAndElectricityUsage(String gasQuantity) {
		getWebDriver().findElement(By.xpath("//label[@for='kwhSpend']")).click();
		getWebDriver().findElement(By.xpath("//input[@id='electricity-usage']")).clear();
		getWebDriver().findElement(By.xpath("//input[@id='electricity-usage']")).sendKeys(gasQuantity);
		return PageFactory.initElements(getWebDriver(), EnergyPage.class);
	}
	
	
	
	

	public EnergyPage enterElectricityUsage(String dayElectricity, String nightElectricity) {
		getWebDriver().findElement(By.xpath("//label[@for='kwhSpend']")).click();
		dayElectricyUsageTextField.clear();
		dayElectricyUsageTextField.sendKeys(dayElectricity);
		nightElectricyUsageTextField.clear();
		nightElectricyUsageTextField.sendKeys(nightElectricity);

		return PageFactory.initElements(getWebDriver(), EnergyPage.class);
	}

	public EnergyPage clickOnNextButtonAtYourEnergySection() throws InterruptedException {
		nextButtonAtYourEnergySection.click();
		Thread.sleep(2000);
		return PageFactory.initElements(getWebDriver(), EnergyPage.class);
	}

	public EnergyPage selectFixedTariff() {
		fixedTariff.click();
		return PageFactory.initElements(getWebDriver(), EnergyPage.class);
	}

	public EnergyPage selectVariableariff() {
		variableTariff.click();
		return PageFactory.initElements(getWebDriver(), EnergyPage.class);
	}

	public EnergyPage selectMonthlyPayMethod() {
		monthlyDebit.click();
		return PageFactory.initElements(getWebDriver(), EnergyPage.class);
	}

	public EnergyPage selectQuarterlyPayMethod() {
		quarterlyDebit.click();
		return PageFactory.initElements(getWebDriver(), EnergyPage.class);
	}

	public EnergyPage enterEmailAddressAtDetailScreen(String emailAddress) {
		emailAddressAtYourDetailsScreen.clear();
		emailAddressAtYourDetailsScreen.sendKeys(emailAddress);
		return PageFactory.initElements(getWebDriver(), EnergyPage.class);
	}

	public EnergyPage selectEmailRadioButton() {
		emailRadioButton.click();
		return PageFactory.initElements(getWebDriver(), EnergyPage.class);
	}

	public EnergyPage clickOnConfirmButton() {
		confirmButton.click();
		return PageFactory.initElements(getWebDriver(), EnergyPage.class);
	}

	public EnergyPage clickOnGoToPriceButton() {
		goToPriceButton.click();
		return PageFactory.initElements(getWebDriver(), EnergyPage.class);
	}

	public EnergyPage clickOnContinueToResultButton() throws InterruptedException {
		continueToResultButton.click();
		Thread.sleep(2000);
		WaitUntilWebElementIsVisible(iDontKnowRadioButton);
		return PageFactory.initElements(getWebDriver(), EnergyPage.class);
	}

	public boolean summaryIsDisplayed() {
		boolean result = summaryHeadingAtResultSection.isDisplayed();
		return result;
	}

	public EnergyPage clickOnMoreDetailButton() {
		moreDetailButton.click();
		return PageFactory.initElements(getWebDriver(), EnergyPage.class);
	}

	public boolean switchNowButtonIsDisplayed() {
		boolean result = switchNowButton.isDisplayed();
		return result;
	}

	public EnergyPage closeSwitchNowPopup() throws InterruptedException {
		Thread.sleep(2000);
		closeIconAtSwitchNowPopup.click();
		Thread.sleep(3000);
		scrollWebPageUp();
		return PageFactory.initElements(getWebDriver(), EnergyPage.class);
	}

}
