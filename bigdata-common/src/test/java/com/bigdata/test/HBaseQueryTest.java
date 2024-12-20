package com.bigdata.test;

import com.bigdata.common.constant.Constant;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;

public class HBaseQueryTest {
    public static void main(String[] args) {
        Configuration config = HBaseConfiguration.create();
        config.set("hbase.zookeeper.quorum", Constant.LOCAL_HOST);
        config.set("hbase.zookeeper.property.clientPort", "2182");

        String namespace = "monitor"; // 指定命名空间

        try (Connection connection = ConnectionFactory.createConnection(config);
             Admin admin = connection.getAdmin()) {

            System.out.println("HBase connection established!");

            // 列出所有表
            System.out.println("Listing tables in namespace: " + namespace);
            TableName[] tableNames = admin.listTableNamesByNamespace(namespace); // 仅列出指定命名空间的表
            if (tableNames.length == 0) {
                System.out.println("No tables found in namespace: " + namespace);
            } else {
                for (TableName tableName : tableNames) {
                    System.out.println("Table: " + tableName.getNameAsString());
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
