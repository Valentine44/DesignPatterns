package by.epam.atmentoring.design_patterns.factory;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
/**
 * Firefox driver factory
 * @author Valiantsin_Ivashynka
 *
 */
public class FirefoxDriverCreator extends WebDriverCreator {
	/**
	 * Overridden WebDriverCreator.factoryMethod();
	 */
	@Override
	public WebDriver factoryMethod() {
		DesiredCapabilities capabilities = DesiredCapabilities.firefox(); 
		try{
			driver = new RemoteWebDriver(new URL("http://10.6.207.10:4444/wd/hub"),capabilities);
		} catch (MalformedURLException e){
			e.printStackTrace();
		}
		return driver;
	}
}