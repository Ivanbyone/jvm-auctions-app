package io.ivanbyone.backend.service.mapper;

import io.ivanbyone.backend.dto.input.UserInput;
import io.ivanbyone.backend.dto.output.UserOutput;
import io.ivanbyone.backend.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toModel(UserInput input);

    UserOutput toDto(User model);
}
