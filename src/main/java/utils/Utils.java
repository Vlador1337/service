package utils;

import java.io.IOException;
import java.util.Properties;

public class Utils {

    private static Properties prop = new Properties();

    static {
        try {
            prop.load(Utils.class.getClassLoader().getResourceAsStream("database.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getProperty(String key) {
        return prop.getProperty(key);
    }

}
