package by.epam.atmentoring.design_patterns.pages;

import org.openqa.selenium.By;

import by.epam.atmentoring.design_patterns.bo.Account;
import by.epam.atmentoring.design_patterns.test_data.GmailTestData;
/**
 * Login - email input page class
 * @author Valiantsin_Ivashynka
 *
 */
public class LogIn_EmailPage extends Page{
	private static final By EMAIL_TEXT_FIELD = By.xpath("//input[@id='identifierId']");
	private static final By SUBMIT_EMAIL = By.xpath("//div[@id='identifierNext']/content/span");
	/**
	 * LogIn_EmailPage class constructor
	 * @param driver
	 */
	public LogIn_EmailPage() {
		super();
	}
	/**
	 * open login-email page
	 * @return current page instance
	 */
	public LogIn_EmailPage open() {
		driver.get(GmailTestData.getURL());
		return this;
	}
	/**
	 * input email
	 * @return current page instance
	 */
	public LogIn_EmailPage inputEmail() {
		waitElementVisible(EMAIL_TEXT_FIELD);
		driver.findElement(EMAIL_TEXT_FIELD).sendKeys(Account.getEmail());
		return this;
	}
	/**
	 * submit email
	 * @return password submission page instance
	 */
	public LogIn_PasswordPage submitEmail() {
		waitElementVisible(SUBMIT_EMAIL);
		driver.findElement(SUBMIT_EMAIL).click();
		return new LogIn_PasswordPage();
	}
}