package hu.jandzsogyorgy.testjdbc.mapping;

import hu.jandzsogyorgy.testjdbc.config.MappingConfig;
import hu.jandzsogyorgy.testjdbc.dto.RoleDto;
import hu.jandzsogyorgy.testjdbc.dto.UserDto;
import hu.jandzsogyorgy.testjdbc.entity.Role;
import hu.jandzsogyorgy.testjdbc.entity.User;
import org.mapstruct.Mapper;

@Mapper(config = MappingConfig.class)
public interface UserMapper extends GenericMapper<User, UserDto> {
}
