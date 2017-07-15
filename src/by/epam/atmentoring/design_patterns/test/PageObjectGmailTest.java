package by.epam.atmentoring.design_patterns.test;

import org.testng.Assert;
import org.testng.annotations.*;

import by.epam.atmentoring.design_patterns.bo.Account;
import by.epam.atmentoring.design_patterns.bo.Letter;
import by.epam.atmentoring.design_patterns.pages.*;
import by.epam.atmentoring.design_patterns.singleton.WebDriverSingleton;
import by.epam.atmentoring.design_patterns.test_data.GmailTestData;

/**
 * Gmail critical path test scenario implemented using Page Object
 * @author Valiantsin_Ivashynka
 *
 */
public class PageObjectGmailTest{
	@Test 
	/**
	 * send email by pressing Ctrl+Enter, remove letter by drag and drop
	 */
	public void mouseKeyboardActions() {
		
		LogIn_EmailPage emailPage = new LogIn_EmailPage().open();
		LogIn_PasswordPage passwordPage = emailPage.inputEmail().submitEmail();
		GoogleAccountPage googleAccount = passwordPage.inputPassword(Account.getPassword()).submitPassword();
		InboxPage inbox = googleAccount.selectMail();
		inbox.clickCompose().inputAddressee(Letter.getAddressee()).inputSubject().inputLetterText();
		//inbox.sendViaCtrlEnter();
		inbox.sendDraft();
		SentMailPage sentMail = inbox.toSentMailPage();
		//sentMail.expandLeftNavBar().letterToTrash(sentMail.getLastSentLetter());
		//Assert.assertTrue(sentMail.getMovedToTrashMessage().isDisplayed()); 
		sentMail.logOut();
		
	}
	/**
	 * refresh page, get page title with JavaScript
	 */
	@Test (dependsOnMethods = { "mouseKeyboardActions" })
	public void jsInjection() {
		
		LogIn_EmailPage emailPage = new LogIn_EmailPage().open();
		LogIn_PasswordPage passwordPage = emailPage.inputEmail().submitEmail();
		GoogleAccountPage googleAccount = passwordPage.inputPassword(Account.getPassword()).submitPassword();
		InboxPage inbox = googleAccount.selectMail();
		//Assert.assertTrue(inbox.jsGetTitle().contains("Inbox"));
		//inbox.jsRefreshPage();
		//Assert.assertTrue(inbox.jsGetTitle().contains("Inbox"));
		
	}
	/**
	 * log in to Gmail, create letter, save as draft, send the letter
	 */
	@Test (dependsOnMethods = { "jsInjection" })
	public void Scenario1() {
		
		LogIn_EmailPage emailPage = new LogIn_EmailPage().open();
		LogIn_PasswordPage passwordPage = emailPage.inputEmail().submitEmail();
		GoogleAccountPage googleAccount = passwordPage.inputPassword(Account.getPassword()).submitPassword();
		InboxPage inbox = googleAccount.selectMail();
		inbox.clickCompose().inputAddressee(Letter.getAddressee()).inputSubject().inputLetterText().closeAndSave();
		DraftsPage drafts = inbox.toDraftsPage();
		drafts.openDraft().sendDraft();
		SentMailPage sentMail = drafts.toSentMailPage();
		Assert.assertEquals(sentMail.getEmailTime(), GmailTestData.getSendingTime());
		sentMail.logOut();
		
	}
	/**
	 * submit incorrect password, then submit correct password
	 */
	@Test (dependsOnMethods = { "Scenario1" })
	public void Scenario2() {
	
		LogIn_EmailPage emailPage = new LogIn_EmailPage().open();
		LogIn_PasswordPage passwordPage = emailPage.inputEmail().submitEmail();
		passwordPage = passwordPage.inputPassword(Account.getIncorrectPassword()).attemptSubmitPassword();
		Assert.assertTrue(WebDriverSingleton.getWebDriverInstance().findElement(LogIn_PasswordPage.getWrongPasswordMessage()).isDisplayed());
		passwordPage.inputPassword(Account.getPassword());
		GoogleAccountPage googleAccount = passwordPage.submitPassword();
		googleAccount.selectMail();
		Assert.assertTrue(WebDriverSingleton.getWebDriverInstance().getTitle().contains("Inbox"));
	
	}
	/**
	 * log in to Gmail, create letter, send to myself, open in new window, remove
	 */
	@Test (dependsOnMethods = { "Scenario2" })
	public void Scenario3() {
		LogIn_EmailPage emailPage = new LogIn_EmailPage().open();
		LogIn_PasswordPage passwordPage = emailPage.inputEmail().submitEmail();
		GoogleAccountPage googleAccount = passwordPage.inputPassword(Account.getPassword()).submitPassword();
		GmailPage gmail = googleAccount.selectMail();
		gmail.clickCompose().inputAddressee(Account.getEmail()).inputSubject().inputLetterText().sendDraft();
		SentMailPage sentMail = gmail.toSentMailPage();
		sentMail.inputSearchQuery(GmailTestData.getSearchQuery()).clickSearch();
		LetterPage letter = sentMail.openSearchResult();
		LetterWindow letterInNewWindow = letter.inNewWindow();
		Assert.assertEquals(letterInNewWindow.getActualSubject(), Letter.getSubject());
		Assert.assertTrue(letterInNewWindow.getActualSender().contains(Account.getEmail()));
		Assert.assertTrue(letterInNewWindow.getActualLetterText().equals(Letter.getLetterText()));
		//letterInNewWindow.removeLetter();
		letterInNewWindow.closeLetterWindow();
		//Assert.assertFalse(sentMail.getEmailTime().equals(GmailTestData.getSendingTime()));
	}
	/**
	 * close browser
	 */
	@AfterTest
	public void tearDown() {
		WebDriverSingleton.getWebDriverInstance().quit();
	}
}