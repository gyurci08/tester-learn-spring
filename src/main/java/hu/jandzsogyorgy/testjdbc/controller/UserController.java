package hu.jandzsogyorgy.testjdbc.controller;


import hu.jandzsogyorgy.testjdbc.dto.UserDto;
import hu.jandzsogyorgy.testjdbc.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/user", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class UserController {
    private final UserService userService;


    @GetMapping
    public List<UserDto> listAllUsers(){
        return userService.listAllUsers();
    }
}
