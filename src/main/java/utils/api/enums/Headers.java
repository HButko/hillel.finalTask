package utils.api.enums;

public enum Headers {
    JSON("Content-Type", "application/json"),
    IMAGE("Content-Type", "multipart/form-data");

    private String contentType;
    private String value;

    Headers(String contentType, String value) {
        this.contentType = contentType;
        this.value = value;
    }

    public String getContentType() {
        return contentType;
    }

    public String getValue() {
        return value;
    }
}
