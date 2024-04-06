package com.kyukeoton_b.kyukeotonB_be.domain.character;

import com.kyukeoton_b.kyukeotonB_be.domain.BaseEntity;
import com.kyukeoton_b.kyukeotonB_be.domain.user.User;
import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
@Table(name = "character")
public class Character extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "character_status")
    private CharacterStatus characterStatus;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "score")
    private Integer score;
}
