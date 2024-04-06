package com.kyukeoton_b.kyukeotonB_be.domain.user.dto;

import com.kyukeoton_b.kyukeotonB_be.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserResponse {
    private Long id;
    private String introduction;
    private String name;
    private String userProfileImg;
    private Integer point;
    private Integer follower;
    private Integer following;

    public static UserResponse of(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .introduction(user.getIntroduction())
                .name(user.getName())
                .userProfileImg(user.getUserProfileImg())
                .point(user.getPoint())
                .follower(user.getFollower())
                .following(user.getFollowing())
                .build();
    }

}
