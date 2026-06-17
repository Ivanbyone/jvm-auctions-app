package io.ivanbyone.backend.service;

import io.ivanbyone.backend.dto.input.UserInput;
import io.ivanbyone.backend.dto.output.UserOutput;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public UserOutput getUserById(String id) {
        UserOutput output = new UserOutput();
        output.setId(id);
        return output;
    }

    public UserOutput createNewUser(UserInput body) {
        UserOutput output = new UserOutput();
        output.setUsername(body.getUsername());
        return output;
    }
}
