package com.hjj.toy.util.java8.concurrent;

import java.util.concurrent.atomic.AtomicLong;

public class ConcurrentExDemo {

    public static void main(String[] args){

        //原子类并发增强
        AtomicLong largest = new AtomicLong();
        //更新值
        //largest.updateAndGet(x->Math.max(x,observed));或者accumulateAndGet(observed,Math:max)
        //atomic采用乐观锁，大量线程访问时，需要太多重试。

        //J8提供LongAdder和LongAccumulator来解决问题

        //ConcurrentHashMap改进

    }
}
