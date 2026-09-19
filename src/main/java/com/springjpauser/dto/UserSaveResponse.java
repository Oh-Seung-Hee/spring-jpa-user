package com.springjpauser.dto;

import lombok.Getter;

@Getter
public class UserSaveResponse {

    private final Long id;
    private final String name;
    private final String email;
    private final String address;

    public UserSaveResponse(Long id, String name, String email, String address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
    }
}
