package com.allthatBTS.atbserver.user;

import com.allthatBTS.atbserver.user.domain.oauth2.FacebookOAuth2UserInfo;
import com.allthatBTS.atbserver.user.domain.oauth2.GithubOAuth2UserInfo;
import com.allthatBTS.atbserver.user.domain.oauth2.GoogleOAuth2UserInfo;
import com.allthatBTS.atbserver.user.domain.oauth2.OAuth2UserInfo;
import com.allthatBTS.exception.SocialTypeNotExistException;

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
        } else {
            throw new SocialTypeNotExistException("Sorry! Login with " + registrationId + " is not supported yet.");
        }
    }
}
