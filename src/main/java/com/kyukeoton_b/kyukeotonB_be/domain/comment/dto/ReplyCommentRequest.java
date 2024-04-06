package com.kyukeoton_b.kyukeotonB_be.domain.comment.dto;

import com.kyukeoton_b.kyukeotonB_be.domain.comment.Comment;
import com.kyukeoton_b.kyukeotonB_be.domain.comment.ReplyComment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ReplyCommentRequest {
    private String content;

    public static ReplyComment toEntity(ReplyCommentRequest replyCommentRequest) {
        return ReplyComment.builder()
                .content(replyCommentRequest.content)
                .build();
    }
}
