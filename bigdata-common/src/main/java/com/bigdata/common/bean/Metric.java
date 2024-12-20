package com.bigdata.common.bean;


import java.util.List;

public class Metric {

    private String id; // uuid.NewV4()

    private Integer cloudId; // 网络区域

    private String ip; // ip地址

    private Long tms; // time.Now().Unix()

    private String time; // time.Now().Format("2001-10-01 19:00:00")

    private List<Value> value;

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public Long getTms() {
        return tms;
    }

    public void setTms(Long tms) {
        this.tms = tms;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public List<Value> getValue() {
        return value;
    }

    public void setValue(List<Value> value) {
        this.value = value;
    }

    public Metric() {
    }

    public Metric(String id, Integer cloudId, String ip, Long tms, String time, List<Value> value) {
        this.id = id;
        this.cloudId = cloudId;
        this.ip = ip;
        this.tms = tms;
        this.time = time;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Metric{" +
                "id='" + id + '\'' +
                ", cloudId=" + cloudId +
                ", ip='" + ip + '\'' +
                ", tms=" + tms +
                ", time='" + time + '\'' +
                ", value=" + value +
                '}';
    }
}
