package io.ivanbyone.backend.controller;

import io.ivanbyone.backend.dto.input.UserInput;
import io.ivanbyone.backend.dto.output.ResponseContract;
import io.ivanbyone.backend.dto.output.UserOutput;
import io.ivanbyone.backend.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get user profile by ID", description = "Show public information about user profile by ID")
    @Parameter(name = "id", description = "User ID", example = "1")
    @ApiResponse(responseCode = "200", content = @Content(
            schema = @Schema(implementation = ResponseContract.class)
    ))
    @ApiResponse(responseCode = "404", content = @Content(
            schema = @Schema(implementation = ResponseContract.class)
    ))
    public ResponseContract<UserOutput> getUserById(
            @PathVariable("id") @NotBlank(message = "Path variable 'id' is required") String id
    ) {
        UserOutput output = userService.getUserById(id);
        return ResponseContract.<UserOutput>builder()
                .message(output)
                .status(200)
                .build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create new user", description = "Create new user without balance initialization")
    @ApiResponse(responseCode = "201", content = @Content(
            schema = @Schema(implementation = ResponseContract.class)
    ))
    @ApiResponse(responseCode = "400", content = @Content(
            schema = @Schema(implementation = ResponseContract.class)
    ))
    @ApiResponse(responseCode = "422", content = @Content(
            schema = @Schema(implementation = ResponseContract.class)
    ))
    public ResponseContract<UserOutput> createNewUser(@RequestBody UserInput body) {
        UserOutput output = userService.createNewUser(body);
        return ResponseContract.<UserOutput>builder()
                .message(output)
                .status(201)
                .build();
    }
}
