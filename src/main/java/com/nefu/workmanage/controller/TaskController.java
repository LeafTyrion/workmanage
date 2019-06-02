package com.nefu.workmanage.controller;

import com.nefu.workmanage.service.TaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.*;

import org.springframework.web.bind.annotation.*;


import java.util.Map;


@Slf4j
@RestController
@RequestMapping("/api")
public class TaskController {
    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/tasks")
    public Map getTask(){
        return Map.of("tasks", taskService.taskList());
    }




}
