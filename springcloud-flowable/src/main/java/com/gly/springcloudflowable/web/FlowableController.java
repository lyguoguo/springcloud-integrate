package com.gly.springcloudflowable.web;

import com.gly.springcloudflowable.service.FlowableService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.task.api.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author: create by ggaly
 * @version: v1.0
 * @description: com.gly.springcloudflowable
 * @date:2019/5/10
 **/
@Slf4j
@RestController
@RequestMapping("/flowable")
@Api(tags = "Flowable流程控制器",value = "流程引擎接口入口")
public class FlowableController {

    @Autowired
    private FlowableService flowableService;

    /**
     * 获取用户所属流程列表
     */
    @ApiOperation(tags = "Flowable流程控制器",value = "获取用户所属流程列表")
    @PostMapping(value = "/processList")
    public List<Task> getProcessList(@RequestParam("userId") String userId) {
       return flowableService.getprocessList(userId);
    }


    /**
     * 部署流程
     */
    @ApiOperation(tags = "Flowable流程控制器",value = "部署流程")
    @PostMapping(value = "deployProcess")
    public void deployProcess(@RequestParam("diagramName") String diagramName) throws Exception {
        flowableService.deployProcess(diagramName);
    }

    /**
     * 启动流程
     */
    @ApiOperation(tags = "Flowable流程控制器",value = "启动流程")
    @PostMapping(value = "startProcess")
    public String startProcess(@RequestParam("userId1") String userId1,@RequestParam("userId2") String userId2,@RequestParam("userIds") String userId3) {
        return flowableService.startProcess(userId1,userId2,userId3);
    }


    /**
     * 提交流程节点
     */
    @ApiOperation(tags = "Flowable流程控制器",value = "提交流程节点")
    @PostMapping(value = "commitTask")
    public String commitTask(@RequestParam("taskId") String taskId,@RequestParam("commit") boolean commit) {
        return flowableService.commitTask(taskId,commit);
    }


    /**
     * 生成流程图
     *
     * @param processId 任务ID
     */
    @GetMapping(value = "processDiagram")
    public void genProcessDiagram(HttpServletResponse httpServletResponse,String processId) throws Exception {
        flowableService.genProcessDiagram(httpServletResponse,processId);
    }

}
