package com.nefu.workmanage.repository;

import com.nefu.workmanage.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserReopstiroy extends JpaRepository<User,Integer> {
}
