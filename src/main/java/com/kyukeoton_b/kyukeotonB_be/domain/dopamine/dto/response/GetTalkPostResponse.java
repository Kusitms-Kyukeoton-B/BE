package com.kyukeoton_b.kyukeotonB_be.domain.dopamine.dto.response;

import com.kyukeoton_b.kyukeotonB_be.domain.dopamine.PostCategory;
import com.kyukeoton_b.kyukeotonB_be.domain.dopamine.PostType;
import com.kyukeoton_b.kyukeotonB_be.domain.dopamine.TalkCategory;
import com.kyukeoton_b.kyukeotonB_be.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class GetTalkPostResponse {
    private String questionTitle;

    private String leftQuestion;

    private String rightQuestion;

    private TalkCategory talkCategory;
}