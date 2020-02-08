package driver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.html5.Location;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import static server.AppiumServer.getServiceUrl;
import static utils.Properties.getEmulator;
import static utils.Properties.getVersion;

/**
 * The class implements the creation of an Android driver
 */
public class AndroidDriverProvider {

    private AndroidDriverProvider() {
        throw new IllegalStateException("AndroidDriverProvider class");
    }

    private static final Logger LOGGER = Logger.getLogger(AndroidDriverProvider.class.getName());

    private static AndroidDriver driver = null;

    public static WebDriver getAndroidDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, getVersion());
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("appPackage", "com.google.android.apps.maps");
        capabilities.setCapability("autoGrantPermissions", "true");
        capabilities.setCapability("noReset", false);
        capabilities.setCapability("fullReset", false);
        capabilities.setCapability("noResetValue","false");
        capabilities.setCapability("avd", getEmulator());
        capabilities.setCapability("avdLaunchTimeout", 180000);
        capabilities.setCapability("avdReadyTimeout", 180000);
        capabilities.setCapability ("appActivity", "com.google.android.maps.MapsActivity");

        if (driver == null) {
            try {
                driver = new AndroidDriver(new URL(getServiceUrl()), capabilities);
                driver.setLocation(new Location(59.43, 24.72, 10));
            } catch (MalformedURLException e) {
                LOGGER.log(Level.SEVERE,e.toString(), e);
            }
        }
        return driver;
    }
}