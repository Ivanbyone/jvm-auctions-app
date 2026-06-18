package io.ivanbyone.backend.core;

import io.ivanbyone.backend.core.error.AlreadyExistsException;
import io.ivanbyone.backend.core.error.NotFoundException;
import io.ivanbyone.backend.dto.output.ResponseContract;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@SuppressWarnings("unused")
public class RootExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseContract<String> handleNotFoundException(NotFoundException e) {
        return ResponseContract.<String>builder()
                .success(false)
                .message(e.getLocalizedMessage())
                .status(404)
                .build();
    }

    @ExceptionHandler(AlreadyExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseContract<String> handleAlreadyExistsException(AlreadyExistsException e) {
        return ResponseContract.<String>builder()
                .success(false)
                .message(e.getLocalizedMessage())
                .status(400)
                .build();
    }
}
