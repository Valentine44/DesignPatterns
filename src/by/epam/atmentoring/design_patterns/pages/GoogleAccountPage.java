package by.epam.atmentoring.design_patterns.pages;

import org.openqa.selenium.By;
/**
 * Google account page class
 * @author Valiantsin_Ivashynka
 *
 */
public class GoogleAccountPage extends Page{

	private static final By GMAIL = By.xpath("//a[@aria-label='Mail']");
	/**
	 * GoogleAccountPage class constructor
	 * @param driver
	 */
	public GoogleAccountPage() {
		super();
	}
	/**
	 * go to mail
	 * @return inbox page instance
	 */
	public InboxPage selectMail() {
		waitElementVisible(GMAIL);
		driver.findElement(GMAIL).click();
		return new InboxPage();
	}
}