package Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ATMVerifyCardException extends RuntimeException {
    public ATMVerifyCardException() {
    }
    public ATMVerifyCardException(String message) {
        super(message);
    }

    public ATMVerifyCardException(String message, Throwable cause) {
        super(message, cause);
    }

    public ATMVerifyCardException(Throwable cause) {
        super(cause);
    }

    public ATMVerifyCardException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}