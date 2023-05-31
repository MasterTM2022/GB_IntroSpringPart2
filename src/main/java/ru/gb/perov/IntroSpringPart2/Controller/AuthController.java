package ru.gb.perov.IntroSpringPart2.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import ru.gb.perov.IntroSpringPart2.Security.AuthRequest;
import ru.gb.perov.IntroSpringPart2.Security.AuthResponce;

@Slf4j
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/token")
    public AuthResponce auth(@RequestBody AuthRequest request) {
        log.info("*** Request from {} ***", request.getUserName());
        Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUserName(), request.getPassword())
        );
        return new AuthResponce("tokenValue");
    }
}
