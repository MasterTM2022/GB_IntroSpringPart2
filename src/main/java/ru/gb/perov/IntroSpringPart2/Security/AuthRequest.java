package ru.gb.perov.IntroSpringPart2.Security;

import lombok.Getter;

@Getter
public class AuthRequest {
    private String userName;
    private String password;
}
