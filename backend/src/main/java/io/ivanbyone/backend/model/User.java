package io.ivanbyone.backend.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Data
@Document(collation = "users")
public class User {
    // ID
    @Id
    private String id;
    // Public user's account name
    // Use as login for auth
    private String username;
    // Hashed password
    private String password;
    // Account balance
    // Default value - 0
    @Field
    private int balance = 0;

    // Auditing
    @CreatedDate
    @Field(name = "created_at")
    private Date createdAt;
    @LastModifiedDate
    @Field(name = "updated_at")
    private Date updatedAt;
}
