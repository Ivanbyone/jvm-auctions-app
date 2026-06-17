package io.ivanbyone.backend.service;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    public String getUserById(String id) {
        return id;
    }

    public String createNewUser(String body) {
        return body;
    }
}
