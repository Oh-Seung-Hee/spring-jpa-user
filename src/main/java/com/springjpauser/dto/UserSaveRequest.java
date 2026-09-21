package com.springjpauser.dto;

import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class UserSaveRequest {

    @Size(min = 4, message = "name은 4글자 이상이어야합니다.")
    private String name;
    private String email;
    private String address;
}
