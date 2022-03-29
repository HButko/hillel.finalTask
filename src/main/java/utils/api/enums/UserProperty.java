package utils.api.enums;

public enum UserProperty {
    USER_NAME("userName"),
    PASSWORD("userPassword");

    private String value;

    UserProperty(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
