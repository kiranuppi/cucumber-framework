package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webDriver.Driver;


public class BasePage {

	static WebDriver driver = Driver.getCurrentDriver();
	static WebDriverWait wait = new WebDriverWait(driver, 10);

	public static void launchBrowser(String searchCriteria) {

		driver.get(searchCriteria);
		wait.until(ExpectedConditions.elementToBeClickable(HomePage.searchField()));

	}

	public static void clickOnFirstLink() {
		//from the list of links obtained from the resulrs page click on the first link
		SearchResultsPage.getSearchResults().get(0).click();

	}

	public static String getTitle() {
		return driver.getTitle();
	}
}
