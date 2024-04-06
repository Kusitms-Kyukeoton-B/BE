package com.kyukeoton_b.kyukeotonB_be.domain.comment.dto;

import com.kyukeoton_b.kyukeotonB_be.domain.comment.ChooseSide;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CommentTalkResponse {
    private Long id;
    private String content;
    private ChooseSide chooseSide;
}
