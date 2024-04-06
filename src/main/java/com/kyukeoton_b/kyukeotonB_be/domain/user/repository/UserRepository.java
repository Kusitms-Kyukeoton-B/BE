package com.kyukeoton_b.kyukeotonB_be.domain.user.repository;

import com.kyukeoton_b.kyukeotonB_be.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
