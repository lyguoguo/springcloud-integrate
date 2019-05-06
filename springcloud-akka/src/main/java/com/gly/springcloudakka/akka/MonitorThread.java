package com.gly.springcloudakka.akka;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import com.gly.springcloudakka.akka.bean.AkkaReq;
import com.gly.springcloudakka.akka.bean.AkkaResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author: create by ggaly
 * @version: v1.0
 * @description: com.gly.springcloudakka.akka
 * @date:2019/5/6
 **/
@Component
public class MonitorThread implements Runnable{
    @Autowired
    private ActorSystem actorSystem;
    @Autowired
    private SpringExtension springExtension;

    @Override
    public void run() {
        ActorRef masterRef = actorSystem.actorOf(springExtension.get(actorSystem).props("masterActor"),"masterActor");
        actorSystem.actorOf(springExtension.get(actorSystem).props("workerActor"),"workerActor").tell(new AkkaReq("hello"), masterRef);
    }
}
