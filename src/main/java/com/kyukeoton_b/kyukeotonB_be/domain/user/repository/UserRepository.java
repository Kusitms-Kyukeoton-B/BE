package com.kyukeoton_b.kyukeotonB_be.domain.user.repository;

import com.kyukeoton_b.kyukeotonB_be.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
//    Optional<User> findUserByUuid(String uuid);
//    Optional<User> findById(String id);
}
