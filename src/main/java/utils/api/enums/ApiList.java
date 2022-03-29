package utils.api.enums;

public enum ApiList {
    SIGN_UP("http://localhost:8080/api/auth/signup"),
    SIGN_IN("http://localhost:8080/api/auth/signin"),

    USER_UPDATE("http://localhost:8080/api/user/update"),
    USER_ID("http://localhost:8080/api/user/"),
    USER_INFO("http://localhost:8080/api/user/"),

    IMAGE_UPLOAD("http://localhost:8080/api/image/upload"),
    IMAGE_ID("http://localhost:8080/api/image/"),
    IMAGE_PROFILE("http://localhost:8080/api/image/profile"),

    JOB_DELETE("http://localhost:8080/api/job/delete/"),
    JOB_CREATE("http://localhost:8080/api/job/create"),
    JOB_ID("http://localhost:8080/api/job/"),
    JOB_USER("http://localhost:8080/api/job/user/jobs"),
    JOB_ALL("http://localhost:8080/api/job/all"),

    COMMENT("http://localhost:8080/api/comment/");

    private String url;

    ApiList(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
