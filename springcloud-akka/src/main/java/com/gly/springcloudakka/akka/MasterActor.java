package com.gly.springcloudakka.akka;

import akka.actor.UntypedActor;
import com.gly.springcloudakka.akka.bean.AkkaResp;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author: create by ggaly
 * @version: v1.0
 * @description: com.gly.springcloudakka
 * @date:2019/5/6
 **/
@Component("masterActor")
@Scope("prototype")
public class MasterActor extends UntypedActor {
    @Override
    public void onReceive(Object message) throws Exception {
        if (message instanceof AkkaResp) {
            System.out.println("get resp:"+((AkkaResp) message).getData());
        } else {
            unhandled(message);
        }
    }
}
