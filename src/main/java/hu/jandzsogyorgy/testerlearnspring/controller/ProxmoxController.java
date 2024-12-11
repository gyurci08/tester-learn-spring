package hu.jandzsogyorgy.testerlearnspring.controller;

import hu.jandzsogyorgy.testerlearnspring.dto.NodeDto;
import hu.jandzsogyorgy.testerlearnspring.dto.VmDto;
import hu.jandzsogyorgy.testerlearnspring.service.ProxmoxService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/api/pve", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class ProxmoxController {
    private final ProxmoxService proxmoxService;

    @GetMapping("/nodes")
    public List<NodeDto> getNodes() {
        return proxmoxService.listAllNode();
    }

    @GetMapping("/nodes/{node}")
    public NodeDto getNode(@PathVariable String node) {
        return proxmoxService.getNode(node);
    }



    @GetMapping("/vms")
    public List<VmDto> getVms() {
        return proxmoxService.listAllVm();
    }











}
