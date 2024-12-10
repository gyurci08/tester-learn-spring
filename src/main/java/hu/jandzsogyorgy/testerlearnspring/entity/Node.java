package hu.jandzsogyorgy.testerlearnspring.entity;


import lombok.Data;

@Data
public class Node {
    private String id;
    private String status;
    private int maxcpu;
    private String level;
    private double cpu;
    private long disk;
    private long maxmem;
    private int uptime;
    private long mem;
    private String node;
    private String ssl_fingerprint;
    private long maxdisk;
    private String type;
}