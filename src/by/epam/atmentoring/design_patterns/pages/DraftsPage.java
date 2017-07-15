package by.epam.atmentoring.design_patterns.pages;

import org.openqa.selenium.By;
/**
 * Gmail drafts page class
 * @author Valiantsin_Ivashynka
 *
 */
public class DraftsPage extends GmailPage{
	
	private static final By DRAFT = By.xpath("//tr[1]/td[4]/div[2]/font[contains(text(), 'Draft')]");
	/**
	 * DraftsPage class constructor
	 * @param driver
	 */
	public DraftsPage() {
		super();
	}
	/**
	 * open draft
	 * @return Drafts page
	 */
	public DraftsPage openDraft() {
		waitElementVisible(DRAFT);
		driver.findElement(DRAFT).click();
		return this;
	}
}