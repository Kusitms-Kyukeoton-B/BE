package com.kyukeoton_b.kyukeotonB_be.domain.comment.dto;

import com.kyukeoton_b.kyukeotonB_be.domain.comment.ChooseSide;
import com.kyukeoton_b.kyukeotonB_be.domain.comment.Comment;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CommentResponse {
    private Long id;
    private String content;

    public static CommentResponse of(Comment comment) {
        return CommentResponse.builder()
                .id(comment.getId())
                .content(comment.getContent())
                .build();
    }

}


