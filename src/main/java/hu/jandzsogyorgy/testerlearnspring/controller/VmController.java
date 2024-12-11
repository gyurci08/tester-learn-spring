package hu.jandzsogyorgy.testerlearnspring.controller;

import hu.jandzsogyorgy.testerlearnspring.dto.VmDto;
import hu.jandzsogyorgy.testerlearnspring.service.NodeService;
import hu.jandzsogyorgy.testerlearnspring.service.VmService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/api/pve/nodes/{node}/vms", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class VmController {
    private final NodeService nodeService;
    private final VmService vmService;

    private boolean validateNode(String node) {
        try {
            return nodeService.getNode(node) != null;
        } catch (Exception e) {
            return false;
        }
    }

    @GetMapping
    public List<VmDto> getVms(@PathVariable String node) {
        if(validateNode(node)){
            return vmService.listAllVm(node);
        }
        return List.of();
    }
}