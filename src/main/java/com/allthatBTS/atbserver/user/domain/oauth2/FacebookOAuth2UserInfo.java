package com.allthatBTS.atbserver.user.domain.oauth2;

import com.allthatBTS.config.constant.Constant;

import java.util.Map;

public class FacebookOAuth2UserInfo extends OAuth2UserInfo {
    public FacebookOAuth2UserInfo(Map<String, Object> attributes) {
        super(attributes);
    }

    @Override
    public String getId() {
        return (String) attributes.get("id");
    }

    @Override
    public String getName() {
        return (String) attributes.get("name");
    }

    @Override
    public String getEmail() {
        return (String) attributes.get("email");
    }

    @Override
    public String getImageUrl() {
        return Constant.FACEBOOK_GRAPH_URL + "/" + (String) attributes.get("id") + "/picture?type=large";
    }
}
