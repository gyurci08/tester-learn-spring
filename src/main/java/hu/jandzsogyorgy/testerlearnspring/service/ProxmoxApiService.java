package hu.jandzsogyorgy.testerlearnspring.service;

import hu.jandzsogyorgy.testerlearnspring.dto.VmDto;

import hu.jandzsogyorgy.testerlearnspring.entity.Vm;
import hu.jandzsogyorgy.testerlearnspring.mapping.VmMapper;
import it.corsinvest.proxmoxve.api.PveClient;
import it.corsinvest.proxmoxve.api.PveExceptionAuthentication;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProxmoxApiService {
    @Value("${proxmox.host}")
    private String proxmoxHost;
    @Value("${proxmox.port}")
    private int proxmoxPort;
    @Value("${proxmox.username}")
    private String username;
    @Value("${proxmox.password}")
    private String password;

    private final VmMapper vmMapper;


    private static PveClient instance;

    public PveClient getPveClient() {
        if (instance == null) {
            instance = new PveClient(proxmoxHost, proxmoxPort);
            try {
                instance.login(username, password);
            } catch (PveExceptionAuthentication e) {
                log.error("Authentication failed: {}", e.getMessage());
                return null;
            } catch (Exception e) {
                log.error("Unexpected error: {}", e.getMessage());
                return null;
            }
        }
        return instance;
    }


    public List<VmDto> listAllVm(){
        PveClient client = getPveClient();

        //https://10.3.2.11:8006/api2/json/nodes/jgy-pvedev/qemu
        JSONObject response = client.getNodes().get("jgy-pvedev").getQemu().vmlist().getResponse();
        JSONArray array = response.getJSONArray("data");
        List<Vm> vmList = array.toList().stream()
                .map(vmMapper::jsonToEntity)
                .collect(Collectors.toList());


        return vmMapper.toDto(vmList);

    }
}