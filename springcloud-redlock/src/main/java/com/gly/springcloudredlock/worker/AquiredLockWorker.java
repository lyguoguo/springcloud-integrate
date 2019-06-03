package com.gly.springcloudredlock.worker;

/**
 * @author: create by ggaly
 * @version: v1.0
 * @description: com.gly.springcloudredlock.service
 *          获取锁后需要处理的逻辑
 * @date:2019/6/3
 **/
public interface AquiredLockWorker<T> {
    T invokeAfterLockAquire() throws Exception;
}
