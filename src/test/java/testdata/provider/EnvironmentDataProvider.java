package testdata.provider;

public class EnvironmentDataProvider {

    private static final String BASE_URL_KEY = "base.url";
    private static final String DEFAULT_BASE_URL = "https://automationteststore.com/";

    public static String get(String key, String defaultValue) {
        return System.getProperty(key, defaultValue);
    }

    public static String baseUrl() {
        return System.getProperty(BASE_URL_KEY, DEFAULT_BASE_URL);
    }
}
