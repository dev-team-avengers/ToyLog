package team.avengers.toylog.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ApiResponseDto<T> {
    private final int code;
    private final String msg;
    private final T data;

    public static <T> ApiResponseDto<T> of(int code, String msg, T data) {
        return new ApiResponseDto<> (code, msg, data);
    }

    public static <T>ApiResponseDto<T> of(CommonResponse commonResponse, T data) {
        return of(commonResponse.code, commonResponse.msg, data);
    }
}
