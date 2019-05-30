package com.allthatBTS.atbserver.user;

import com.allthatBTS.atbserver.user.domain.annotation.SocialUser;
import com.allthatBTS.atbserver.user.domain.User;
import com.allthatBTS.exception.OAuth2AuthenticationProcessingException;
import com.allthatBTS.payload.UserResponse;
import com.allthatBTS.util.JwtTokenProvider;
import io.jsonwebtoken.Jwt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserRepository userRepository;

    private final JwtTokenProvider tokenProvider;

    UserController(UserRepository userRepository, JwtTokenProvider tokenProvider){
        this.userRepository = userRepository;
        this.tokenProvider = tokenProvider;
    }

    @GetMapping
    public ResponseEntity<UserResponse> getUser(@CookieValue(value = "token", required = false) String token){
        if(token == null){
            // error handling
            throw new OAuth2AuthenticationProcessingException("token is not exist");
        }
        Long userId = tokenProvider.getUserIdFromJWT(token);
        Optional<User> user = userRepository.findById(userId);
        return new ResponseEntity(new UserResponse(token, user.get()), HttpStatus.OK);
    }
}
