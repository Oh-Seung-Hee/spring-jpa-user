package com.springjpauser.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UserGetResponse {

    private final Long id;
    private final String name;
    private final String email;
    private final String address;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    public UserGetResponse(Long id, String name, String email, String address, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
