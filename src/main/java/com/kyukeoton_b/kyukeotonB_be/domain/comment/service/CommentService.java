package com.kyukeoton_b.kyukeotonB_be.domain.comment.service;

import com.kyukeoton_b.kyukeotonB_be.domain.comment.Comment;
import com.kyukeoton_b.kyukeotonB_be.domain.comment.ReplyComment;
import com.kyukeoton_b.kyukeotonB_be.domain.comment.dto.*;
import com.kyukeoton_b.kyukeotonB_be.domain.comment.exception.CommentException;
import com.kyukeoton_b.kyukeotonB_be.domain.comment.repository.CommentRepository;
import com.kyukeoton_b.kyukeotonB_be.domain.comment.repository.ReplyCommentRepository;
import com.kyukeoton_b.kyukeotonB_be.domain.dopamine.Post;
import com.kyukeoton_b.kyukeotonB_be.domain.dopamine.exception.PostException;
import com.kyukeoton_b.kyukeotonB_be.domain.dopamine.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static com.kyukeoton_b.kyukeotonB_be.global.status.ErrorStatus.COMMENT_NOT_FOUND;
import static com.kyukeoton_b.kyukeotonB_be.global.status.ErrorStatus.POST_NOT_FOUND;

@Service
@RequiredArgsConstructor
@Transactional
public class CommentService {
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;
    private final ReplyCommentRepository replyCommentRepository;

    public CommentListResponse findPostComment(Long postId) {
        List<Comment> commentByPostId = commentRepository.findByPostId(postId);
        return CommentListResponse.of(commentByPostId);
    }

    public ReplyCommentListResponse findPostReplyComment(Long postId,Long commentId) {
//        List<Comment> byPostId = commentRepository.findByPostId(postId);
        List<ReplyComment> byCommentId = replyCommentRepository.findByCommentId(commentId);
        return ReplyCommentListResponse.of(byCommentId);
    }


    public void createComment(Long postId, CommentRequest commentRequest) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new PostException(POST_NOT_FOUND));
        Comment comment = CommentRequest.toEntity(commentRequest);
        comment.setPost(post);
        commentRepository.save(comment);
    }

    public void createReplyComment(Long commentId, ReplyCommentRequest replyCommentRequest) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(() -> new CommentException(COMMENT_NOT_FOUND));
        ReplyComment replyComment = ReplyCommentRequest.toEntity(replyCommentRequest);
        replyComment.setComment(comment);
        replyCommentRepository.save(replyComment);
    }

    /**
     * 특정 도친 토크에 대한 댓글 조회
     * @param postId
     * @return
     */
    public List<CommentTalkResponse> getCommentsForPost(Long postId) {
        List<Comment> comments = commentRepository.findByPostIdOnly(postId);

        List<CommentTalkResponse> commentResponses = new ArrayList<>();
        for (Comment comment : comments) {
            commentResponses.add(mapToCommentResponse(comment));
        }
        return commentResponses;
    }
    private CommentTalkResponse mapToCommentResponse(Comment comment) {
        return CommentTalkResponse.builder()
                .id(comment.getId())
                .content(comment.getContent())
                .chooseSide(comment.getChooseSide())
                .build();
    }
}
