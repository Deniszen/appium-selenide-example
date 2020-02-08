package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;

/**
 * Base page class
 */
public abstract class BasePage {

    private static final int WAIT_FIVE_SECOND = 5000;
    private static final int WAIT_TEN_SECOND = 10000;

    protected void tap(SelenideElement element) {
        element.waitUntil(visible, WAIT_FIVE_SECOND);
        element.shouldBe(enabled);
        element.click();
    }

    protected void shouldBeConditions(SelenideElement element, Condition... conditions){
        for(Condition condition: conditions){
            element.shouldBe(condition);
        }
    }

    protected void checkText(SelenideElement element, String text) {
        element.shouldBe(visible).shouldHave(text(text));
    }

    protected void checkVisibleElements(SelenideElement... elements) {
        for(SelenideElement element: elements) {
            element.waitUntil(visible, WAIT_TEN_SECOND);
        }
    }

    protected void typeText(SelenideElement element, String text) {
        element.shouldBe(visible);
        element.clear();
        element.sendKeys(text);
    }
}