package by.epam.atmentoring.design_patterns.test_data;

import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * Class for storing test data not related to business objects
 * @author Valiantsin_Ivashynka
 *
 */
public class GmailTestData {
	protected static final String URL = "https://accounts.google.com/signin/v2/identifier";
	protected static final String SEARCH_QUERY = "subject";
	private static String sendingTime = "";
	/**
	 * get word by which email search is executed
	 * @return search query string
	 */
	public static String getSearchQuery() {
		return SEARCH_QUERY;
	}
	/**
	 * get URL of the Gmail login page
	 * @return URL of the Gmail login page
	 */
	public static String getURL() {
		return URL;
	}
	/**
	 * set time when the last email was sent
	 */
	public static void setSendingTime() {
		sendingTime = (new SimpleDateFormat("hh:mm a").format(new Date()).toLowerCase()).replaceFirst("^0+(?!$)", "");
	}
	/**
	 * get time when the last email was sent
	 * @return time when the last email was sent
	 */
	public static String getSendingTime() {
		return sendingTime;
	}
}