package com.nefu.workmanage.service;

import com.nefu.workmanage.entity.Task;
import com.nefu.workmanage.entity.User;
import com.nefu.workmanage.entity.UserTask;
import com.nefu.workmanage.repository.TaskRepository;
import com.nefu.workmanage.repository.UserTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@Transactional
public class UserTaskService {

    @Autowired
    private UserTaskRepository userTaskRepository;
    @Autowired
    private TaskRepository taskRepository;

    //    新建/修改用户任务
    public Map addUserTask(int taskId, List<User> userList) {
        UserTask userTask = new UserTask();
        for (User user : userList) {
            userTask = new UserTask();
            userTask.setUser(user);
            userTask.setTask(taskRepository.find(taskId));
            userTaskRepository.save(userTask);
        }
        return Map.of("userTasks", userTask);
    }

    //    显示所有用户任务
    public List<UserTask> userTaskList() {
        return userTaskRepository.findAll();
    }

    //    删除指定用户任务
    public void deleteUserTask(UserTask userTask) {
        userTaskRepository.delete(userTask);
    }

    //    用户回复任务消息
    public void reply(UserTask userTask) {
        int id = userTask.getId();
        Task task = userTaskRepository.find(id).getTask();
        if (task.getEndTime().isBefore(LocalDateTime.now())) {
            userTask.setStatus(2);
        } else {
            userTask.setStatus(1);
        }
        userTaskRepository.reply(userTask.getReply(), userTask.getStatus(),LocalDateTime.now(),userTask.getId());
    }

}
