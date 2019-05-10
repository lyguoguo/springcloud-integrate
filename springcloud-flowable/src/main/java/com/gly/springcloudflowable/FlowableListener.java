package com.gly.springcloudflowable;

import lombok.extern.slf4j.Slf4j;
import org.flowable.engine.delegate.TaskListener;
import org.flowable.task.service.delegate.DelegateTask;

/**
 * @author: create by ggaly
 * @version: v1.0
 * @description: com.gly.springcloudflowable
 *      流程监听
 * @date:2019/5/10
 **/
@Slf4j
public class FlowableListener implements TaskListener {
    @Override
    public void notify(DelegateTask delegateTask) {
        log.debug("监听流程：{}",delegateTask.getName());
    }
}
