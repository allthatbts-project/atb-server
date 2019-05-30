package com.allthatBTS.atbserver.user.domain.oauth2;

import java.util.Map;

public class KakaoOAuth2UserInfo extends OAuth2UserInfo {

    public KakaoOAuth2UserInfo(Map<String, Object> attributes) {
        super(attributes);
    }

    @Override
    public String getId() {
        return attributes.get("id").toString();
    }

    @Override
    public String getName() {
        return ((Map<String, String>)attributes.get("properties")).get("nickname");
    }

    @Override
    public String getEmail() {
        return ((Map<String, String>)attributes.get("properties")).get("email");
    }

    @Override
    public String getImageUrl() {
        return ((Map<String, String>)attributes.get("properties")).get("profile_image");
    }
}
