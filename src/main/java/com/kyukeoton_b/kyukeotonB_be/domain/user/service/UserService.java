package com.kyukeoton_b.kyukeotonB_be.domain.user.service;

import com.kyukeoton_b.kyukeotonB_be.domain.user.User;
import com.kyukeoton_b.kyukeotonB_be.domain.user.dto.UserResponse;
import com.kyukeoton_b.kyukeotonB_be.domain.user.exception.UserException;
import com.kyukeoton_b.kyukeotonB_be.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.kyukeoton_b.kyukeotonB_be.global.status.ErrorStatus.USER_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserResponse findMyPage(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new UserException(USER_NOT_FOUND));
        System.out.println("user.getFollower() = " + user.getFollower());

        return UserResponse.of(user);
    }


}
