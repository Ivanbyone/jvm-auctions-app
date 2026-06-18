package io.ivanbyone.backend.dto.output;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ResponseContract<T> {
    @Builder.Default
    private boolean success = true;
    private T message;
    private int status;
    @Builder.Default
    private LocalDateTime timestamp = LocalDateTime.now();
}
