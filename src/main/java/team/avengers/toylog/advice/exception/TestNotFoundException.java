package team.avengers.toylog.advice.exception;

public class TestNotFoundException extends RuntimeException {
    public TestNotFoundException(String msg, Throwable throwable) {
        super(msg, throwable);
    }

    public TestNotFoundException(String msg) {
        super(msg);
    }

    public TestNotFoundException() {
        super();
    }
}
