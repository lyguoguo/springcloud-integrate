package com.gly.springcloudakka.akka;

import akka.actor.ActorSystem;
import akka.actor.UntypedActor;
import com.gly.springcloudakka.akka.bean.AkkaReq;
import com.gly.springcloudakka.akka.bean.AkkaResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author: create by ggaly
 * @version: v1.0
 * @description: com.gly.springcloudakka
 * @date:2019/5/6
 **/
@Component("workerActor")
@Scope("prototype")
public class WorkerActor extends UntypedActor {
    @Autowired
    ActorSystem actorSystem;

    @Override
    public void onReceive(Object message) throws Exception {
        if (message instanceof AkkaReq) {
            System.out.println("receive req:"+((AkkaReq) message).getData());
            Thread.sleep(1000);
            getSender().tell(new AkkaResp(((AkkaReq) message).getData()), getSelf());
            //getContext().stop(getSelf());
        } else {
            unhandled(message);
        }
    }
}
