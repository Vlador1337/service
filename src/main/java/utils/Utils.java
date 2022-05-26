package utils;

import java.io.IOException;
import java.util.Properties;

/**
 * @author Vlador1337
 * Class Utils
 */
public class Utils {

    private static Properties prop = new Properties();

    static {
        try {
            prop.load(Utils.class.getClassLoader().getResourceAsStream("database.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param key setting for connection to database
     * @return settings
     */
    public static String getProperty(String key) {
        return prop.getProperty(key);
    }

}
