package team.avengers.toylog.advice.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String msg, Throwable throwable) {
        super(msg, throwable);
    }

    public UserNotFoundException(String msg) {
        super(msg);
    }

    public UserNotFoundException() {
        super();
    }
}
