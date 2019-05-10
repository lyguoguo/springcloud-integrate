package com.gly.springcloudflowable.service.impl;

import com.gly.springcloudflowable.service.FlowableService;
import org.flowable.bpmn.model.BpmnModel;
import org.flowable.engine.*;
import org.flowable.engine.runtime.Execution;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.image.ProcessDiagramGenerator;
import org.flowable.task.api.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipInputStream;

/**
 * @author: create by ggaly
 * @version: v1.0
 * @description: com.gly.springcloudflowable.service.impl
 * @date:2019/5/10
 **/
@Service
public class FlowableServiceImpl implements FlowableService {
    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private TaskService taskService;
    @Autowired
    private RepositoryService repositoryService;
    @Autowired
    private ProcessEngine processEngine;

    /**
     * 绘制流程图
     * @param httpServletResponse
     * @param processId
     */
    @Override
    public void genProcessDiagram(HttpServletResponse httpServletResponse, String processId) {
        ProcessInstance pi = runtimeService.createProcessInstanceQuery().processInstanceId(processId).singleResult();

        //流程走完的不显示图
        if (pi == null) {
            return;
        }
        Task task = taskService.createTaskQuery().processInstanceId(pi.getId()).singleResult();
        //使用流程实例ID，查询正在执行的执行对象表，返回流程实例对象
        String InstanceId = task.getProcessInstanceId();
        List<Execution> executions = runtimeService
                .createExecutionQuery()
                .processInstanceId(InstanceId)
                .list();

        //得到正在执行的Activity的Id
        List<String> activityIds = new ArrayList<>();
        List<String> flows = new ArrayList<>();
        for (Execution exe : executions) {
            List<String> ids = runtimeService.getActiveActivityIds(exe.getId());
            activityIds.addAll(ids);
        }

        //获取流程图
        BpmnModel bpmnModel = repositoryService.getBpmnModel(pi.getProcessDefinitionId());
        ProcessEngineConfiguration engconf = processEngine.getProcessEngineConfiguration();
        ProcessDiagramGenerator diagramGenerator = engconf.getProcessDiagramGenerator();
        InputStream in = diagramGenerator.generateDiagram(bpmnModel,
                "png",
                activityIds,
                flows,
                engconf.getActivityFontName(),
                engconf.getLabelFontName(),
                engconf.getAnnotationFontName(),
                engconf.getClassLoader(),
                1.0,true);
        OutputStream out = null;
        byte[] buf = new byte[1024];
        int legth = 0;
        try {
            out = httpServletResponse.getOutputStream();
            while ((legth = in.read(buf)) != -1) {
                out.write(buf, 0, legth);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 部署流程
     * @param diagramName
     */
    @Override
    public void deployProcess(String diagramName) {
        InputStream inputStream = FlowableServiceImpl.class.getClassLoader()
                .getResourceAsStream("processes/"+diagramName+".zip");
        ZipInputStream zipInputStream = new ZipInputStream(inputStream);
        repositoryService.createDeployment().addZipInputStream(zipInputStream).deploy();
    }

    /**
     * 启动流程
     *
     * @param userId1
     * @param userId2
     * @return
     */
    @Override
    public String startProcess(String userId1, String userId2, String userId3) {
        Map<String, Object> map = new HashMap<>();
        map.put("taskUser1", userId1);
        map.put("taskUser2", userId2);
        map.put("taskUser3", userId3);
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("flowable-test", map);
        if(null == processInstance){
            return "流程提交失败";
        }
        return "提交成功.流程Id为：" + processInstance.getId();
    }

    @Override
    public List<Task> getprocessList(String userId) {
       return taskService.createTaskQuery().taskAssignee(userId).orderByTaskCreateTime().desc().list();
    }

    @Override
    public String commitTask(String taskId,boolean commit) {
        Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
        if (task == null) {
            throw new RuntimeException("流程不存在");
        }
        //通过审核
        HashMap<String, Object> map = new HashMap<>();
        map.put("commit", commit);
        taskService.complete(taskId, map);
        return "processed ok!";
    }
}
