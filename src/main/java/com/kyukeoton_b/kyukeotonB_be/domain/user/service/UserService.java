package com.kyukeoton_b.kyukeotonB_be.domain.user.service;

import com.kyukeoton_b.kyukeotonB_be.domain.user.repository.UserJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
//@Transactional
@RequiredArgsConstructor
public class UserService {
    private final UserJpaRepository userJpaRepository;
}
