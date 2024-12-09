package hu.jandzsogyorgy.testjdbc.dto;

public record UserRoleDto(
        Long id,
        Long userId,
        Long roleId
) {
}
