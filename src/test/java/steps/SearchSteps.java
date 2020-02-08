package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import pages.MapPage;

public class SearchSteps {

    private LoginPage loginPage = new LoginPage();
    private MapPage mapPage = new MapPage();

    @Given("user opens the Google Maps application")
    public void userOpensTheGoogleMapsApplication() {
        loginPage.checkGreetingTexts();
        loginPage.checkLoginImage();
        loginPage.checkButtonsVisible();
    }

    @When("user taps on skip button")
    public void userTapsOnSkipButton() {
        loginPage.tapOnSkipButton();
    }

    @Then("user sees map screen")
    public void userSeesMapScreen() {
        mapPage.checkMapButtons();
        mapPage.checkMapWatermark();
    }

    @When("user types {string} into search field")
    public void userTypedIntoSearchField(String text) {
        mapPage.typeTextToSearchField(text);
    }

    @Then("user sees a dropdown list of suggestions")
    public void userSeesADropdownListOfSuggestions() {
        mapPage.checkSuggestionsList();
    }

    @When("user select {int} suggestion")
    public void userSelectSuggestion(Integer suggestionIndex) {
        mapPage.selectSuggestion(suggestionIndex);
    }

    @Then("user sees title {string}")
    public void userSeesTitle(String title) {
        mapPage.checkResultTitle(title);
    }

    @When("user taps on result")
    public void userTapOnResult() {
        mapPage.tapOnResultTitle();
    }

    @Then("user sees category {string}")
    public void userSeesCategory(String category) {
        mapPage.checkResultCategory(category);
    }
}