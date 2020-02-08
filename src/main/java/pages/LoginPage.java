package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

/**
 * The class that implements the start screen
 */
public class LoginPage extends BasePage {

    private SelenideElement skipButton = $(byXpath("(//android.widget.Button)[2]"));

    private SelenideElement signInButton = $(byXpath("(//android.widget.Button)[1]"));

    private ElementsCollection greetingTexts = $$(byXpath("//android.widget.TextView"));

    private SelenideElement loginImage = $(byXpath("//android.widget.ImageView"));

    public void checkButtonsVisible() {
        checkVisibleElements(skipButton, signInButton);
    }

    public void checkGreetingTexts() {
        greetingTexts.forEach(this::checkVisibleElements);
        greetingTexts.shouldHave(texts("Make it your map"
                , "Sign in for quick access to your favorite places and get better recommendations"));
    }

    public void checkLoginImage() {
        checkVisibleElements(loginImage);
    }

    public void tapOnSkipButton() {
        tap(skipButton);
    }
}