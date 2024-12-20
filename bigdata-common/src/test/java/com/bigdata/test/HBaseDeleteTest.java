package com.bigdata.test;

import com.bigdata.common.constant.Constant;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;

public class HBaseDeleteTest {
    public static void main(String[] args) {
        Configuration config = HBaseConfiguration.create();
        config.set("hbase.zookeeper.quorum", Constant.LOCAL_HOST);
        config.set("hbase.zookeeper.property.clientPort", "2182");

        String namespace = "monitor"; // 命名空间
        String tableName = "port_monitor-0-192.168.0.2-22"; // 要删除的表名

        try (Connection connection = ConnectionFactory.createConnection(config);
             Admin admin = connection.getAdmin()) {

            System.out.println("HBase connection established!");

            // 构建完整的表名
            TableName table = TableName.valueOf(namespace, tableName);

            // 检查表是否存在
            if (admin.tableExists(table)) {
                System.out.println("Table found: " + table.getNameAsString());

                // 禁用表
                if (!admin.isTableDisabled(table)) {
                    System.out.println("Disabling table: " + table.getNameAsString());
                    admin.disableTable(table);
                }

                // 删除表
                System.out.println("Deleting table: " + table.getNameAsString());
                admin.deleteTable(table);
                System.out.println("Table deleted successfully!");
            } else {
                System.out.println("Table does not exist: " + table.getNameAsString());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
