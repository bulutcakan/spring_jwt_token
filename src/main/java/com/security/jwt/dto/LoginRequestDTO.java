package com.security.jwt.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Getter
@Setter
public class LoginRequestDTO implements Serializable {

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    public LoginRequestDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }

}
