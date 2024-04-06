package com.kyukeoton_b.kyukeotonB_be.domain.dopamine;

import com.kyukeoton_b.kyukeotonB_be.domain.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
@Table(name = "talk_category")
public class TalkCategory extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "talk_category")
    private Category talkCategory;

    @OneToOne(mappedBy = "talkCategory")
    private Post talk;
}
