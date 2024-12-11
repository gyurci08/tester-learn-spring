package hu.jandzsogyorgy.testerlearnspring.controller;

import hu.jandzsogyorgy.testerlearnspring.dto.VmDto;
import hu.jandzsogyorgy.testerlearnspring.service.ProxmoxService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping(value = "/api/pve", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class ProxmoxController {
    private final ProxmoxService proxmoxService;

    @GetMapping
    public Map<String, String> getProxmox() {
        return proxmoxService.testConnection();
    }

}
