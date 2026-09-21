package com.springjpauser.service;

import com.springjpauser.dto.*;
import com.springjpauser.entity.User;
import com.springjpauser.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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
                savedUser.getAddress(),
                savedUser.getCreatedAt(),
                savedUser.getModifiedAt()
        );
    }

    @Transactional(readOnly = true)
    public List<UserGetResponse> getAll() {
        List<User> users = userRepository.findAll();

        List<UserGetResponse> dtos = new ArrayList<>();
        for (User user : users) {
            UserGetResponse dto = new UserGetResponse(
                    user.getId(),
                    user.getName(),
                    user.getEmail(),
                    user.getAddress(),
                    user.getCreatedAt(),
                    user.getModifiedAt()
            );
            dtos.add(dto);
        }
        return dtos;
    }

    @Transactional(readOnly = true)
    public UserGetResponse getOne(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new IllegalStateException("없는 유저입니다.")
        );
        return new UserGetResponse(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getAddress(),
                user.getCreatedAt(),
                user.getModifiedAt()
        );
    }

    @Transactional
    public UserUpdateResponse update(Long userId, UserUpdateRequest request) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new IllegalStateException("없는 유저입니다.")
        );
        user.update(
                request.getName(), 
                request.getEmail(), 
                request.getAddress()
        );
        return new UserUpdateResponse(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getAddress(),
                user.getCreatedAt(),
                user.getModifiedAt()
        );
    }

    @Transactional
    public void delete(Long userId) {
        boolean existence = userRepository.existsById(userId);
        // 존재하지 않으면
        if (!existence) {
            throw new IllegalStateException("없는 유저입니다.");
        }

        // 존재하면
        userRepository.deleteById(userId);
    }
}
