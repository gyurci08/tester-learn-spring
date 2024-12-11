package hu.jandzsogyorgy.testerlearnspring.service;

import hu.jandzsogyorgy.testerlearnspring.dto.NodeDto;
import hu.jandzsogyorgy.testerlearnspring.mapping.JsonDtoMapper;
import it.corsinvest.proxmoxve.api.PveClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class NodeService {
    private final PveClient client;
    private final JsonDtoMapper jsonDtoMapper;
    private final VmService vmService;


    public List<NodeDto> listAllNode() {
        JSONObject response = client.getNodes().index().getResponse();

        return response.getJSONArray("data").toList().stream()
                .map(obj -> jsonDtoMapper.jsonToDto(obj, NodeDto.class))
                .collect(Collectors.toList());
    }

    public NodeDto getNode(String node) {
        List<NodeDto> nodes = listAllNode();

        return nodes.stream()
                .filter(n -> n.node().equals(node))
                .findFirst()
                .orElse(null);
    }
}
