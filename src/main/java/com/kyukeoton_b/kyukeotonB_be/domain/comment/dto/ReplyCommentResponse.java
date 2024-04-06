package com.kyukeoton_b.kyukeotonB_be.domain.comment.dto;

import com.kyukeoton_b.kyukeotonB_be.domain.comment.Comment;
import com.kyukeoton_b.kyukeotonB_be.domain.comment.ReplyComment;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ReplyCommentResponse {
    private Long id;
    private String content;

    public static ReplyCommentResponse of(ReplyComment replyComment) {
        return ReplyCommentResponse.builder()
                .id(replyComment.getId())
                .content(replyComment.getContent())
                .build();
    }
}

