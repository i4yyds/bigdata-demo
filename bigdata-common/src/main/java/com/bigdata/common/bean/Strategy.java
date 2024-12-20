package com.bigdata.common.bean;

public class Strategy {

    private Integer id;

    private String strategyType;

    private Integer cloudId;

    private String ip;

    private String value;

    private String op;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStrategyType() {
        return strategyType;
    }

    public void setStrategyType(String strategyType) {
        this.strategyType = strategyType;
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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }

    public Strategy() {
    }

    public Strategy(Integer id, String strategyType, Integer cloudId, String ip, String value, String op) {
        this.id = id;
        this.strategyType = strategyType;
        this.cloudId = cloudId;
        this.ip = ip;
        this.value = value;
        this.op = op;
    }

    @Override
    public String toString() {
        return "Strategy{" +
                "id=" + id +
                ", strategyType='" + strategyType + '\'' +
                ", cloudId=" + cloudId +
                ", ip='" + ip + '\'' +
                ", value='" + value + '\'' +
                ", op='" + op + '\'' +
                '}';
    }
}
