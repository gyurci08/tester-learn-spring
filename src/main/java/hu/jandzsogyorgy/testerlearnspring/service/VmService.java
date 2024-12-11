package hu.jandzsogyorgy.testerlearnspring.service;

import hu.jandzsogyorgy.testerlearnspring.dto.VmDto;
import hu.jandzsogyorgy.testerlearnspring.mapping.JsonDtoMapper;
import hu.jandzsogyorgy.testerlearnspring.mapping.VmMapper;
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
public class VmService {
    private final PveClient client;
    private final JsonDtoMapper jsonDtoMapper;
    private final VmMapper vmMapper;

    public List<VmDto> listAllVm(String node) {
        JSONObject response = client.getNodes().get(node).getQemu().vmlist().getResponse();

        return response.getJSONArray("data").toList().stream()
                .map(obj -> jsonDtoMapper.jsonToDto(obj, VmDto.class))
                .collect(Collectors.toList());
    }
}
