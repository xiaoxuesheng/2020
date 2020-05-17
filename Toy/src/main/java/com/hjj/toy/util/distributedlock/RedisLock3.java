package com.hjj.toy.util.distributedlock;

/**
 * 采用redlock的另外写法
 */
public class RedisLock3 {
}

/**
 * Created by fangzhipeng on 2017/4/5.
 * 获取锁后需要处理的逻辑
 */
//public interface AquiredLockWorker<T> {
//    T invokeAfterLockAquire() throws Exception;
//}

/**
 * Created by fangzhipeng on 2017/4/5.
 * 获取锁管理类
 */
//public interface DistributedLocker {
//
//    /**
//     * 获取锁
//     *
//     * @param resourceName 锁的名称
//     * @param worker       获取锁后的处理类
//     * @param <T>
//     * @return 处理完具体的业务逻辑要返回的数据
//     * @throws Exception
//     */
//    <T> T lock(String resourceName, AquiredLockWorker<T> worker) throws UnableToAquireLockException, Exception;
//
//    <T> T lock(String resourceName, AquiredLockWorker<T> worker, int lockTime) throws UnableToAquireLockException, Exception;
//}

/**
 * Created by fangzhipeng on 2017/4/5.
 * 异常类
 */
//public class UnableToAquireLockException extends RuntimeException {
//
//    public UnableToAquireLockException() {
//    }
//
//    public UnableToAquireLockException(String message) {
//        super(message);
//    }
//
//    public UnableToAquireLockException(String message, Throwable cause) {
//        super(message, cause);
//    }
//}

/**
 * Created by fangzhipeng on 2017/4/5.
 * 获取RedissonClient连接类
 */
//@Component
//public class RedissonConnector {
//    RedissonClient redisson;
//    @PostConstruct
//    public void init(){
//        redisson = Redisson.create();
//    }
//
//    public RedissonClient getClient(){
//        return redisson;
//    }
//}
/**
 * Created by fangzhipeng on 2017/4/5.
 */
//@Component
//public class RedisLocker  implements DistributedLocker{
//
//    private final static String LOCKER_PREFIX = "lock:";
//
//    @Autowired
//    RedissonConnector redissonConnector;
//    @Override
//    public <T> T lock(String resourceName, AquiredLockWorker<T> worker) throws InterruptedException, UnableToAquireLockException, Exception {
//
//        return lock(resourceName, worker, 100);
//    }
//
//    @Override
//    public <T> T lock(String resourceName, AquiredLockWorker<T> worker, int lockTime) throws UnableToAquireLockException, Exception {
//        RedissonClient redisson= redissonConnector.getClient();
//        RLock lock = redisson.getLock(LOCKER_PREFIX + resourceName);
//        // Wait for 100 seconds seconds and automatically unlock it after lockTime seconds
//        boolean success = lock.tryLock(100, lockTime, TimeUnit.SECONDS);
//        if (success) {
//            try {
//                return worker.invokeAfterLockAquire();
//            } finally {
//                lock.unlock();
//            }
//        }
//        throw new UnableToAquireLockException();
//    }
//}
