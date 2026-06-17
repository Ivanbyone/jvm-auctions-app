package io.ivanbyone.backend.controller;

import io.ivanbyone.backend.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Tag(name = "User")
@SuppressWarnings("unused")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get user profile by ID", description = "Show public information about user profile by ID")
    @Parameter(name = "id", description = "User ID", example = "1")
    public String getUserById(@PathVariable("id") String id) {
        return userService.getUserById(id);
    }

    @PostMapping
    @Operation(summary = "Create new user", description = "Create new user with start balance initialization")
    public String createNewUser(@RequestBody String body) {
        return userService.createNewUser(body);
    }
}
