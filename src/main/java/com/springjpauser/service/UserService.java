package com.springjpauser.service;

import com.springjpauser.dto.UserSaveRequest;
import com.springjpauser.dto.UserSaveResponse;
import com.springjpauser.entity.User;
import com.springjpauser.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public UserSaveResponse save(UserSaveRequest request) {
        User user = new User(
                request.getName(),
                request.getEmail(),
                request.getAddress()
        );
        User savedUser = userRepository.save(user);
        return new UserSaveResponse(
                savedUser.getId(),
                savedUser.getName(),
                savedUser.getEmail(),
                savedUser.getAddress()
        );
    }
}
