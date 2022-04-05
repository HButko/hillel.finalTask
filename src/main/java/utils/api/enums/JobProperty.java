package utils.api.enums;

public enum JobProperty {
    TITLE("title"),
    DESCRIPTION("description"),
    MESSAGE("message");

    private String value;

    JobProperty(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}