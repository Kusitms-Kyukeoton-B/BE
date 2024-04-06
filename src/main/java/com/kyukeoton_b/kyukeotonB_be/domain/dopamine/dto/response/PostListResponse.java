package com.kyukeoton_b.kyukeotonB_be.domain.dopamine.dto.response;

import com.kyukeoton_b.kyukeotonB_be.domain.dopamine.Post;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
public class PostListResponse {
    private List<PostResponse> postList;

    public static PostListResponse of(List<Post> post) {
        List<PostResponse> postResponseList = post.stream()
                .map(p -> PostResponse.of(p))
                .collect(Collectors.toList());

        return PostListResponse.builder()
                .postList(postResponseList)
                .build();
    }

}
