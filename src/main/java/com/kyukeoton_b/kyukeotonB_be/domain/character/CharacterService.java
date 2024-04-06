package com.kyukeoton_b.kyukeotonB_be.domain.character;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CharacterService {
    private final CharacterRepository characterRepository;

    /**
     * 3. 캐릭터 조회
     */
    public CharacterResponse getCharacterByUserId(Long userId) {
        Character byUserId = characterRepository.findByUserId(userId);
        CharacterResponse characterResponse = CharacterResponse.of(byUserId);
        return characterResponse;

    }
}
