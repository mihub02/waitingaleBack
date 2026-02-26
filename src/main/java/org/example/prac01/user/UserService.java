package org.example.prac01.user;

import lombok.RequiredArgsConstructor;
import org.example.prac01.user.model.User;
import org.example.prac01.user.model.UserDto;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    // 이메일 중복 확인
    public UserDto.SignupRes signup(UserDto.SignupReq dto) {
        User user = dto.toEntity();
        userRepository.save(user);

        return UserDto.SignupRes.from(user);
    }
}
