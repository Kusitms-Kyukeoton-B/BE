package com.kyukeoton_b.kyukeotonB_be.domain.character;

import com.kyukeoton_b.kyukeotonB_be.domain.dopamine.Post;
import com.kyukeoton_b.kyukeotonB_be.domain.dopamine.PostType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CharacterRepository extends JpaRepository<Character, Long> {
    /**
     * 3. 캐릭터 조회
     */
    Character findByUserId(Long userId);
}
