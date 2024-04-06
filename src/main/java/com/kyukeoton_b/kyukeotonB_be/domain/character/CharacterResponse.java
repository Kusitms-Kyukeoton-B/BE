package com.kyukeoton_b.kyukeotonB_be.domain.character;

import com.kyukeoton_b.kyukeotonB_be.domain.user.User;
import com.kyukeoton_b.kyukeotonB_be.domain.user.dto.UserResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CharacterResponse {
    private Long id;
    private CharacterStatus characterStatus;

    private Integer score;
    private UserResponse userResponse;

    public static CharacterResponse of(Character character) {
        User user = character.getUser();

        UserResponse userResponse = UserResponse.of(user);
        return CharacterResponse.builder()
                .id(character.getId())
                .characterStatus(character.getCharacterStatus())
                .score(character.getScore())
                .userResponse(userResponse)
                .build();
    }


}
