package hu.jandzsogyorgy.testjdbc.controller;


import hu.jandzsogyorgy.testjdbc.dto.RoleDto;
import hu.jandzsogyorgy.testjdbc.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/role", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class RoleController {
    private final RoleService roleService;


    @GetMapping
    public List<RoleDto> listAllRoles(){
        return roleService.listAllRoles();
    }
}
