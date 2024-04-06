package com.kyukeoton_b.kyukeotonB_be.domain.dopamine.repository;

import com.kyukeoton_b.kyukeotonB_be.domain.dopamine.Post;
import com.kyukeoton_b.kyukeotonB_be.domain.dopamine.PostType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long>{
    List<Post> findByPostTypeNot(PostType postType);

    /**
     * 1. 도파밍 토크 전체 조회
     */
    List<Post> findByPostType(PostType postType);
    Post findByIdAndPostType(Long id, PostType postType);

}
