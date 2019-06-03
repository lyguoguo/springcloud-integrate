package com.gly.springcloudredlock.worker;

import com.gly.springcloudredlock.exception.UnableToAquireLockException;
import com.gly.springcloudredlock.utils.RedissonConnector;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author: create by ggaly
 * @version: v1.0
 * @description: com.gly.springcloudredlock.service.impl
 * @date:2019/6/3
 **/
@Component
public class RedisLocker implements DistributedLocker {
    private final static String LOCKER_PREFIX = "lock:";

    @Autowired
    RedissonConnector redissonConnector;

    @Override
    public Object lock(String resourceName, AquiredLockWorker worker, int lockTime) throws UnableToAquireLockException, Exception {
        RedissonClient redisson = redissonConnector.getClient();
        RLock lock = redisson.getLock(LOCKER_PREFIX + resourceName);
        // Wait for 100 seconds seconds and automatically unlock it after lockTime seconds
        boolean success = lock.tryLock(100, lockTime, TimeUnit.SECONDS);
        if (success) {
            try {
                return worker.invokeAfterLockAquire();
            } finally {
                lock.unlock();
            }
        }
        throw new UnableToAquireLockException();
    }

    @Override
    public Object lock(String resourceName, AquiredLockWorker worker) throws UnableToAquireLockException, Exception {
        return lock(resourceName, worker, 100);
    }

}
