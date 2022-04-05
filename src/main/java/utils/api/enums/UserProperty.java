package utils.api.enums;

public enum UserProperty {
    USER_NAME("username"),
    NAME("name"),
    LAST_NAME("lastname");

    private String value;

    UserProperty(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
