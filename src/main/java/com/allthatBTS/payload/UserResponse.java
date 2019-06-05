package com.allthatBTS.payload;

import lombok.Builder;
import lombok.Getter;

@Getter
public class UserResponse{
    private Long id;
    private String name;
    private String imageUrl;
    private String token;
    private String tokenType = "Bearer";

    @Builder
    public UserResponse(Long id, String name, String imageUrl, String token){
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
        this.token = token;
    }
}
