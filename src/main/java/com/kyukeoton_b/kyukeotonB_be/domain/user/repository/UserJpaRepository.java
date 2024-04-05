package com.kyukeoton_b.kyukeotonB_be.domain.user.repository;

import com.kyukeoton_b.kyukeotonB_be.domain.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserJpaRepository extends JpaRepository<UserEntity, Long> {

}
