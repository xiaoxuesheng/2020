package com.hjj.toy.util.binlog;

import com.github.shyiko.mysql.binlog.BinaryLogClient;
import com.github.shyiko.mysql.binlog.event.*;

import java.io.IOException;

/**
 * https://github.com/shyiko/mysql-binlog-connector-java
 *
 * 需要开启binlog
 * windows my.ini   log-bin = my-bin server-id = xxx
 * linux my.cnf log-bin=my-bin server-id = xxx
 *
 */

public class BinLogToy {

    public static void main(String[] args) throws IOException {
        BinaryLogClient client = new BinaryLogClient("10.24.21.110",3306,"monitor","njadmin","njadmin@123");
        client.registerEventListener(new BinaryLogClient.EventListener(){
            @Override
            public void onEvent(Event event) {
                EventData data = event.getData();
                if(data instanceof QueryEventData){
                    System.out.println(((QueryEventData)data).getSql());
                } else if(data instanceof TableMapEventData){
                    System.out.println("收到数据库DDL操作>>"+((TableMapEventData)data).getTable());
                } else if(data instanceof UpdateRowsEventData){
                    System.out.println("收到数据库DML操作[update]>>"+data.toString());
                } else if(data instanceof WriteRowsEventData){
                    System.out.println("收到数据库DML操作[insert]>>"+data.toString());
                } else if(data instanceof DeleteRowsEventData){
                    System.out.println("收到数据库DML操作[delete]>>"+data.toString());
                }
            }
        });
        client.connect();
    }
}
