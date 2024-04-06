package com.kyukeoton_b.kyukeotonB_be.domain.user;

import com.kyukeoton_b.kyukeotonB_be.domain.BaseEntity;
import javax.persistence.*;

import lombok.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
@Table(name = "user")
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "login_id")
    private String loginId;

    @Column(name = "name")
    private String name;

    @Column(name = "user_profile_image")
    private String userProfileImg;

    @Column(name = "point")
    private Integer point;
}