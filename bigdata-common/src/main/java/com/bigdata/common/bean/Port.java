package com.bigdata.common.bean;

public class Port {

    private Integer port;

    private Integer count;

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Port() {
    }

    public Port(Integer count, Integer port) {
        this.count = count;
        this.port = port;
    }

    @Override
    public String toString() {
        return "Port{" +
                "port=" + port +
                ", count=" + count +
                '}';
    }
}
