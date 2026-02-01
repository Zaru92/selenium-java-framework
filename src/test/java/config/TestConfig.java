package config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestConfig {
    private static final Properties props = new Properties();

    static {
        try (InputStream is = TestConfig.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (is == null) throw new RuntimeException("Missing config.properties file in resources");
            props.load(is);
        } catch (IOException e) {
            throw new RuntimeException("Could not load config.properties", e);
        }
    }

    public static String baseUrl()
    {return get("baseUrl", "https://automationteststore.com/");
    }

    public static String browser() {
        return get("browser", "chrome");
    }

    public static boolean headless() {
        return Boolean.parseBoolean(get("headless", "false"));
    }

    public static long timeoutSeconds() {
        String raw = get("timeoutSeconds", "10");
        if (raw == null || raw.trim().isEmpty()) return 10L;
        return Long.parseLong(raw.trim());
    }

    private static String get(String key, String def) {
        return System.getProperty(key, props.getProperty(key, def));
    }
}
