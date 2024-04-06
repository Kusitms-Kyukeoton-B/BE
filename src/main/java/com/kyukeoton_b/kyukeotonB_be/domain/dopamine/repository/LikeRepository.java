package com.kyukeoton_b.kyukeotonB_be.domain.dopamine.repository;

import com.kyukeoton_b.kyukeotonB_be.domain.dopamine.Like;
import com.kyukeoton_b.kyukeotonB_be.domain.dopamine.Post;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LikeRepository extends JpaRepository<Like, Long> {
    @Query("SELECT l.post FROM Like l ORDER BY l.count DESC")
    List<Post> findTop3ByOrderByCountDesc(Pageable pageable);
}

