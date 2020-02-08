package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

/**
 * Class implements the map screen
 */
public class MapPage extends BasePage {

    private SelenideElement menuButton = $(byXpath("//android.widget.FrameLayout[@content-desc='Menu']"));

    private SelenideElement microphoneButton = $(byXpath("//android.widget.ImageButton[@content-desc='Tap to speak']"));

    private SelenideElement watermarkImage = $(byId("com.google.android.apps.maps:id/watermark_image"));

    private SelenideElement myLocationButton = $(byId("com.google.android.apps.maps:id/qu_mylocation_container"));

    private SelenideElement directionButton = $(byId("com.google.android.apps.maps:id/on_map_directions_button"));

    private SelenideElement searchHereField = $(byId("com.google.android.apps.maps:id/search_omnibox_text_box"));

    private ElementsCollection suggestions = $$(byXpath("//*[@resource-id='com.google.android.apps.maps:id/fullscreen_group']//android.widget.RelativeLayout"));

    private SelenideElement suggestionsList = $(byId("com.google.android.apps.maps:id/fullscreen_group"));

    private SelenideElement resultTitle = $(byXpath("(//android.widget.ViewSwitcher//android.widget.TextView)[1]"));

    private SelenideElement resultCategory = $(byXpath("(//android.widget.ViewSwitcher//android.widget.TextView)[7]"));

    public void checkMapButtons() {
        checkVisibleElements(menuButton, microphoneButton, myLocationButton, directionButton);
    }

    public void checkMapWatermark() {
        shouldBeConditions(watermarkImage, exist, enabled);
        checkVisibleElements(watermarkImage);
    }

    public void typeTextToSearchField(String text) {
        typeText(searchHereField, text);
    }

    public void checkSuggestionsList() {
        shouldBeConditions(suggestionsList, exist, enabled);
        checkVisibleElements(suggestionsList);
    }

    public void selectSuggestion(int suggestionIndex) {
        tap(suggestions.get(suggestionIndex - 1));
    }

    public void checkResultTitle(String title) {
        checkVisibleElements(resultTitle);
        checkText(resultTitle, title);
    }

    public void tapOnResultTitle() {
        tap(resultTitle);
    }

    public void checkResultCategory(String category) {
        checkVisibleElements(resultCategory);
        checkText(resultCategory, category);
    }
}