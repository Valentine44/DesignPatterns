package by.epam.atmentoring.design_patterns.decorator;

import java.util.*;

import org.openqa.selenium.*;
import org.testng.Reporter;
/**
 * WebDriver decorator class
 * @author Valiantsin_Ivashynka
 *
 */
public class DriverDecorator implements WebDriver {

	protected WebDriver driver;

	public DriverDecorator(WebDriver driver) {
		this.driver = driver;
	}

	public void get(String url) {
		Reporter.log(String.format("Opening %s, current URL: '%s'", url, driver.getCurrentUrl()),
				true);
		driver.get(url);
	}

	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	public String getTitle() {
		return driver.getTitle();
	}

	public List<WebElement> findElements(By by) {
		Reporter.log(String.format("Finding elements: %s, current URL: '%s'", by.toString(), driver.getCurrentUrl()),
				true);
		return driver.findElements(by);
	}

	public WebElement findElement(By by) {
		Reporter.log(String.format("Finding element: %s, current URL: '%s'", by.toString(), driver.getCurrentUrl()),
				true);
		return driver.findElement(by);
	}

	public String getPageSource() {
		return driver.getPageSource();
	}

	public void close() {
		Reporter.log("Closing window",
				true);
		driver.close();
	}

	public void quit() {
		Reporter.log("Closing browser",
				true);
		driver.quit();
	}

	public Set<String> getWindowHandles() {
		return driver.getWindowHandles();
	}

	public String getWindowHandle() {
		return driver.getWindowHandle();
	}

	public TargetLocator switchTo() {
		Reporter.log("Switching to new window",
				true);
		return driver.switchTo();
	}

	public Navigation navigate() {
		return driver.navigate();
	}

	public Options manage() {
		return driver.manage();
	}
}