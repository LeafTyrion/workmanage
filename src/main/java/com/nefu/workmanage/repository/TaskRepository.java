package com.nefu.workmanage.repository;

import com.nefu.workmanage.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

    //    按照id查询任务
    @Query("select t from Task t where t.id=:id")
    Task find(@Param("id") int id);

}
