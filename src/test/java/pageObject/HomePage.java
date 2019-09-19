package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage{
	
	public static WebElement searchField() {
		return driver.findElement(By.name("q"));
	}

	public static String searchResultsTitle() {
		return getTitle();
	}

	public static void search(String searchCriteria){
		HomePage.searchField().click();
		HomePage.searchField().sendKeys(searchCriteria + Keys.RETURN);
		wait.until(ExpectedConditions.titleContains("Google Search"));
	}
}
