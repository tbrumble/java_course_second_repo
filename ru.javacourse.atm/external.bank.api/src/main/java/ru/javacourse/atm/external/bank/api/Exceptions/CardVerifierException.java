package ru.javacourse.atm.external.bank.api.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CardVerifierException extends RuntimeException {
    public CardVerifierException(){}

    public CardVerifierException(String message) {
        super(message);
    }

    public CardVerifierException(String message, Throwable cause) {
        super(message, cause);
    }

    public CardVerifierException(Throwable cause) {
        super(cause);
    }

    public CardVerifierException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
