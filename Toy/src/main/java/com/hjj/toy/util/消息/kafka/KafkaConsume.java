package com.hjj.toy.util.消息.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Collections;
import java.util.Properties;

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
public class KafkaConsume {

    private  final KafkaConsumer<String, String> consumer;

    private KafkaConsume(){
        Properties props = new Properties();
        props.put("bootstrap.servers", "10.24.21.144:9092");
        props.put("group.id", "consumeGroup1");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        consumer = new KafkaConsumer<String, String>(props);
    }

    void consume(){
        consumer.subscribe(Collections.singleton("JAVA_TOPIC_only"));
        try {
            while (true) {
                ConsumerRecords<String, String> records = consumer.poll(100);
                for (ConsumerRecord<String, String> record : records)
                    System.out.printf("topic = %s, partition = %s, offset = %d, key = %s, value = %s", record.topic(),record.partition(),record.offset(), record.key(), record.value());
            }
        } finally {
            consumer.close();
        }

    }

    public  static  void main(String[] args){
        new KafkaConsume().consume();
    }
}
