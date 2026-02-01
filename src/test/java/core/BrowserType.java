package core;

public enum BrowserType {
    CHROME,
    FIREFOX,
    EDGE,
    SAFARI;

    public static BrowserType from(String value) {
        return BrowserType.valueOf(value.toUpperCase());
    }
}
