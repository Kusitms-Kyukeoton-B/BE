package com.kyukeoton_b.kyukeotonB_be.domain.dopamine;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
@Table(name = "post_category")
public class PostCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "post_category")
    private Category postCategory;

    @OneToOne(mappedBy = "postCategory")
    private Post post;
}
