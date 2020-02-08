package utils;

import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The class implements getting variables from pom.xml through application.properties
 */
public class PropertyLoader {

    private static final Logger LOGGER = Logger.getLogger(PropertyLoader.class.getName());

    private PropertyLoader() {
        throw new IllegalStateException("PropertyLoader class");
    }

    private static final String PROP_FILE = "/application.properties";

    protected static String loadProperty(String name) {
        Properties props = new Properties();
        try {
            props.load(PropertyLoader.class.getResourceAsStream(PROP_FILE));
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, e.toString(), e);
        }

        String value = "";

        if (name != null) {
            value = props.getProperty(name);
        }
        return value;
    }
}