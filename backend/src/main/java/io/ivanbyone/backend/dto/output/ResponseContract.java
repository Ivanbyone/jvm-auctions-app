package io.ivanbyone.backend.dto.output;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ResponseContract<T extends OutputDto> {
    @Builder.Default
    private boolean success = true;
    private String path;
    private T body;
    private int status;
    @Builder.Default
    private LocalDateTime timestamp = LocalDateTime.now();
}
