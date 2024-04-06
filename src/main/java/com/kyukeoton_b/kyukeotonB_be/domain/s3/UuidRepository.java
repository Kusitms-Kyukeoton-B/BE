package com.kyukeoton_b.kyukeotonB_be.domain.s3;


import org.springframework.data.jpa.repository.JpaRepository;

public interface UuidRepository extends JpaRepository<Uuid, Long> {
    Uuid findByUuid(String uuid);
}