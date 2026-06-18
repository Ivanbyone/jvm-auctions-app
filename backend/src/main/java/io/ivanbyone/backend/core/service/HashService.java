package io.ivanbyone.backend.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class HashService {

    private final BCryptPasswordEncoder encoder;

    @Autowired
    public HashService(BCryptPasswordEncoder encoder) {
        this.encoder = encoder;
    }

    public String encode(String raw) {
        return encoder.encode(raw);
    }

    public boolean verify(String raw, String hashed) {
        return encoder.matches(raw, hashed);
    }
}
