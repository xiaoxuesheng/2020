package com.hjj.toy.util.数据库.hazelcast;


import com.hazelcast.core.*;


/**
 * doc address is https://hazelcast.org/mastering-hazelcast/#network-configuration
 */
public class HazelCastToy4 {

    public static void main(String[] args) throws Exception{
        HazelcastInstance hz = Hazelcast.newHazelcastInstance();
        IdGenerator idGenerator = hz.getIdGenerator("id");
        idGenerator.init(0);
        for (int k = 0; k < 1000; k++){
            Thread.sleep(1000);
            System.out.printf("Id : %s\n", idGenerator.newId());
        }
    }
}


