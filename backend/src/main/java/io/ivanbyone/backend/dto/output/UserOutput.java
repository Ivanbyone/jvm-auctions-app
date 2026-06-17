package io.ivanbyone.backend.dto.output;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class UserOutput extends OutputDto {
    private String id;
    private String username;
    private int balance;
    private Date createdAt;
    private Date updatedAt;
}
