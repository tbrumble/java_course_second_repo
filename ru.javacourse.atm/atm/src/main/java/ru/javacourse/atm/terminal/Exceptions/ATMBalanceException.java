package ru.javacourse.atm.terminal.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ATMBalanceException extends RuntimeException{
    public ATMBalanceException() {
    }
    public ATMBalanceException(String message) {
        super(message);
    }

    public ATMBalanceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ATMBalanceException(Throwable cause) {
        super(cause);
    }

    public ATMBalanceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
