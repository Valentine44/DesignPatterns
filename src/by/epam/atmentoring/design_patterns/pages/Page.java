package by.epam.atmentoring.design_patterns.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import by.epam.atmentoring.design_patterns.singleton.WebDriverSingleton;
/**
 * Page class (all other pages' superclass)
 * @author Valiantsin_Ivashynka
 *
 */
public class Page {
	protected WebDriver driver;
	public static final int WAIT_FOR_ELEMENT_TIME = 100;
	protected static final String SEARCH_QUERY = "subject";
	/**
	 * Page class constructor
	 * @param driver
	 */
	public Page() {
		this.driver = WebDriverSingleton.getWebDriverInstance();
	}
	/**
	 * wait until web-element is visible on the page
	 * @param element
	 */
	public void waitElementVisible(By locator) {
		new WebDriverWait (driver, WAIT_FOR_ELEMENT_TIME).until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	/**
	 * wait until web-element is present on the page
	 * @param element
	 */
	public void waitElementPresent(By locator) {
		new WebDriverWait (driver, WAIT_FOR_ELEMENT_TIME).until(ExpectedConditions.presenceOfElementLocated(locator));
	}
}