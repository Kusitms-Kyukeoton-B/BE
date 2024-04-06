package com.kyukeoton_b.kyukeotonB_be.domain.character;


import com.kyukeoton_b.kyukeotonB_be.global.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class CharacterController {
    public final CharacterService characterService;

    /**
     * 3. 캐릭터 조회
     */

    @GetMapping("/user/{userId}/character")
    public ApiResponse<CharacterResponse> getCharacterByUserId(@PathVariable Long userId) {
        CharacterResponse characterByUserId = characterService.getCharacterByUserId(userId);
        return ApiResponse.onSuccess(characterByUserId);
    }
    


}
