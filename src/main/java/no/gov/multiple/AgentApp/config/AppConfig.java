package no.gov.multiple.AgentApp.config;

import java.io.InputStream;
import java.util.Properties;

public class AppConfig {
    private static final Properties PROPERTIES = new Properties();

    static {
        try (InputStream input = AppConfig.class
                .getClassLoader()
                .getResourceAsStream("application.properties")) {

            if (input == null) {
                throw new RuntimeException("application.properties not found in classpath");
            }

            PROPERTIES.load(input);
        } catch (Exception e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    private AppConfig() {}

    public static String get(String key) {
        return PROPERTIES.getProperty(key);
    }

    public static int getInt(String key) {
        return Integer.parseInt(PROPERTIES.getProperty(key));
    }
}
