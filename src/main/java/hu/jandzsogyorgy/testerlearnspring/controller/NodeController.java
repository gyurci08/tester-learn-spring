package hu.jandzsogyorgy.testerlearnspring.controller;

import hu.jandzsogyorgy.testerlearnspring.dto.NodeDto;
import hu.jandzsogyorgy.testerlearnspring.service.NodeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/api/pve/nodes", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class NodeController {
    private final NodeService nodeService;

    @GetMapping
    public List<NodeDto> getNodes() {
        return nodeService.listAllNode();
    }

    @GetMapping("/{node}")
    public NodeDto getNode(@PathVariable String node) {
        return nodeService.getNode(node);
    }
}
