package io.ivanbyone.backend.core.error;

public class HeaderValidationException extends RuntimeException {
    public HeaderValidationException(String message) {
        super(message);
    }
}
