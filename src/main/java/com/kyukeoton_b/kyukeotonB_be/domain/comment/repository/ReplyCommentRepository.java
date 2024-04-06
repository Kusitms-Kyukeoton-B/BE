package com.kyukeoton_b.kyukeotonB_be.domain.comment.repository;

import com.kyukeoton_b.kyukeotonB_be.domain.comment.ReplyComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReplyCommentRepository extends JpaRepository<ReplyComment, Long> {
    List<ReplyComment> findByCommentId(Long commentId);

    @Query("SELECT rc FROM ReplyComment rc JOIN rc.comment c JOIN c.post p WHERE c.id = :commentId AND p.postType = 'TALK'")
    List<ReplyComment> findReplyCommentsForComment(Long commentId);

}
