@search
Feature: Search Google for links
  As an internet user
  I want to use Google to search for websites
  So that I can find them without knowing the URL

  Background:
    Given I open the browser and go on "https://www.google.co.uk"

  Scenario: Search for UBS and navigate to home page

    When I search for "UBS"
    Then I should see the search results for "UBS"
    When I click on the first link
    Then I should be redirected to "UBS" website


  Scenario: Search for UBS and browse all the results through pagination

    When I search for "UBS"
    Then I should see the search results for "UBS"
    And Browse all result pages

  Scenario: Search for EJ17FEMFGTKL& and verify no results found

    When I search for "EJ17FEMFGTKL&"
    Then I should not see any results for "EJ17FEMFGTKL&"
