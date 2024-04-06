package com.kyukeoton_b.kyukeotonB_be.domain.dopamine.dto.response;

import com.kyukeoton_b.kyukeotonB_be.domain.dopamine.Post;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PostResponse {
    private Long postId;
    private String title;
    private String image;

    public static PostResponse of(Post post) {
        String image = null;
        if (post.getDopamineImg() != null && post.getDopamineVideo() == null) {
            image = post.getDopamineImg();
        }
        if (post.getDopamineImg() == null && post.getDopamineVideo() != null) {
            image = post.getDopamineVideo();
        }
        return PostResponse.builder()
                .postId(post.getId())
                .title(post.getTitle())
                .image(post.getDopamineImg())
                .build();
    }

}
