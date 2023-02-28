package com.study.app.repository;

import com.study.app.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
    boolean existsByUsername(String username);

    boolean existsByNickname(String nickname);
}
