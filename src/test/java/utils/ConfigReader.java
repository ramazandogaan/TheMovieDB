package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;

    static {
        try {
            String path = "src/test/resources/configuration.properties";
            FileInputStream fis = new FileInputStream(path);

            properties = new Properties();
            properties.load(fis);
            fis.close();

        } catch (IOException e) {
            throw new RuntimeException("configuration.properties dosyası okunamadı!", e);
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
}
