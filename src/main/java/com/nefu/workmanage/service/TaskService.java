package com.nefu.workmanage.service;

import com.nefu.workmanage.entity.Task;
import com.nefu.workmanage.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
//    查找全部任务
    public List<Task> taskList(){
        return taskRepository.findAll();
    }
}
