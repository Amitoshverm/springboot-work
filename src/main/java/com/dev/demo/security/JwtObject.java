package com.dev.demo.security;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JwtObject {
    private Long userId;
    private String userName;
    private String email;

}
