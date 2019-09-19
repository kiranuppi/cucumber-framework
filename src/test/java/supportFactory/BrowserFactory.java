package supportFactory;

import enums.Browser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import testRunner.TestRunner;

public class BrowserFactory {
	
	static Browser browser = Browser.valueOf(TestRunner.config.get("browser"));
	
	static String desiredBrowserVersion = TestRunner.config.get("browserVersion");
	static String os = TestRunner.config.get("os");

	public static DesiredCapabilities selectBrowser(DesiredCapabilities caps) {
		
		switch (browser) {
		case Chrome:
			caps.setCapability("browserName", "chrome");
			break;
		case IE:
			caps.setCapability("browserName", "internet explorer");
			caps.setCapability("browserstack.ie.enablePopups", "true");
			caps.setCapability("ignoreZoomSetting", true);
			caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			caps.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
			caps.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
			break;


		default:
			throw new WebDriverException("No browser specified");
		}
		caps.setCapability("version", desiredBrowserVersion);
		return caps;
	}
	
	public static WebDriver selectLocalBrowser() {
		switch (browser) {
		case Chrome:
			if(os.equalsIgnoreCase("windows")){

				System.setProperty("webdriver.chrome.driver", "./src/test/resources/driver/chromedriver.exe");
				return new ChromeDriver();
			}
			if(os.equalsIgnoreCase("linux")){

				System.setProperty("webdriver.chrome.driver", "./src/test/resources/driver/chromedriver_linux64/chromedriver");
				return new ChromeDriver();
			}
		case IE:
			System.setProperty("webdriver.ie.driver", "./src/test/resources/driver/IEDriverServer_x64_3.9.0/IEDriverServer.exe");
			return new InternetExplorerDriver();

		default:
			throw new WebDriverException("No browser specified");
		}
	}
}
