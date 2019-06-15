package com.nefu.workmanage.repository;

import com.nefu.workmanage.entity.UserTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

public interface UserTaskRepository extends JpaRepository<UserTask,Integer> {
    //    按照id查询任务
    @Query("select ut from UserTask ut where ut.id=:id")
    UserTask find(@Param("id") int id);

    @Transactional
    @Modifying
    @Query("update UserTask ut set ut.reply=:reply,ut.status=:status,ut.finishTime=:finishTime where ut.id=:id")
    void reply(@Param("reply") String reply, @Param("status") int status, @Param("finishTime") LocalDateTime finishTime, @Param("id") int id);
}
