package com.gly.springcloudnetty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.net.InetSocketAddress;

/**
 * @author: create by ggaly
 * @version: v1.0
 * @description: com.gly.springcloudnetty
 * @date:2019/5/6
 **/
@Component
@ChannelHandler.Sharable
public class Init {

    @Autowired
    @Qualifier("serverBootstrap")
    private ServerBootstrap serverBootstrap;

    @Autowired
    @Qualifier("tcpSocketAddress")
    private InetSocketAddress tcpPort;

    private ChannelFuture serverChannelFuture;

    @PostConstruct
    public void init(){
        try {
            serverChannelFuture =  serverBootstrap.bind(tcpPort).sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @PreDestroy
    public void stop() throws Exception {
        serverChannelFuture.channel().closeFuture().sync();
    }
}
