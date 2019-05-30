package com.allthatBTS.payload;

import com.allthatBTS.atbserver.user.domain.User;
import lombok.Getter;

@Getter
public class UserResponse extends User {
    private String token;
    private String tokenType = "Bearer";

    public UserResponse(String token, User user){
        super(user);
        this.token = token;

    }
}
