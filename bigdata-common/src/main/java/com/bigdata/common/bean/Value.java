package com.bigdata.common.bean;

public class Value {

    private String metric; // 指标:维度，weblogic_status:server_tag

    private Object value; // 值

    private String help; // 帮助信息

    private String tags; // 维度值拼接，domain_name|server_name

    private String tagsName; // 维度名拼接，base_domain|test_system

    public String getMetric() {
        return metric;
    }

    public void setMetric(String metric) {
        this.metric = metric;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public String getHelp() {
        return help;
    }

    public void setHelp(String help) {
        this.help = help;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getTagsName() {
        return tagsName;
    }

    public void setTagsName(String tagsName) {
        this.tagsName = tagsName;
    }

    public Value() {
    }

    public Value(String metric, Object value, String help, String tags, String tagsName) {
        this.metric = metric;
        this.value = value;
        this.help = help;
        this.tags = tags;
        this.tagsName = tagsName;
    }

    @Override
    public String toString() {
        return "Value{" +
                "metric='" + metric + '\'' +
                ", value=" + value +
                ", help='" + help + '\'' +
                ", tags='" + tags + '\'' +
                ", tagsName='" + tagsName + '\'' +
                '}';
    }
}
