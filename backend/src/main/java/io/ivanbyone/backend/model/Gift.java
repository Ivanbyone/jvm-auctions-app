package io.ivanbyone.backend.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Data
@Document(collection = "gifts")
public class Gift {
    @Id
    private String id;
    private String title;
    private String description;
    private String image;
    private int free;
    private int supply;

    // Auditing
    @CreatedDate
    private Date createdAt;
    @LastModifiedDate
    private Date updatedAt;
}
