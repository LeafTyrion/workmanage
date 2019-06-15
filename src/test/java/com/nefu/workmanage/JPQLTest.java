package com.nefu.workmanage;

import com.nefu.workmanage.entity.Task;
import com.nefu.workmanage.repository.TaskRepository;
import com.nefu.workmanage.service.TaskService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class JPQLTest {
    @Autowired
    private TaskService taskService;

    @Test
    public void updateTask(){
        Task task=new Task();
        task.setId(4);
        task.setName("fuck");
        task.setDetail("fuckAll");
        task.setStartTime(LocalDateTime.now());
        task.setEndTime(LocalDateTime.now());
        taskService.addTask(task);
    }
    @Test
    public void addTask(){
        Task task=new Task();
        task.setId(5);
        task.setName("fuck");
        task.setDetail("fuckyou");
        task.setStartTime(LocalDateTime.now());
        task.setEndTime(LocalDateTime.now());
        taskService.addTask(task);
    }



}
