package com.allthatBTS.atbserver.user;

import com.allthatBTS.atbserver.user.domain.annotation.SocialUser;
import com.allthatBTS.atbserver.user.domain.User;
import com.allthatBTS.config.constant.Constant;
import com.allthatBTS.exception.OAuth2AuthenticationProcessingException;
import com.allthatBTS.payload.UserResponse;
import com.allthatBTS.util.CookieUtils;
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

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
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
    public ResponseEntity<UserResponse> getUser(HttpServletRequest request, HttpServletResponse response){
        String token = CookieUtils.getCookie(request, Constant.TOKEN)
                .map(Cookie::getValue).orElse(null);

        if(token == null){
            // error handling
            throw new OAuth2AuthenticationProcessingException("token is not exist");
        }
        Long userId = tokenProvider.getUserIdFromJWT(token);
        Optional<User> user = userRepository.findById(userId);
        CookieUtils.deleteCookie(request, response, Constant.TOKEN);

        return new ResponseEntity(UserResponse.builder()
                .id(user.get().getId())
                .name(user.get().getName())
                .imageUrl(user.get().getImageUrl())
                .token(token)
                .build(), HttpStatus.OK);
    }
}
