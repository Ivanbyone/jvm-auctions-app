package io.ivanbyone.backend.core;

import io.ivanbyone.backend.core.error.AlreadyExistsException;
import io.ivanbyone.backend.core.error.HeaderValidationException;
import io.ivanbyone.backend.core.error.NotFoundException;
import io.ivanbyone.backend.dto.output.ResponseContract;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@RestControllerAdvice
@SuppressWarnings("unused")
public class RootExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseContract<String> handleNotFoundException(NotFoundException e) {
        return ResponseContract.<String>builder()
                .success(false)
                .message(e.getLocalizedMessage())
                .status(HttpStatus.NOT_FOUND.value())
                .build();
    }

    @ExceptionHandler(AlreadyExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseContract<String> handleAlreadyExistsException(AlreadyExistsException e) {
        return ResponseContract.<String>builder()
                .success(false)
                .message(e.getLocalizedMessage())
                .status(HttpStatus.BAD_REQUEST.value())
                .build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_CONTENT)
    public ResponseContract<String> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        return ResponseContract.<String>builder()
                .success(false)
                .message(e.getLocalizedMessage())
                .status(HttpStatus.UNPROCESSABLE_CONTENT.value())
                .build();
    }

    @ExceptionHandler(NoResourceFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseContract<String> handleNoResourceFoundException(NoResourceFoundException e) {
        return ResponseContract.<String>builder()
                .success(false)
                .message(e.getLocalizedMessage())
                .status(HttpStatus.NOT_FOUND.value())
                .build();
    }

    @ExceptionHandler(HeaderValidationException.class)
    @ResponseStatus(HttpStatus.BAD_GATEWAY)
    public ResponseContract<String> handleNoResourceFoundException(HeaderValidationException e) {
        return ResponseContract.<String>builder()
                .success(false)
                .message(e.getLocalizedMessage())
                .status(HttpStatus.BAD_GATEWAY.value())
                .build();
    }
}
