package com.hjj.toy.util.消息.rabbitmq;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 通联数据机密
 * --------------------------------------------------------------------
 * 通联数据股份公司版权所有 © 2013-2018
 * <p>
 * 注意：本文所载所有信息均属于通联数据股份公司资产。本文所包含的知识和技术概念均属于
 * 通联数据产权，并可能由中国、美国和其他国家专利或申请中的专利所覆盖，并受商业秘密或
 * 版权法保护。
 * 除非事先获得通联数据股份公司书面许可，严禁传播文中信息或复制本材料。
 * <p>
 * DataYes CONFIDENTIAL
 * --------------------------------------------------------------------
 * Copyright © 2013-2016 DataYes, All Rights Reserved.
 * <p>
 * NOTICE: All information contained herein is the property of DataYes
 * Incorporated. The intellectual and technical concepts contained herein are
 * proprietary to DataYes Incorporated, and may be covered by China, U.S. and
 * Other Countries Patents, patents in process, and are protected by trade
 * secret or copyright law.
 * Dissemination of this information or reproduction of this material is
 * strictly forbidden unless prior written permission is obtained from DataYes.
 */
public class RabbitConsume {

    private final static String QUEUE_NAME = "hello";
    public static void main(String[] args) throws IOException, TimeoutException {

        ConnectionFactory cf = new ConnectionFactory();
        //rabbitmq监听IP
        cf.setHost("10.24.21.144");
        //rabbitmq默认监听端口，注意要记得开启端口
        cf.setPort(5672);

        //设置访问的用户
        cf.setUsername("guest");
        cf.setPassword("guest");
        //建立连接
        Connection conn = cf.newConnection();
        //创建消息通道
        Channel channel = conn.createChannel();

        //创建hello队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        System.out.println(" Waiting for msg....");
        //创建消费者，并接受消息
        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)
                    throws IOException {
                String msg = new String(body, "UTF-8");
                System.out.println("Received is = '" + msg + "'");
            }
        };
        channel.basicConsume(QUEUE_NAME, true, consumer);
    }
}
