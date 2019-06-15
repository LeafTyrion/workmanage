package com.nefu.workmanage.controller;

import com.nefu.workmanage.entity.Task;
import com.nefu.workmanage.entity.User;
import com.nefu.workmanage.entity.UserTask;
import com.nefu.workmanage.service.TaskService;
import com.nefu.workmanage.service.UserTaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api")
public class UserTaskController {
    @Autowired
    private UserTaskService userTaskService;

    @GetMapping("/userTask")
    public Map getUserTask() {
        List<UserTask> userTaskList = userTaskService.userTaskList();
        return Map.of("userTask", userTaskList);
    }

    //    新建/更新用户任务信息
    @PostMapping("/manager/addUserTask/{taskId}")
    public Map updateUserTask(@PathVariable int taskId, @RequestBody List<User> userList) {
        return userTaskService.addUserTask(taskId, userList);
    }

    //    回复任务
    @PostMapping("/manager/reply")
    public Map replayTask(@RequestBody UserTask userTask) {
        userTaskService.reply(userTask);
        return Map.of("userTask", userTask);

    }


}
