package com.comparethemarket.utils;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public abstract class DriverHelper {
	
	protected WebDriver driver;
	

	public DriverHelper(WebDriver webdriver) {
		driver = webdriver;		
	}
	
	public WebDriver getWebDriver(){
		return driver;
	}
	
	
	public void Log(String logMsg){
		System.out.println(logMsg);
	}

	public By ByLocator(String locator) {
		By result = null;

		if (locator.startsWith("//")) {
			result = By.xpath(locator);
		} else if (locator.startsWith("css=")) {
			result = By.cssSelector(locator.replace("css=", ""));
		} else if (locator.startsWith("#")) {
			result = By.name(locator.replace("#", ""));
			
		} else if (locator.startsWith("link=")) {
			result = By.linkText(locator.replace("link=", ""));
		}
			
		  else if(locator.startsWith("class=")) {
				result=By.className(locator.replace("class=", ""));
			}
		  else if(locator.startsWith("name=")) {
				result=By.name(locator.replace("name=", ""));
			}
		  
		  else if(locator.startsWith("id=")) {
			  result=By.id(locator.replace("id=", ""));
		  }
		  else if(locator.startsWith("(")) {
			  result = By.xpath(locator);
		  }
		else {
			result = By.id(locator);
		}

		return result;
	}

	public void scrollWebPageDown(){
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("scroll(0, 400)"); //
	}


	public void scrollWebPageUp(){
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("scroll(0, -500)"); //
	}

	public Boolean isElementPresent(WebElement element) {
		Boolean result = false;
		try {
			WebDriverWait wait= new WebDriverWait(getWebDriver(), 2);
			wait.until(ExpectedConditions.visibilityOf(element));
			result = true;
		} catch (Exception ex) {

		}

		return result;
	}
	

	public Boolean isElementDisplayed(String locator) {

		Boolean result = false;
		try {
			getWebDriver().findElement(ByLocator(locator)).isDisplayed();
			result = true;
		} catch (Exception ex) {

		}
		return result;
	}
	

	public void WaitForElementPresent(WebElement locator, int timeout) {

		for (int i = 0; i < timeout; i++) {
			if (isElementPresent(locator)) {
				break;
			}

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void WaitForElementNotPresent(WebElement locator, int timeout) {

		for (int i = 0; i < timeout; i++) {
			if (!isElementPresent(locator)) {
				break;
			}

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public void WaitForElementEnabled(WebElement locator, int timeout) {

		for (int i = 0; i < timeout; i++) {
			if (isElementPresent(locator)) {
				if (locator.isEnabled()) {
					break;
				}
			}

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void WaitForElementNotEnabled(WebElement locator, int timeout) {

		for (int i = 0; i < timeout; i++) {
			if (isElementPresent(locator)) {
				if (!locator.isEnabled()) {
					break;
				}
			}

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void WaitForElementVisible(WebElement locator, int timeout) {

		for (int i = 0; i < timeout; i++) {
			if (isElementPresent(locator)) {
				if (locator.isDisplayed()) {
					break;
				}
			}

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void WaitForElementNotVisible(WebElement locator, int timeout) {

		for (int i = 0; i < timeout; i++) {
			if (isElementPresent(locator)) {
				if (!locator.isDisplayed()) {
					break;
				}
			}

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void mouseOver(WebElement el){		
		//this.WaitForElementPresent(locator, 50);
		this.WaitForElementPresent1(el, 50);
		//WebElement el = getWebDriver().findElement(ByLocator(locator));
		
		Actions builder = new Actions(getWebDriver());    
		builder.moveToElement(el).build().perform();		
	}
	
	
	
	public void WaitForElementPresent1(WebElement el, int timeout) {

		for (int i = 0; i < timeout; i++) {
			if (isElementPresent1(el)) {
				break;
			}

			try {
				
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public Boolean isElementPresent1(WebElement el) {
		Boolean result = false;
		try {
			el.isDisplayed();
			result = true;
		} catch (Exception ex) {

		}
		return result;
	}

	public void mouseDoubleClick(WebElement locator){
		this.WaitForElementPresent(locator, 50);		
		//WebElement el = getWebDriver().findElement(ByLocator(locator));
		Actions builder = new Actions(getWebDriver());    
		builder.doubleClick(locator).perform();
	}

	public void dragAndDrop(String draggable, String to)
	{
		WebElement elDraggable = getWebDriver().findElement(ByLocator(draggable));
		WebElement todrag = getWebDriver().findElement(ByLocator(to));
		Actions builder = new Actions(getWebDriver());   
		builder.dragAndDrop(elDraggable, todrag).perform();		
	}

	
	// Select value from drop down
	public void selectDropDown(WebElement locator, String targetValue) {
		new Select(locator)
				.selectByVisibleText(targetValue);
		
	}
	
	public String getRandomString(int len) {
		
		String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		Random rnd = new Random();
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++)
			sb.append(AB.charAt(rnd.nextInt(AB.length())));
		return sb.toString();
	}
	
	
	public boolean WaitUntilWebElementIsVisible(WebElement element) {
		try {
			WebDriverWait wait= new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOf(element));
			System.out.println("WebElement is visible using locator: " + "<" + element.toString() + ">");
			return true;
		} catch (Exception e) {
			System.out.println("WebElement is NOT visible, using locator: " + "<" + element.toString() + ">");
			Assert.fail("WebElement is NOT visible, Exception: " + e.getMessage());
			return false;
		}
	}
	
	
}
