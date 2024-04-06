package com.kyukeoton_b.kyukeotonB_be.domain.dopamine.dto.request;

import com.kyukeoton_b.kyukeotonB_be.domain.dopamine.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PostRequest {
    private String title;
    private String subject;
    private String description;

    public static Post toEntity(PostRequest postRequest) {
        return Post.builder()
                .title(postRequest.title)
                .subject(postRequest.subject)
                .description(postRequest.description)
                .build();
    }
}
