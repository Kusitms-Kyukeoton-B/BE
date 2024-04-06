package com.kyukeoton_b.kyukeotonB_be.domain.dopamine.dto.request;

import com.kyukeoton_b.kyukeotonB_be.domain.dopamine.TalkCategory;
import com.kyukeoton_b.kyukeotonB_be.domain.user.User;
import lombok.*;
@Setter
@Getter
@Builder
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class PostTalkPostRequest {
    private String questionTitle;
    private String leftQuestion;
    private String rightQuestion;
    private TalkCategory talkCategory;
    private User user;
}