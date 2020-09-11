package org.kodluyoruz.trendyol.exception;

public class MessageLimitException extends RuntimeException {
    public MessageLimitException(String errorMessage) {
        super(errorMessage);
    }
}
