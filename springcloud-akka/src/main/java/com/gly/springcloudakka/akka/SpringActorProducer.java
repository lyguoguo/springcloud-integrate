package com.gly.springcloudakka.akka;

import akka.actor.Actor;
import akka.actor.IndirectActorProducer;
import org.springframework.context.ApplicationContext;

/**
 * @author: create by ggaly
 * @version: v1.0
 * @description: com.gly.springcloudakka
 * @date:2019/5/6
 **/
public class SpringActorProducer implements IndirectActorProducer {
    final private ApplicationContext applicationContext;
    final private String actorBeanName;

    public SpringActorProducer(ApplicationContext applicationContext, String actorBeanName) {
        this.applicationContext = applicationContext;
        this.actorBeanName = actorBeanName;
    }

    @Override
    public Actor produce() {
        return (Actor) applicationContext.getBean(actorBeanName);
    }

    @Override
    public Class<? extends Actor> actorClass() {
        return (Class<? extends Actor>) applicationContext.getType(actorBeanName);
    }
}
