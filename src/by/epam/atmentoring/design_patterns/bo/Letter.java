package by.epam.atmentoring.design_patterns.bo;
/**
 * class for Email letter business object
 * @author Valiantsin_Ivashynka
 *
 */
public class Letter {

	private static final String ADDRESSEE = "iv.selenium.test2@yopmail.com";
	private static final String SUBJECT = "Test subject";
	private static final String LETTER_TEXT = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.\n\nKind regards,\nJohn Doe";
	/**
	 * get email address of addressee
	 * @return email address of addressee
	 */
	public static String getAddressee() {
		return ADDRESSEE;
	}
	/**
	 * get email subject
	 * @return email subject
	 */
	public static String getSubject() {
		return SUBJECT;
	}
	/**
	 * get email text
	 * @return email text
	 */
	public static String getLetterText() {
		return LETTER_TEXT;
	}
}