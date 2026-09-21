package com.springjpauser.controller;

import com.springjpauser.dto.*;
import com.springjpauser.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/users")
    public ResponseEntity<UserSaveResponse> saved(
            @Valid @RequestBody UserSaveRequest request
            ) {
        return ResponseEntity.ok(userService.save(request));
    }

    //전체 조회
    @GetMapping("/users")
    public ResponseEntity<List<UserGetResponse>> getAll() {
        return ResponseEntity.ok(userService.getAll());
    }

    // 단 건 조회
    @GetMapping("/users/{userId}")
    public ResponseEntity<UserGetResponse> getOne(
            @PathVariable Long userId
    ) {
        return ResponseEntity.ok(userService.getOne(userId));
    }

    // 업데이트
    @PutMapping("/users/{userId}")
    public ResponseEntity<UserUpdateResponse> update(
            @PathVariable Long userId,
            @RequestBody UserUpdateRequest request
    ) {
        return ResponseEntity.ok(userService.update(userId, request));
    }

    // 삭제
    @DeleteMapping("/users/{userId}")
    public void delete(
            @PathVariable Long userId
    ) {
        userService.delete(userId);
    }
}
