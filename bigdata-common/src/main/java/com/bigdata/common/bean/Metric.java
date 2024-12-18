package com.bigdata.common.bean;

import java.util.List;

public class Metric {

    private Integer id;

    private Long timestamp;

    private Integer cloudId;

    private String ip;

    private List<String> ports;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getCloudId() {
        return cloudId;
    }

    public void setCloudId(Integer cloudId) {
        this.cloudId = cloudId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public List<String> getPorts() {
        return ports;
    }

    public void setPorts(List<String> ports) {
        this.ports = ports;
    }

    public Metric() {
    }

    public Metric(Integer id, Long timestamp, Integer cloudId, String ip, List<String> ports) {
        this.id = id;
        this.timestamp = timestamp;
        this.cloudId = cloudId;
        this.ip = ip;
        this.ports = ports;
    }

    @Override
    public String toString() {
        return "Metric{" +
                "id=" + id +
                ", timestamp=" + timestamp +
                ", cloudId=" + cloudId +
                ", ip='" + ip + '\'' +
                ", ports=" + ports +
                '}';
    }
}
