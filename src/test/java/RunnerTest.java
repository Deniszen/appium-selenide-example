import com.codeborne.selenide.WebDriverRunner;
import driver.AndroidDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import server.AppiumServer;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import static utils.ApkPath.pathToApk;

/**
 * Running class containing JUnit settings
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features",
        glue = {"steps", "hooks"},
        tags = "@test",
        strict = false,
        dryRun = false,
        snippets = CucumberOptions.SnippetType.UNDERSCORE
)
public class RunnerTest {

    private static final Logger LOGGER = Logger.getLogger(RunnerTest.class.getName());

    @BeforeClass
    public static void setupDriver() {
        AppiumServer.startServer();
        WebDriverRunner.setWebDriver(AndroidDriverProvider.getAndroidDriver());
        AndroidDriver driver = (AndroidDriver) WebDriverRunner.getWebDriver();
        if (!driver.isAppInstalled("com.google.android.apps.maps")) {
            driver.installApp(pathToApk());
        }
    }

    @AfterClass
    public static void closeRemoveApp() {
        AndroidDriver driver = (AndroidDriver) WebDriverRunner.getWebDriver();
        String emulator = driver.getCapabilities().getCapability("deviceName").toString();
        driver.quit();
        try {
            Runtime.getRuntime().exec("adb -s " + emulator + " emu kill");
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, e.toString(), e);
        }
        AppiumServer.stopServer();
    }
}