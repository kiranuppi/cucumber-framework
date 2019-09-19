package stepDefinition;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObject.BasePage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObject.HomePage;
import pageObject.SearchResultsPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class GoogleSearch_Steps {
	
	String website;
	
	@Then("^I should see the search results for \"([^\"]*)\"$")
	public void i_should_see_the_search_results_for(String searchCriteria)  {
	    assertThat(HomePage.searchResultsTitle(), containsString(searchCriteria));
	}

	@When("^I have searched on Google$")
	public void i_have_searched_on_google() {
		String searchCriteria = website;
		HomePage.search(searchCriteria);
	}

	@When("^I click on the first link$")
	public void i_click_on_the_first_link() {
		BasePage.clickOnFirstLink();
	}

	@Then("^I should be redirected to \"([^\"]*)\" website$")
	public void i_should_be_redirected_to_website(String pageTitle) {
		assertThat(BasePage.getTitle(), containsString(pageTitle));
	}

	@And("^Browse all result pages$")
	public void browse_all_result_pages() {

		SearchResultsPage.browseAllResults();

	}

	@Then("^I should not see any results for \"([^\"]*)\"$")
	public void i_should_not_see_any_results_for(String searchString){
		assertThat(SearchResultsPage.getNoSearchResults(), containsString("Your search - "+searchString+" - did not match any documents."));

	}

	@Given("^I open the browser and go on \"([^\"]*)\"$")
	public void i_open_the_browser_an_go_on(String url) {
		BasePage.launchBrowser(url);
	}

	@When("^I search for \"([^\"]*)\"$")
	public void i_search_for(String searchWord) {
		HomePage.search(searchWord);


	}
}
