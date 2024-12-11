package hu.jandzsogyorgy.testerlearnspring.config;

import it.corsinvest.proxmoxve.api.PveClient;
import it.corsinvest.proxmoxve.api.PveExceptionAuthentication;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProxmoxConfig {
    @Bean
    public PveClient pveClient(@Value("${proxmox.host}") String host,
                               @Value("${proxmox.port}") int port,
                               @Value("${proxmox.username}") String username,
                               @Value("${proxmox.password}") String password) throws PveExceptionAuthentication {
        PveClient client = new PveClient(host, port);
        client.login(username, password, "pam");
        return client;
    }
}
