package com.gly.springcloudakka.akka;

import akka.actor.ActorSystem;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: create by ggaly
 * @version: v1.0
 * @description: com.gly.springcloudakka
 * @date:2019/5/6
 **/
@Configuration
public class AkkaConfig {
    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    private SpringExtension springExtension;

    @Bean
    public ActorSystem actorSystem() {
        ActorSystem actorSystem = ActorSystem.create("ActorSystem");
        springExtension.get(actorSystem).initialize(applicationContext);
        return actorSystem;
    }

    @Bean
    public Config akkaConfiguration() {
        return ConfigFactory.load();
    }
}
