package com.gly.springcloudflowable.service;

import org.flowable.task.api.Task;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author: create by ggaly
 * @version: v1.0
 * @description: com.gly.springcloudflowable.service
 * @date:2019/5/10
 **/
public interface FlowableService {
    void genProcessDiagram(HttpServletResponse httpServletResponse, String processId);

    void deployProcess(String diagramName);

    String startProcess(String userId1, String userId2, String userId3);

    List<Task> getprocessList(String userId);

    String commitTask(String taskId,boolean commit);
}
