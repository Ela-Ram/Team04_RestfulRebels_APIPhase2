package common;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;
    private static final String CONFIG_FILE_PATH = "src/test/resources/config.properties";

    static {
        try {
            properties = new Properties();
            FileInputStream input = new FileInputStream(CONFIG_FILE_PATH);
            properties.load(input);
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    public static void setProperty(String key, String value) {
        try (FileOutputStream output = new FileOutputStream(CONFIG_FILE_PATH)) {
            properties.setProperty(key, value);
            properties.store(output, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
