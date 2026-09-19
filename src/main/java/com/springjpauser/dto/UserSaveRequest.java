package com.springjpauser.dto;

import lombok.Getter;

@Getter
public class UserSaveRequest {

    private String name;
    private String email;
    private String address;
}
