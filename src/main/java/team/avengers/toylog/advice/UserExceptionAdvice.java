package team.avengers.toylog.advice;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import team.avengers.toylog.advice.exception.UserNotFoundException;
import team.avengers.toylog.model.ApiResponseDto;
import team.avengers.toylog.service.ResponseService;

import javax.servlet.http.HttpServletRequest;

@RequiredArgsConstructor
@RestControllerAdvice
public class UserExceptionAdvice {
    private final ResponseService<String> responseService;
    private final MessageSource messageSource;

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    protected ApiResponseDto<String> userNotFound(HttpServletRequest request, UserNotFoundException exception) {
        return responseService.getFailureApiResponseDto(
                Integer.parseInt(getMessage("user-not-found.code")),
                getMessage("user-not-found.msg"),
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
