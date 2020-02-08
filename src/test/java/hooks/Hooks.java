package hooks;

import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.selenide.AllureSelenide;

/**
 * The settings class is performed before / after each test
 */
public class Hooks {

    private static AndroidDriver driver = null;

    @Before
    public void setupDriver() {
        driver = (AndroidDriver) WebDriverRunner.getWebDriver();
    }

    @Before
    public void screenshotListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(false));
    }

    @After
    public void closeApp() {
        driver.closeApp();
    }
}