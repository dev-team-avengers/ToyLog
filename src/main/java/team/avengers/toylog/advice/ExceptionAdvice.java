package team.avengers.toylog.advice;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import team.avengers.toylog.advice.exception.TestNotFoundException;
import team.avengers.toylog.model.ApiResponseDto;
import team.avengers.toylog.service.ResponseService;

import javax.servlet.http.HttpServletRequest;

@RequiredArgsConstructor
@RestControllerAdvice
public class ExceptionAdvice {
    private final ResponseService<String> responseService;
    private final MessageSource messageSource;

//    @ExceptionHandler(Exception.class)
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    protected ApiResponseDto<String> defaultException(HttpServletRequest request, Exception exception) {
//        return responseService.getFailureApiResponseDto(
//                Integer.parseInt(getMessage("unknown.code")),
//                getMessage("unknown.msg"),
//                exception.getMessage()
//        );
//    }

    @ExceptionHandler(TestNotFoundException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    protected ApiResponseDto<String> testNotFound(HttpServletRequest request, TestNotFoundException exception) {
        return responseService.getFailureApiResponseDto(
                Integer.parseInt(getMessage("test-not-found.code")),
                getMessage("test-not-found.msg"),
                exception.getMessage()
        );
    }

    private String getMessage(String code) {
        return this.getMessage(code, null);
    }

    private String getMessage(String code, Object[] args) {
        return messageSource.getMessage(code, args, LocaleContextHolder.getLocale());
    }
}
