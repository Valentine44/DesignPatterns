package by.epam.atmentoring.design_patterns.utilities;

import org.openqa.selenium.WebDriver;
/**
 * Class for managing application's windows
 * @author Valiantsin_Ivashynka
 *
 */
public class SwitchWindows {
	/**
	 * switch to new window
	 * @param driver
	 */
	public static void switchToNewWindow(WebDriver driver) {
		driver.switchTo().window((String) driver.getWindowHandles().toArray()[driver.getWindowHandles().size() - 1]);
    }
	/**
	 * switch to main window
	 * @param driver
	 */
	public static void switchToMainWindow(WebDriver driver) {
		driver.switchTo().window((String) driver.getWindowHandles().toArray()[0]);
    }
	/**
	 * close the window which is is currently active
	 * @param driver
	 */
	public static void closeCurrentWindow(WebDriver driver) {
		driver.close();
    }
}