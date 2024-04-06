package com.kyukeoton_b.kyukeotonB_be.domain.comment.dto;

import com.kyukeoton_b.kyukeotonB_be.domain.comment.Comment;
import com.kyukeoton_b.kyukeotonB_be.domain.comment.ReplyComment;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
public class ReplyCommentListResponse {
    private List<ReplyCommentResponse> replyCommentResponses;

    public static ReplyCommentListResponse of(List<ReplyComment> replyComments) {
        List<ReplyCommentResponse> replyCommentResponses = replyComments.stream()
                .map(r -> ReplyCommentResponse.of(r))
                .collect(Collectors.toList());

        return ReplyCommentListResponse.builder()
                .replyCommentResponses(replyCommentResponses)
                .build();
    }
}
