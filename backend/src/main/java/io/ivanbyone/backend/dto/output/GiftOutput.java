package io.ivanbyone.backend.dto.output;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class GiftOutput extends OutputDto {
    private String id;
    private String title;
    private String description;
    private String image;
    private int totalSupply;
    private Date createdAt;
    private Date updatedAt;
}
