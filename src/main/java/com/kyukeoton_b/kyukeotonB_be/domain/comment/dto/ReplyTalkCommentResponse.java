package com.kyukeoton_b.kyukeotonB_be.domain.comment.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ReplyTalkCommentResponse {
    private Long id;
    private String content;
}
