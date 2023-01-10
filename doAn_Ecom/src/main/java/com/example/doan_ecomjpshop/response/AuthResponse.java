package com.example.doan_ecomjpshop.response;

import com.example.doan_ecomjpshop.entity.Manager;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AuthResponse implements Serializable {
    private Manager user;
    private String token;
    @JsonProperty("isAuthenticated")
    private boolean isAuthenticated;
}
