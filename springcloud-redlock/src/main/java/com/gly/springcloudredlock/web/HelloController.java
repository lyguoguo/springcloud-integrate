package com.gly.springcloudredlock.web;

import com.gly.springcloudredlock.bean.Lock;
import com.gly.springcloudredlock.handle.DistributedLockHandler;
import com.gly.springcloudredlock.worker.AquiredLockWorker;
import com.gly.springcloudredlock.worker.DistributedLocker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: create by ggaly
 * @version: v1.0
 * @description: com.gly.springcloudredlock.web
 * @date:2019/6/3
 **/
@RestController
public class HelloController {
    @Autowired
    private DistributedLocker distributedLocker;

    @RequestMapping("index")
    public String index()throws Exception{
        distributedLocker.lock("test",new AquiredLockWorker<Object>() {
            @Override
            public Object invokeAfterLockAquire() {
                try {
                    System.out.println("执行方法！");
                    Thread.sleep(5000);
                }catch (Exception e){
                    e.printStackTrace();
                }
                return null;
            }

        });
        return "hello world!";
    }
}
