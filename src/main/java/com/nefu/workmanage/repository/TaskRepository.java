package com.nefu.workmanage.repository;

import com.nefu.workmanage.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task,Integer>{
}
