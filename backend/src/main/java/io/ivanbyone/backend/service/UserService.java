package io.ivanbyone.backend.service;

import io.ivanbyone.backend.core.error.AlreadyExistsException;
import io.ivanbyone.backend.core.error.NotFoundException;
import io.ivanbyone.backend.dto.input.UserInput;
import io.ivanbyone.backend.dto.output.UserOutput;
import io.ivanbyone.backend.model.User;
import io.ivanbyone.backend.repository.UserRepository;
import io.ivanbyone.backend.service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserMapper mapper;
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserMapper mapper, UserRepository userRepository) {
        this.mapper = mapper;
        this.userRepository = userRepository;
    }

    public UserOutput getUserById(String id) {
        User model = userRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException("Not found user with ID: " + id));
        return mapper.toDto(model);
    }

    public UserOutput createNewUser(UserInput input) {
        userRepository.findByUsername(input.getUsername())
                .ifPresent(user -> {
                    throw new AlreadyExistsException("This username is already taken");
                });

        User model = mapper.toModel(input);
        User saved = userRepository.save(model);
        return mapper.toDto(saved);
    }
}
