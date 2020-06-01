package team.avengers.toylog.service;

import org.springframework.stereotype.Service;
import team.avengers.toylog.model.ApiResponseDto;
import team.avengers.toylog.model.CommonResponse;

@Service
public class ResponseService<T> {
    public ApiResponseDto<T> getSuccessApiResponseDto(T data) {
        return ApiResponseDto.of(CommonResponse.SUCCESS, data);
    }

    public ApiResponseDto<T> getFailureApiResponseDto(int code, String msg, T data) {
        return ApiResponseDto.of(code ,msg, data);
    }
}
