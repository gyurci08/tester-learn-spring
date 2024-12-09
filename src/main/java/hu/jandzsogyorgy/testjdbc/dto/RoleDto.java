package hu.jandzsogyorgy.testjdbc.dto;

import java.util.List;

public record RoleDto(
        Long id,
        String name,

        List<UserDto> users
) {
}
