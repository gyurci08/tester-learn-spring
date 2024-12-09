package hu.jandzsogyorgy.testjdbc.dto;

import java.util.List;

public record UserDto(
        Long id,
        String username,
        String password,

        List<RoleDto> roles
) {
}
