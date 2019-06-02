package com.nefu.workmanage.repository;

import com.nefu.workmanage.entity.UserTask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserTaskRepository extends JpaRepository<UserTask,Integer> {
}
