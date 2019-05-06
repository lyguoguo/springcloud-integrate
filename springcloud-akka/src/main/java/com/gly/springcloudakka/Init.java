package com.gly.springcloudakka;

import com.gly.springcloudakka.akka.MonitorThread;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author: create by ggaly
 * @version: v1.0
 * @description: com.gly.springcloudakka
 * @date:2019/5/6
 **/
@Component
public class Init implements CommandLineRunner {

    @Autowired
    private MonitorThread monitorThread;

    @Override
    public void run(String... args) throws Exception {
        monitorThread.run();
    }
}
