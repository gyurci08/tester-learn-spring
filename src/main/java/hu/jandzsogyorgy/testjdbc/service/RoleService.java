package hu.jandzsogyorgy.testjdbc.service;

import hu.jandzsogyorgy.testjdbc.dto.RoleDto;
import hu.jandzsogyorgy.testjdbc.dto.UserDto;
import hu.jandzsogyorgy.testjdbc.mapping.RoleMapper;
import hu.jandzsogyorgy.testjdbc.mapping.UserMapper;
import hu.jandzsogyorgy.testjdbc.repository.RoleRepository;
import hu.jandzsogyorgy.testjdbc.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class RoleService {
    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;


    public List<RoleDto> listAllRoles(){

        return roleRepository.findAll()
                .stream()
                .map(roleMapper::toDto)
                .toList();
    }
}
