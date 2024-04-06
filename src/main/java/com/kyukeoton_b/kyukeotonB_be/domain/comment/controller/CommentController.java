package com.kyukeoton_b.kyukeotonB_be.domain.comment.controller;

import com.kyukeoton_b.kyukeotonB_be.domain.comment.dto.*;
import com.kyukeoton_b.kyukeotonB_be.domain.comment.service.CommentService;
import com.kyukeoton_b.kyukeotonB_be.domain.comment.service.ReplyCommentService;
import com.kyukeoton_b.kyukeotonB_be.global.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;
    private final ReplyCommentService replyCommentService;

    @GetMapping(value = "/post/file/{postId}/comments")
    public ApiResponse<CommentListResponse> findCommentOfDochinZZal(@PathVariable Long postId) {
        CommentListResponse postComment = commentService.findPostComment(postId);
        return ApiResponse.onSuccess(postComment);
    }

    @GetMapping(value = "/post/file/{postId}/comment/{commentId}/reply")
    public ApiResponse<ReplyCommentListResponse> findReplyCommentOfDochinZZal(@PathVariable Long postId,
                                                                              @PathVariable Long commentId) {
        ReplyCommentListResponse postReplyComment = commentService.findPostReplyComment(postId, commentId);
        return ApiResponse.onSuccess(postReplyComment);
    }

    @PostMapping(value = "/post/file/{postId}/comment")
    public ApiResponse<?> createComment(@PathVariable Long postId,
                                        @RequestBody CommentRequest commentRequest) {
        commentService.createComment(postId, commentRequest);
        return null;
    }

    @PostMapping(value = "/post/file/{commentId}/reply")
    public ApiResponse<?> createReplyComment(@PathVariable Long commentId,
                                             @RequestBody ReplyCommentRequest replyCommentRequest) {
        commentService.createReplyComment(commentId, replyCommentRequest);
        return null;
    }

    @GetMapping("/post/article/{postId}/{commentId}/reply")
    public ApiResponse<List<ReplyTalkCommentResponse>> getTalkPostReplyComments(@PathVariable Long postId,
                                                                                @PathVariable Long commentId) {
        List<ReplyTalkCommentResponse> replyComments = replyCommentService.getReplyCommentsForComment(postId, commentId);
        return ApiResponse.onSuccess(replyComments);
    }


    /**
     * 12. 특정 도친토크에 대한 댓글 조회
     */

    @GetMapping("/post/article/{postId}/comments")
    public ApiResponse<List<CommentTalkResponse>> getCommentsForPost(@PathVariable Long postId) {
        List<CommentTalkResponse> comments = commentService.getCommentsForPost(postId);
        return ApiResponse.onSuccess(comments);
    }
}
