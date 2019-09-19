package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchResultsPage extends BasePage{



    public static List<WebElement> getSearchResults() {
        List<WebElement> linksize = driver.findElements(By.xpath("//div[@class='r']"));

        return linksize;
    }

    public static void browseAllResults() {
        List<WebElement> resultPages =driver.findElements(By.xpath("//*[@id='nav']/tbody/tr/td/a"));
        for(WebElement page:resultPages){
        driver.findElement(By.xpath("//span[text()='Next']")).click();

        }
    }

    public static String getNoSearchResults() {
        return driver.findElement(By.xpath("//div[@class='med card-section']/p[@role='heading']")).getText();
    }
}
