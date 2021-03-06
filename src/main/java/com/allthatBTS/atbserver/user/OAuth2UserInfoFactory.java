package com.allthatBTS.atbserver.user;

import com.allthatBTS.atbserver.user.domain.oauth2.*;
import com.allthatBTS.exception.ExceptionMessageType;
import com.allthatBTS.exception.OAuth2AuthenticationProcessingException;

import java.util.Map;

import static com.allthatBTS.atbserver.user.domain.enums.SocialType.*;

public class OAuth2UserInfoFactory {

    public static OAuth2UserInfo getOAuth2UserInfo(String registrationId, Map<String, Object> attributes) {
        if(registrationId.equalsIgnoreCase(GOOGLE.getValue())){
            return new GoogleOAuth2UserInfo(attributes);
        } else if (registrationId.equalsIgnoreCase(FACEBOOK.getValue())) {
            return new FacebookOAuth2UserInfo(attributes);
        } else if (registrationId.equalsIgnoreCase(GITHUB.getValue())) {
            return new GithubOAuth2UserInfo(attributes);
        }else if (registrationId.equalsIgnoreCase(KAKAO.getValue())) {
            return new KakaoOAuth2UserInfo(attributes);
        }else {
            throw new OAuth2AuthenticationProcessingException(registrationId + " " + ExceptionMessageType.NOT_SUPPORTED.getValue());
        }
    }
}
