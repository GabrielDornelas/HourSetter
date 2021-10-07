package com.zallpy.hoursetter.repository;

import com.zallpy.hoursetter.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
