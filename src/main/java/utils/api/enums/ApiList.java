package utils.api.enums;

public enum ApiList {
    SIGN_UP("https://freelance.lsrv.in.ua/api/auth/signup"),
    SIGN_IN("https://freelance.lsrv.in.ua/api/auth/signin"),

    USER_UPDATE("https://freelance.lsrv.in.ua/api/user/update"),
    USER_ID("https://freelance.lsrv.in.ua/api/user/"),
    USER_INFO("https://freelance.lsrv.in.ua/api/user/"),

    IMAGE_UPLOAD("https://freelance.lsrv.in.ua/api/image/upload"),
    IMAGE_ID("https://freelance.lsrv.in.ua/api/image/"),
    IMAGE_PROFILE("https://freelance.lsrv.in.ua/api/image/profile"),

    JOB_DELETE("https://freelance.lsrv.in.ua/api/job/delete/"),
    JOB_CREATE("https://freelance.lsrv.in.ua/api/job/create"),
    JOB_ID("https://freelance.lsrv.in.ua/api/job/"),
    JOB_USER("https://freelance.lsrv.in.ua/api/job/user/jobs"),
    JOB_ALL("https://freelance.lsrv.in.ua/api/job/all"),

    COMMENT("https://freelance.lsrv.in.ua/api/comment/");

    private String url;

    ApiList(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
