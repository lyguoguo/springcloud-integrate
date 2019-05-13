package com.gly.springcloudflowable;

import org.flowable.engine.RepositoryService;
import org.flowable.engine.repository.Deployment;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SpringcloudFlowableApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudFlowableApplication.class, args);
    }

/*    @Bean
    public InitializingBean initializingBean(RepositoryService repositoryService) {
        return () -> {
            List<Deployment> list = repositoryService.createDeploymentQuery().list();
            System.err.println("Deployment size: " + list.size());// where '1' is expected
        };
    }*/

}
