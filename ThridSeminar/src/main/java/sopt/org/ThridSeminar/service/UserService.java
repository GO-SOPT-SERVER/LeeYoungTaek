package sopt.org.ThridSeminar.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sopt.org.ThridSeminar.controller.dto.request.UserRequestDto;
import sopt.org.ThridSeminar.controller.dto.response.UserResponseDto;
import sopt.org.ThridSeminar.domain.User;
import sopt.org.ThridSeminar.infrastructure.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public UserResponseDto create(UserRequestDto request) {
        User user = User.builder()
                .email(request.getEmail())
                .nickname(request.getNickname())
                .password(request.getPassword())
                .build();

        userRepository.save(user);

        return UserResponseDto.of(user.getId(), user.getNickname());
    }
}