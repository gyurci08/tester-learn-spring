package hu.jandzsogyorgy.testerlearnspring.dto;

public record VmDto(
        int vmid,
        int cpus,
        long diskread,
        double cpu,
        long netout,
        long uptime,
        long disk,
        long mem,
        long maxdisk,
        String name,
        long diskwrite,
        long maxmem,
        long netin,
        String status
) {

}
