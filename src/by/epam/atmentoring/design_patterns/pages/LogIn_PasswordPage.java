package by.epam.atmentoring.design_patterns.pages;

import org.openqa.selenium.By;
/**
 * login - password page class
 * @author Valiantsin_Ivashynka
 *
 */
public class LogIn_PasswordPage extends Page{
	
	private static final By PASSWORD_TEXT_FIELD = By.xpath("//input[@name='password']");
	private static final By SUBMIT_PASSWORD = By.xpath("//span[contains(text(), 'Next')]");
	private static final By WRONG_PASSWORD_MESSAGE = By.xpath("//*[contains (text(), 'Wrong password. Try again.')]");
	/**
	 * LogIn_PasswordPage class constructor
	 * @param driver
	 */
	public LogIn_PasswordPage() {
		super();
	}
	/**
	 * input password
	 * @return current page instance
	 */
	public LogIn_PasswordPage inputPassword(String password) {
		waitElementVisible(PASSWORD_TEXT_FIELD);
		driver.findElement(PASSWORD_TEXT_FIELD).sendKeys(password);
		return this;
	}
	/**
	 * submit password
	 * @return Google account page instance
	 */
	public GoogleAccountPage submitPassword() {
		waitElementVisible(SUBMIT_PASSWORD);
		driver.findElement(SUBMIT_PASSWORD).click();
		return new GoogleAccountPage();
	}
	/**
	 * submit incorrect password (the user stays on page)
	 * @return current page instance
	 */
	public LogIn_PasswordPage attemptSubmitPassword() {
		waitElementVisible(SUBMIT_PASSWORD);
		driver.findElement(SUBMIT_PASSWORD).click();
		return this;
	}
	/**
	 * find message about wrong password being input
	 * @return wrong password message location
	 */
	public static By getWrongPasswordMessage() {
		return WRONG_PASSWORD_MESSAGE;
	}
}