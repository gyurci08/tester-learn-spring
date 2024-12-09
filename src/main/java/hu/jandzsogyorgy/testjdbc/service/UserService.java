package hu.jandzsogyorgy.testjdbc.service;

import hu.jandzsogyorgy.testjdbc.dto.UserDto;
import hu.jandzsogyorgy.testjdbc.mapping.UserMapper;
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
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;


    public List<UserDto> listAllUsers(){

        return userRepository.findAll()
                .stream()
                .map(userMapper::toDto)
                .toList();
    }
}
