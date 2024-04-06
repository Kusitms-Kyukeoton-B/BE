package com.kyukeoton_b.kyukeotonB_be.domain.comment.dto;

import com.kyukeoton_b.kyukeotonB_be.domain.comment.ChooseSide;
import com.kyukeoton_b.kyukeotonB_be.domain.comment.Comment;
import com.kyukeoton_b.kyukeotonB_be.domain.dopamine.Post;
import com.kyukeoton_b.kyukeotonB_be.domain.dopamine.dto.response.PostListResponse;
import com.kyukeoton_b.kyukeotonB_be.domain.dopamine.dto.response.PostResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
public class CommentListResponse {
    private List<CommentResponse> commentResponseList;

    public static CommentListResponse of(List<Comment> comments) {
        List<CommentResponse> commentResponses = comments.stream()
                .map(c -> CommentResponse.of(c))
                .collect(Collectors.toList());

        return CommentListResponse.builder()
                .commentResponseList(commentResponses)
                .build();
    }
}
