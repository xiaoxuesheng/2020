package com.hjj.toy.util.distributedlock;

import redis.clients.jedis.Jedis;

import java.util.Collections;

/**
 * redis 分布式锁实现
 *
   1.互斥性。在任意时刻，只有一个客户端能持有锁。

   2.不会发生死锁。即使有一个客户端在持有锁的期间崩溃而没有主动解锁，也能保证后续其他客户端能加锁。

   3.具有容错性。只要大部分的Redis节点正常运行，客户端就可以加锁和解锁。

   4.解铃还须系铃人。加锁和解锁必须是同一个客户端，客户端自己不能把别人加的锁给解了。
 *
 *
 * 此方案在单节点redis下实现简单。但在多节点下会出现锁丢失
 * 1.客户端A在master节点拿到了锁。
 * 2.master节点在把A创建的key写入slave之前宕机了。slave变成了master节点
 * 3.B也得到了和A还持有的相同的锁（因为原来的slave里还没有A持有锁的信息）
 */
public class RedisLock1 {

    private static final String LOCK_SUCCESS = "OK";
    private static final String SET_IF_NOT_EXIST = "NX";
    private static final String SET_WITH_EXPIRE_TIME = "PX";

    /**
     * 尝试获取分布式锁
     * @param jedis Redis客户端
     * @param lockKey 锁
     * @param requestId 请求标识
     * @param expireTime 超期时间
     * @return 是否获取成功
     */

    public static boolean tryGetDistributedLock(Jedis jedis, String lockKey, String requestId, int expireTime) {


        //第一个为key，我们使用key来当锁，因为key是唯一的。
        //第二个为value，我们传的是requestId，很多童鞋可能不明白，有key作为锁不就够了吗，为什么还要用到value？原因就是我们在上面讲到可靠性时，分布式锁要满足第四个条件解铃还须系铃人，通过给value赋值为requestId，我们就知道这把锁是哪个请求加的了，在解锁的时候就可以有依据。requestId可以使用UUID.randomUUID().toString()方法生成。
        //第三个为nxxx，这个参数我们填的是NX，意思是SET IF NOT EXIST，即当key不存在时，我们进行set操作；若key已经存在，则不做任何操作；（需要查询key是否存在，有耗时）
        //第四个为expx，这个参数我们传的是PX，意思是我们要给这个key加一个过期的设置，具体时间由第五个参数决定。
        //第五个为time，与第四个参数相呼应，代表key的过期时间。
        String result = jedis.set(lockKey, requestId, SET_IF_NOT_EXIST, SET_WITH_EXPIRE_TIME, expireTime);

        if (LOCK_SUCCESS.equals(result)) {

            return true;
        }
        return false;
    }


    private static final Long RELEASE_SUCCESS = 1L;

    /**
     * 释放分布式锁
     * @param jedis Redis客户端
     * @param lockKey 锁
     * @param requestId 请求标识
     * @return 是否释放成功
     */
    public static boolean releaseDistributedLock(Jedis jedis, String lockKey, String requestId) {

        //简单来说，就是在eval命令执行Lua代码的时候，Lua代码将被当成一个命令去执行，并且直到eval命令执行完成，Redis才会执行其他命令。
        //原子性
        String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";

        Object result = jedis.eval(script, Collections.singletonList(lockKey), Collections.singletonList(requestId));

        if (RELEASE_SUCCESS.equals(result)) {

            return true;

        }
        return false;

    }
}
