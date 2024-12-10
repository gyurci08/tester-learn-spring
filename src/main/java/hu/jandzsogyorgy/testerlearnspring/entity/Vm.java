package hu.jandzsogyorgy.testerlearnspring.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
public class Vm {
    private int vmid;
    private int cpus;
    private long diskread;
    private double cpu;
    private long netout;
    private long uptime;
    private long disk;
    private long mem;
    private long maxdisk;
    private String name;
    private long diskwrite;
    private long maxmem;
    private long netin;
    private String status;
}
