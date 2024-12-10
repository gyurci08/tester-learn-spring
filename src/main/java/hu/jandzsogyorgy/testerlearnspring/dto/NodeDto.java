package hu.jandzsogyorgy.testerlearnspring.dto;

public record NodeDto(
        String id,
        String status,
        int maxcpu,
        String level,
        double cpu,
        long disk,
        long maxmem,
        int uptime,
        long mem,
        String node,
        String ssl_fingerprint,
        long maxdisk,
        String type
) {

}
