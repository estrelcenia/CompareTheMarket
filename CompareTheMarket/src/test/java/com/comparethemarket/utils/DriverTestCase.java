package com.comparethemarket.utils;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import com.comparethemarket.pages.EnergyPage;
import com.comparethemarket.pages.LoginPage;


public abstract class DriverTestCase {

	public PropertyReader propertyReader;
	public EnergyPage energyPage;
	public LoginPage loginPage;

	private WebDriver driver;
	private WebDriverWait wait;

	@FindBy(xpath = "//span[contains(text(),'Please wait')]")
	private WebElement pageLoadingSpinner;

	enum DriverType {
		Firefox, IE, Chrome
	}

	@BeforeClass
	public void setUp() {

		propertyReader = new PropertyReader();
		String driverType = propertyReader.readApplicationFile("BROWSER");

		if (DriverType.Firefox.toString().equals(driverType)) {
			System.out.println("FF Browser");
			String geckoDriverPath = System.getProperty("user.dir") + "/Drivers/geckodriver.exe";
			System.setProperty("webdriver.gecko.driver", geckoDriverPath);
			driver = new FirefoxDriver();

		} else if (DriverType.IE.toString().equals(driverType)) {
			driver = new InternetExplorerDriver();

		} else if (DriverType.Chrome.toString().equals(driverType)) {
			System.out.println("chrome Browser");
			ChromeOptions chromeOptions = new ChromeOptions();
			String chromeDriverPath = System.getProperty("user.dir") + "/Drivers/chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", chromeDriverPath);
			driver = new ChromeDriver(chromeOptions);
		} else {
			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		String applicationUrl = propertyReader.readApplicationFile("QA_URL");
		getWebDriver().get(applicationUrl);

		energyPage = PageFactory.initElements(driver, EnergyPage.class);
		loginPage = PageFactory.initElements(driver, LoginPage.class);
		this.wait = new WebDriverWait(driver, 30);

	}

	@AfterClass
	public void tearDowm() {
		driver.quit();

	}

	public WebDriver getWebDriver() {
		return driver;
	}

	public PropertyReader getProperty() {
		return propertyReader;
	}

	public int getRandomInteger(int aStart, int aEnd, Random aRandom) {
		if (aStart > aEnd) {
			throw new IllegalArgumentException("Start cannot exceed End.");
		}
		// get the range, casting to long to avoid overflow problems
		long range = (long) aEnd - (long) aStart + 1;

		long fraction = (long) (range * aRandom.nextDouble());
		int randomNumber = (int) (fraction + aStart);
		return randomNumber;
	}

	public String getRandomString(int len) {

		String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		Random rnd = new Random();
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++)
			sb.append(AB.charAt(rnd.nextInt(AB.length())));
		return sb.toString();
	}

	public String generateRandomDigits(int n) {
		int m = (int) Math.pow(10, n - 1);
		System.out.println(m + new Random().nextInt(9 * m));
		int num = m + new Random().nextInt(9 * m);
		String str = String.valueOf(num);
		return str;
	}

	//pageLoadingSpinner
	
	/*
	 * public boolean WaitForPageLoadToDisappeared(int i) {
	 * 
	 * Wait<WebDriver> wait = new FluentWait<WebDriver>(getWebDriver())
	 * .withTimeout(30, TimeUnit.SECONDS) .pollingEvery(5, TimeUnit.SECONDS)
	 * .ignoring(NoSuchElementException.class);
	 * 
	 * WebElement foo = wait.until(new Function<WebDriver, WebElement>() { public
	 * WebElement apply(WebDriver driver) { return driver.findElement(By.id("foo"));
	 * } }); }
	 */
	
	
	public void WaitForPageLoadToDisappeared(int timeout) throws InterruptedException {
		Thread.sleep(10000);
		
		for (int i = 0; i < timeout; i++) {
			if (!isElementPresent(pageLoadingSpinner)) {
				break;
			}
		}

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public Boolean isElementPresent(WebElement el) {
		Boolean result = false;
		try {
			el.isDisplayed();
			result = true;
		} catch (Exception ex) {
		}
		return result;
	}

}
