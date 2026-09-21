package com.springjpauser.dto;

import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class UserSaveRequest {

    @Size(min = 4)
    private String name;
    private String email;
    private String address;
}
