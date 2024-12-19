package com.bigdata.common.bean;

public class PortStrategy {

    private Integer id;

    private Integer cloudId;

    private String ip;

    private String port;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public PortStrategy() {
    }

    public PortStrategy(Integer id, Integer cloudId, String ip, String port) {
        this.id = id;
        this.cloudId = cloudId;
        this.ip = ip;
        this.port = port;
    }

    @Override
    public String toString() {
        return "Strategy{" +
                "id=" + id +
                ", cloudId=" + cloudId +
                ", ip='" + ip + '\'' +
                ", port='" + port + '\'' +
                '}';
    }
}
