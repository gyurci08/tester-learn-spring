package hu.jandzsogyorgy.testerlearnspring.service;

import it.corsinvest.proxmoxve.api.PveClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProxmoxService {
    private final PveClient client;

    public Map<String, String> testConnection() {
        Map<String, String> response = new HashMap<>();
        try {
            // Attempt to get the version information
            JSONObject versionInfo = client.getVersion().version().getResponse().getJSONObject("data");

            // If we get here without an exception, the connection was successful
            log.info("Successfully connected to Proxmox server. Version: {}", versionInfo.getString("version"));
            response.put("status", "connected");
            response.put("version", versionInfo.getString("version"));
        } catch (Exception e) {
            log.error("Failed to connect to Proxmox server", e);
            response.put("status", "failed");
            response.put("error", e.getMessage());
        }
        return response;
    }

}
