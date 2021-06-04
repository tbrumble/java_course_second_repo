package ru.javacourse.atm.external.bank.api.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CardVerifyBaseException extends RuntimeException {
    public CardVerifyBaseException(){}

    public CardVerifyBaseException(String message) {
        super(message);
    }

    public CardVerifyBaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public CardVerifyBaseException(Throwable cause) {
        super(cause);
    }

    public CardVerifyBaseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
