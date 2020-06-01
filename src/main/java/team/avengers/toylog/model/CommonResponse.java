package team.avengers.toylog.model;

public enum CommonResponse {
    SUCCESS(0, "성공");

    int code;
    String msg;

    CommonResponse(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
