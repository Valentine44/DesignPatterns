package by.epam.atmentoring.design_patterns.bo;
/**
 * test Google account class
 * @author Valiantsin_Ivashynka
 *
 */
public class Account {

	private static final String EMAIL = "iv.selenium.test@gmail.com";
	private static final String PASSWORD = "$T123456";
	private static final String INCORRECT_PASSWORD = "wrong!";
	/**
	 * get email of the test Google account
	 * @return email of the test Google account
	 */
	public static String getEmail() {
		return EMAIL;
	}
	/**
	 * get password to access the test Google account
	 * @return password to access the test Google account
	 */
	public static String getPassword() {
		return PASSWORD;
	}
	/**
	 * get incorrect password of the test Google account
	 * @return incorrect password of the test Google account
	 */
	public static String getIncorrectPassword() {
		return INCORRECT_PASSWORD;
	}
}