package com.kyukeoton_b.kyukeotonB_be.domain.comment.repository;

import com.kyukeoton_b.kyukeotonB_be.domain.comment.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPostId(Long postId);


    /**
     * 12. 특정 도친토크에 대한 댓글 조회
     */
    @Query("SELECT c FROM Comment c JOIN c.post p WHERE p.postType = 'TALK' AND p.id = :postId")
    List<Comment> findByPostIdOnly(Long postId);
}
