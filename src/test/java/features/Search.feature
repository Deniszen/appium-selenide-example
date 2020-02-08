@test
@search
Feature: Search

  @success
  Scenario: Search
    Given user opens the Google Maps application
    When user taps on skip button
    Then user sees map screen
    When user types "Viru Gate" into search field
    Then user sees a dropdown list of suggestions
    When user select 1 suggestion
    Then user sees title "Viru Gate"
    When user taps on result
    Then user sees title "Viru Gate"
    And user sees category "Historical landmark"