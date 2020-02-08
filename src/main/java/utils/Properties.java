package utils;

/**
 * The class contains static fields for data from application.properties
 */
public class Properties {

    private Properties() {
        throw new IllegalStateException("Properties class");
    }

    private static String version = null;

    private static String emulator = null;

    public static String getVersion() {
        if (version == null) {
            version = PropertyLoader.loadProperty("test.version");
        }
        return version;
    }

    public static String getEmulator() {
        if (emulator == null) {
            emulator = PropertyLoader.loadProperty("test.emulator");
        }
        return emulator;
    }
}