package com.bigdata.common.bean;

public class TableProcessDim {

    // 来源表名
    private String sourceTable;

    // 目标表名
    private String sinkTable;

    // 输出字段
    private String sinkColumns;

    // 数据到 hbase 的列族
    private String sinkFamily;

    // sink到 hbase 的时候的主键字段
    private String sinkRowKey;

    // 配置表操作类型
    private String op;

    public String getSourceTable() {
        return sourceTable;
    }

    public void setSourceTable(String sourceTable) {
        this.sourceTable = sourceTable;
    }

    public String getSinkTable() {
        return sinkTable;
    }

    public void setSinkTable(String sinkTable) {
        this.sinkTable = sinkTable;
    }

    public String getSinkColumns() {
        return sinkColumns;
    }

    public void setSinkColumns(String sinkColumns) {
        this.sinkColumns = sinkColumns;
    }

    public String getSinkFamily() {
        return sinkFamily;
    }

    public void setSinkFamily(String sinkFamily) {
        this.sinkFamily = sinkFamily;
    }

    public String getSinkRowKey() {
        return sinkRowKey;
    }

    public void setSinkRowKey(String sinkRowKey) {
        this.sinkRowKey = sinkRowKey;
    }

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }

    public TableProcessDim() {
    }

    public TableProcessDim(String sourceTable, String sinkTable, String sinkColumns, String sinkFamily, String sinkRowKey, String op) {
        this.sourceTable = sourceTable;
        this.sinkTable = sinkTable;
        this.sinkColumns = sinkColumns;
        this.sinkFamily = sinkFamily;
        this.sinkRowKey = sinkRowKey;
        this.op = op;
    }

    @Override
    public String toString() {
        return "TableProcessDim{" +
                "sourceTable='" + sourceTable + '\'' +
                ", sinkTable='" + sinkTable + '\'' +
                ", sinkColumns='" + sinkColumns + '\'' +
                ", sinkFamily='" + sinkFamily + '\'' +
                ", sinkRowKey='" + sinkRowKey + '\'' +
                ", op='" + op + '\'' +
                '}';
    }
}
