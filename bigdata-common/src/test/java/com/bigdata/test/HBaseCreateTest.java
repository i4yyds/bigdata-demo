package com.bigdata.test;

import com.bigdata.common.constant.Constant;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.*;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;

public class HBaseCreateTest {
    public static void main(String[] args) {
        Configuration config = HBaseConfiguration.create();
        config.set("hbase.zookeeper.quorum", Constant.LOCAL_HOST);
        config.set("hbase.zookeeper.property.clientPort", "2182");

        String namespace = "monitor";
        String tableName = "port_monitor-0-192.168.0.6-6666";
        String columnFamily = "cf";

        System.out.println("Trying to connect to HBase...");
        try (Connection connection = ConnectionFactory.createConnection(config)) {
            System.out.println("HBase connection established!");
            try (Admin admin = connection.getAdmin()) {
                System.out.println("Admin connection established!");

                // Check if the namespace exists, if not, create it
                NamespaceDescriptor namespaceDescriptor = NamespaceDescriptor.create(namespace).build();
                try {
                    admin.getNamespaceDescriptor(namespace);
                } catch (NamespaceNotFoundException e) {
                    System.out.println("Namespace does not exist. Creating namespace...");
                    admin.createNamespace(namespaceDescriptor);
                    System.out.println("Namespace created: " + namespace);
                }

                TableName table = TableName.valueOf(namespace, tableName);

                System.out.println("Checking if table exists...");
                boolean tableExists = admin.tableExists(table);
                System.out.println("Table exists: " + tableExists);

                if (!tableExists) {
                    System.out.println("Table does not exist. Creating table...");
                    TableDescriptor tableDescriptor = TableDescriptorBuilder.newBuilder(table)
                            .setColumnFamily(ColumnFamilyDescriptorBuilder.newBuilder(Bytes.toBytes(columnFamily)).build())
                            .build();
                    admin.createTable(tableDescriptor);
                    System.out.println("Table created: " + tableName);
                } else {
                    System.out.println("Table already exists: " + tableName);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
