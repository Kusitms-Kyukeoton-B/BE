package com.kyukeoton_b.kyukeotonB_be.domain.user;

import com.kyukeoton_b.kyukeotonB_be.domain.BaseEntity;
import javax.persistence.*;

import lombok.*;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "user")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class User extends BaseEntity {
    //유저 인덱스
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private Long userId;

    // 아이디
    @Column
    private String id;

//    @Column(nullable = false)
//    private String uuid;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private String name;

    @Column
    private String nickname;

    @Column
    private LocalDate birthDate;

    @Column
    private String profileImg;


    @Builder
    public User(String id, String uuid, String email, String password, String name, String nickname,
                LocalDate birthDate, String profileImg){
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.nickname = nickname;
        this.birthDate = birthDate;
        this.profileImg = profileImg;
    }
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        List<GrantedAuthority> authorities = new ArrayList<>();
//        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
//        return authorities;
//    }
//    @Override
//    public String getPassword() {
//        return password;
//    }
//    @Override
//    public String getUsername() {
//        return uuid;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
}