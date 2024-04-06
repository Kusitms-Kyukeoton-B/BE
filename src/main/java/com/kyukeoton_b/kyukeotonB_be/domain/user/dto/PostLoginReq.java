package com.kyukeoton_b.kyukeotonB_be.domain.user.dto;

import com.kyukeoton_b.kyukeotonB_be.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostLoginReq {
    private String id;
    private String password;

    public User toEntity() {
        return User.builder()
                .id(this.id)
                .password(this.password)
                .build();
    }
}
