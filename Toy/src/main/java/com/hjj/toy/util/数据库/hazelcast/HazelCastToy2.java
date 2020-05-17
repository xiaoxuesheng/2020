package com.hjj.toy.util.数据库.hazelcast;


import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

import java.util.Map;
import java.util.Queue;

/**
 * doc address is https://hazelcast.org/mastering-hazelcast/#network-configuration
 */
public class HazelCastToy2 {

    public static void main(String[] args){
        //创建一个 hazelcastInstance实例
        HazelcastInstance instance = Hazelcast.newHazelcastInstance();
        Map<Integer, String> clusterMap = instance.getMap("MyMap");
        Queue<String> clusterQueue = instance.getQueue("MyQueue");

        System.out.println("Map Value:" + clusterMap.get(1));
        System.out.println("Queue Size :" + clusterQueue.size());
        System.out.println("Queue Value 1:" + clusterQueue.poll());
        System.out.println("Queue Value 2:" + clusterQueue.poll());
        System.out.println("Queue Size :" + clusterQueue.size());
    }
}
