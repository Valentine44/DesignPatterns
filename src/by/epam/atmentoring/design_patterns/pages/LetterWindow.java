package by.epam.atmentoring.design_patterns.pages;

import org.openqa.selenium.By;

import by.epam.atmentoring.design_patterns.utilities.SwitchWindows;
/**
 * class for letter opened in a new window
 * @author Valiantsin_Ivashynka
 *
 */
public class LetterWindow extends Page {
	
	private static final By REMOVE_BUTTON = By.xpath("//div[@aria-label='Delete']");
	private static final By SUBJECT_AREA = By.xpath("//div[@role='main']//h2");
	private static final By SENDER_AREA = By.xpath("//span[contains(text(), '@')]");
	private static final By LETTER_TEXT_AREA = By.xpath("//div[@dir='ltr']");
	/**
	 * LetterWindow constructor
	 * @param driver
	 */
	public LetterWindow() {
		super();
	}
	/**
	 * get letter subject
	 * @return letter subject
	 */
	public String getActualSubject() {
		return (driver.findElement(SUBJECT_AREA).getText());
	}
	/**
	 * get letter sender's email
	 * @return letter sender's email
	 */
	public String getActualSender() {
		return (driver.findElement(SENDER_AREA).getText());
	}
	/**
	 * get letter text
	 * @return letter text
	 */
	public String getActualLetterText() {
		return (driver.findElement(LETTER_TEXT_AREA).getText().replaceAll("</br>", ""));
	}
	/**
	 * remove letter
	 * @return current page instance
	 */
	public LetterWindow removeLetter() {
		waitElementVisible(REMOVE_BUTTON);
		driver.findElement(REMOVE_BUTTON).click();
		return this;
	}
	/**
	 * close letter opened in separate window
	 */
	public void closeLetterWindow() {
		SwitchWindows.closeCurrentWindow(driver);
	}
}