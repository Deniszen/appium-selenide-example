package server;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

/**
 * The class implements starting and stopping the Appium server
 */
public class AppiumServer {

    private AppiumServer() {
        throw new IllegalStateException("AppiumServer class");
    }

    private static AppiumDriverLocalService service;
    private static String serviceUrl;

    public static String getServiceUrl() {
        return serviceUrl;
    }

    private static void setServiceUrl(String serviceUrl) {
        AppiumServer.serviceUrl = serviceUrl;
    }

    public static void startServer() {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("noReset", "false");

        AppiumServiceBuilder builder = new AppiumServiceBuilder()
            .withIPAddress("127.0.0.1")
            .withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
            .usingAnyFreePort()
            .withCapabilities(cap)
            .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
            .withArgument(GeneralServerFlag.LOG_LEVEL,"error");

        service = AppiumDriverLocalService.buildService(builder);
        service.start();
        setServiceUrl(service.getUrl().toString());
    }

    public static void stopServer() {
        service.stop();
    }
}