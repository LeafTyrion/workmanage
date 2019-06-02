package com.nefu.workmanage;

import com.nefu.workmanage.entity.Task;
import com.nefu.workmanage.repository.TaskRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class JPQLTest {
    @Autowired
    private TaskRepository taskRepository;


    @Test
    public void init(){
        Task task=new Task("Lin");
        taskRepository.save(task);
    }
    @Test
    public void find(){
        List<Task> list=taskRepository.findAll();
        System.out.println(list);
    }

}
