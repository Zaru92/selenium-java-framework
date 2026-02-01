package core;

public enum BrowserType {
    CHROME,
    FIREFOX,
    EDGE,
    SAFARI;

    public static BrowserType from(String value) {
        if (value == null || value.trim().isEmpty()) {
            return CHROME;
        }
        return BrowserType.valueOf(value.trim().toUpperCase());
    }
}
